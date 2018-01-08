package org.jugru.monkeyStatistics.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;

import org.jugru.monkeyStatistics.model.Response;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.SurveyPage;
import org.jugru.monkeyStatistics.repository.SurveyRepository;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Transactional()
@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyRepository surveyRepository;

    
    @Override
    public Survey save(Survey survey) {
        return surveyRepository.saveAndFlush(survey);
    }

    // TODO вернуть обратно после написания query по вложнным коллекциям
    //@Cacheable(cacheNames = "survey",  key="{ #root.methodName, #id}")
    @Override
    public Survey get(long id) {
        return surveyRepository.findOne(id);
    }

    
    @Override
    public void delete(Survey survey) {
        surveyRepository.delete(survey);
    }

    @Cacheable(cacheNames = "listOfSurveys")
    @Override
    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }

    @Cacheable(cacheNames = "countById",  key="{#root.methodName, #id}")
    @Override
    public int countResponsesBySurveyId(Long id) {
        return surveyRepository.findOne(id).getResponses().size(); //TODO написать запрос на count
    }

    @Cacheable(cacheNames = "listOfSurveyPage",  key="{ #root.methodName, #id}")
    @Override
    public List<SurveyPage> getSurveyPagesFromSurvey(Long id) {
        return surveyService.get(id).getPages();
    }

    @Cacheable(cacheNames = "getIdById",  key="{ #root.methodName, #id}")
    @Override
    public Long findSurveyIdByQuestionMetaInformationId(Long id) {
        return surveyRepository.findSurveyIdByQuestionMetaInformationId(id);
    }

    @Transactional
    @Override
    public void addNewResponses(Survey s, Collection<Response> c) {
        s.getResponses().size(); //TODO
        s.addNewResponses(c);
    }

    @Cacheable(cacheNames = "stringsById",  key="{ #root.methodName, #id}")
    @Override
    public String getSurveyNameBySurveyId(Long id) {
        return surveyService.get(id).getTitle();
    }
}
