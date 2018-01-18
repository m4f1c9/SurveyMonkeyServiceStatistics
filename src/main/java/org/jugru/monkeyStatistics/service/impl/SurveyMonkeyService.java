package org.jugru.monkeyStatistics.service.impl;

import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

    private void parseAndSaveDetailedSurvey(Survey survey) {
        if (survey.isConferenceSurvey() && !survey.isWithDetails()) {
            Survey result = surveyMonkeyClient.getSurvey(survey.getId());
            result.getSurveyUserInformation().setWithDetails(true);
            result.getSurveyUserInformation().setConferenceSurvey(surveyService.get(survey.getId()).isConferenceSurvey());
            surveyService.save(result);
        }
    }

    // @Scheduled(cron = "0 1 1 * * *", zone = "Europe/Moscow")
    @CacheEvict(value = {"countById", "getIdById", "stringsById", "booleanById"}, allEntries = true)
    public void updateAll() {
        synchronized (lock) {
            parseAndSaveAllNewSurveys();
            surveyService.getAll().forEach(this::parseAndSaveDetailedSurvey);
            surveyService.refreshAnswers();
        }
    }
}
