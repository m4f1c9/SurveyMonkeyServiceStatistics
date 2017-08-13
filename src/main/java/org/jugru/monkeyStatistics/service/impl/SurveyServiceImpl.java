package org.jugru.monkeyStatistics.service.impl;

import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.repository.SurveyRepository;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Survey addSurvey(Survey survey) {
        return surveyRepository.saveAndFlush(survey);
    }
    
    

}
