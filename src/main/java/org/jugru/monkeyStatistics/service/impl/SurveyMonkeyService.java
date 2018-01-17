package org.jugru.monkeyStatistics.service.impl;

import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SurveyMonkeyService {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyMonkeyClient surveyMonkeyClient;


    public void parseAndSaveAllNewSurveys() {
        List<Survey> fromDB = surveyService.getAll();
        List<Survey> fromSurveyMonkey = surveyMonkeyClient.getAllSurveys();
        fromSurveyMonkey.removeAll(fromDB);
        fromSurveyMonkey.forEach(this::parseAndSaveDetailedSurvey);
    }

    public void parseAndSaveDetailedSurvey(Survey survey) {
        // TODO запретить повторное сохранение (дублирование) 
        Survey result = surveyMonkeyClient.getSurvey(survey.getId());
        surveyService.save(result);
    }

    // TODO убрать разобратся с сессией
    //   @Transactional
    public void refreshAnswers() {
        surveyService.getAll().stream().
                filter(Survey::isConferenceSurvey).
                peek(surveyService::addNewResponses).
                peek(surveyService::parseAndSetStatus).
                forEach(surveyService::save);
    }
}
