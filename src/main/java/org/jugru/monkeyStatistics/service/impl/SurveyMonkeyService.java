package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        result.setWithDetails(true);
        surveyService.save(result);
    }

    // TODO убрать разобратся с сессией
    @Transactional
    public void refreshAnswers() {
        surveyService.getAll().stream().
                filter((t) -> {
                    return !Objects.equals(t.getStatus(), "closed");
                }).
                limit(5).
                peek((survey) -> {
                    survey.addNewResponses(surveyMonkeyClient.getAllResponsesBySurveyId(survey.getId()));
                }).
                peek((survey) -> {
                 //   survey.setStatus(surveyMonkeyClient.getSurveyStatus(survey));
                     survey.setStatus("closed");
                }).
                forEach(surveyService::save);
    }

}
