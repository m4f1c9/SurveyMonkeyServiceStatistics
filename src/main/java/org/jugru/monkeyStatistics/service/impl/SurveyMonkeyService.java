package org.jugru.monkeyStatistics.service.impl;

import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SurveyMonkeyService {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyMonkeyClient surveyMonkeyClient;

    private Logger logger = LoggerFactory.getLogger(SurveyMonkeyService.class);

    private static Object lock = new Object();


    private void parseAndSaveAllNewSurveys() {
        List<Survey> fromDB = surveyService.getAll();
        List<Survey> fromSurveyMonkey = surveyMonkeyClient.getAllSurveys();
        fromSurveyMonkey.removeAll(fromDB);
        fromSurveyMonkey.parallelStream().forEach(surveyService::save);
    }

    public void parseAndSaveDetailedSurvey(Survey survey) {
        synchronized (lock) {
            if (survey.isConferenceSurvey() && !survey.isWithDetails()) {
                try {
                    Survey result = surveyMonkeyClient.getSurvey(survey.getId());
                    result.getSurveyUserInformation().setWithDetails(true);
                    result.getSurveyUserInformation().setProcessed(true);
                    result.getSurveyUserInformation().setConferenceSurvey(surveyService.get(survey.getId()).isConferenceSurvey());
                    surveyService.save(result);
                } catch (Exception e) {
                    logger.error("parseAndSaveDetailedSurvey Survey id is " + survey.getId(), e); //игнорируем ошибку и парсим дальше
                }
            }
        }
    }

    @Scheduled(cron = "0 1 4 * * *", zone = "Europe/Moscow")
    @CacheEvict(value = {"countById", "getIdById", "stringsById", "booleanById"}, allEntries = true)
    public void updateAll() {
        synchronized (lock) {
            logger.debug("updateAll");
            parseAndSaveAllNewSurveys();
            surveyService.getAll().forEach(this::parseAndSaveDetailedSurvey);
            surveyService.refreshAnswers();
        }
    }

}
