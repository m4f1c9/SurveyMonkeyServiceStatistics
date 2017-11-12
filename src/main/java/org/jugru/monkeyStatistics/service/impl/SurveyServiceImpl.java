package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.repository.SurveyRepository;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Transactional
    @Override
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Transactional
    @Override
    public Survey get(long id) {
        return surveyRepository.findOne(id);
    }

    @Transactional
    @Override
    public void delete(Survey survey) {
        surveyRepository.delete(survey);
    }

    @Transactional
    @Override
    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }

    @Transactional
    @Override
    public int countAnswers(long id) {
        return surveyRepository.findOne(id).getResponses().size(); //TODO написать запрос на count  
    }

    
    
}
