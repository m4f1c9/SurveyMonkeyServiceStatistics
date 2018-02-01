package org.jugru.monkeyStatistics.service.impl;

import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.model.Response;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.SurveyPage;
import org.jugru.monkeyStatistics.repository.SurveyRepository;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.IdNamePair;
import org.jugru.monkeyStatistics.util.SurveyMetaInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


@Service
public class SurveyServiceImpl implements SurveyService {

    Logger logger = LoggerFactory.getLogger(SurveyService.class);
    private static int MAXIMUM_FORK_JOIN_POOL_SIZE = 1;

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    SurveyMonkeyClient surveyMonkeyClient;

    @Autowired
    SurveyMonkeyService surveyMonkeyService;

    @Transactional()
    @Override
    public Survey save(Survey survey) {
        logger.debug("Save survey {}", survey);
        return surveyRepository.saveAndFlush(survey);
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
    @Cacheable(cacheNames = "countById", key = "{#root.methodName, #id}")
    @Override
    public int countResponsesBySurveyId(Long id) {
        return surveyRepository.findOne(id).getResponses().size(); //TODO написать запрос на count
    }

    @Transactional
    @Override
    public List<SurveyPage> getSurveyPagesFromSurvey(Long id) {
        return surveyService.get(id).getPages();
    }

    @Transactional
    @Cacheable(cacheNames = "getIdById", key = "{ #root.methodName, #id}")
    @Override
    public Long findSurveyIdByQuestionMetaInformationId(Long id) {
        return surveyRepository.findSurveyIdByQuestionMetaInformationId(id);
    }

    @Transactional
    @Override
    public void addNewResponses(Survey survey) {
        Collection<Response> c = surveyMonkeyClient.getAllResponsesBySurveyId(survey.getId());
        survey.getResponses().size(); //TODO
        survey.addNewResponses(c);
    }

    @Transactional
    @Override
    public void parseAndSetStatus(Survey s) {
        s.getSurveyUserInformation().setStatus(surveyMonkeyClient.getSurveyStatus(s));
    }

    @Transactional
    @Cacheable(cacheNames = "stringsById", key = "{ #root.methodName, #id}")
    @Override
    public String getSurveyNameBySurveyId(Long id) {
        return Optional.ofNullable(surveyService.get(id)).map(Survey::getTitle).orElse("");
    }

    @Transactional
    @Override
    public Set<IdNamePair> getIdNamePairOfSurveys() {
        List<Survey> surveys = surveyService.getAll();
        Set<IdNamePair> pairs = new TreeSet<>();
        surveys.forEach((t) -> {
            if (t.isConferenceSurvey()) {
                pairs.add(new IdNamePair(t.getId(), t.getTitle()));
            }
        });
        return pairs;
    }

    @Transactional
    @Override
    public Set<SurveyMetaInformation> getSurveyMetaInformationOfNewSurveys() {
        List<Survey> list = surveyService.getAll();
        Set<SurveyMetaInformation> answer = new TreeSet<>();
        for (Survey s : list) {
            Boolean isProcessed = s.getSurveyUserInformation().getProcessed();
            if (isNull(isProcessed) || !isProcessed) {
                SurveyMetaInformation smi = new SurveyMetaInformation();
                smi.setId(s.getId());
                smi.setName(s.getTitle());
                smi.setConferenceSurvey(s.getSurveyUserInformation().getConferenceSurvey());
                smi.setProcessed(false);
                answer.add(smi);
            }
        }
        return answer;
    }

    @Transactional
    @Override
    public Set<SurveyMetaInformation> getSurveyMetaInformationOfAllSurveys() {
        List<Survey> list = surveyService.getAll();
        Set<SurveyMetaInformation> answer = new TreeSet<>();
        for (Survey s : list) {
            SurveyMetaInformation smi = new SurveyMetaInformation();
            smi.setId(s.getId());
            smi.setName(s.getTitle());
            smi.setConferenceSurvey(s.getSurveyUserInformation().getConferenceSurvey());
            Boolean isProcessed = s.getSurveyUserInformation().getProcessed();
            smi.setProcessed(nonNull(isProcessed) && isProcessed);
            answer.add(smi);
        }
        return answer;
    }

    @Transactional
    @Override
    public void setConferenceSurvey(Long id, boolean isConferenceSurvey) {
        Survey survey = surveyService.get(id);
        survey.getSurveyUserInformation().setProcessed(true);
        survey.getSurveyUserInformation().setConferenceSurvey(isConferenceSurvey);
        surveyService.save(survey);
        if (isConferenceSurvey && !survey.isWithDetails()) {
            new Thread(() -> surveyMonkeyService.parseAndSaveDetailedSurvey(survey)).run();
        }
    }


    @Override
    public void refreshAnswers() {
        List<Survey> surveys = surveyService.getAll();
        if (!surveys.isEmpty()) {
            ForkJoinPool forkJoinPool = new ForkJoinPool(surveys.size() > MAXIMUM_FORK_JOIN_POOL_SIZE ? MAXIMUM_FORK_JOIN_POOL_SIZE : surveys.size());
            forkJoinPool.submit(() -> surveyService.getAll().stream().parallel().
                    filter(Survey::isConferenceSurvey).
                    filter(survey -> !"closed".equals(survey.getSurveyUserInformation().getStatus())).
                    filter(Survey::isWithDetails). //не должно ничего фильтровать при нормальной работе
                    forEach(this::refreshAnswers));
        }
    }

    @Transactional
    protected void refreshAnswers(Survey survey) {
        try {
            surveyService.addNewResponses(survey);
            surveyService.parseAndSetStatus(survey);
            surveyService.save(survey);
        } catch (Exception e) {
            logger.error("refreshAnswers Survey id is " + survey.getId(), e); //игнорируем ошибку и парсим дальше
        }
    }
}