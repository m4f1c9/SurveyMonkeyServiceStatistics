package org.jugru.monkeyStatistics.service;


import org.jugru.monkeyService.model.Survey;

public interface SurveyService extends Service<Survey> {
    int countAnswers (long id);

}
