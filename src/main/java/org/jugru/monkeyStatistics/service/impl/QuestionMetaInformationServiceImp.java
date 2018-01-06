package org.jugru.monkeyStatistics.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.jugru.monkeyStatistics.model.AnswerMetaInformation;
import org.jugru.monkeyStatistics.model.Choice;
import org.jugru.monkeyStatistics.model.ChoiceOrRow;
import org.jugru.monkeyStatistics.model.Other;
import org.jugru.monkeyStatistics.model.QuestionMetaInformation;
import org.jugru.monkeyStatistics.model.Row;
import org.jugru.monkeyStatistics.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.jugru.monkeyStatistics.repository.QuestionMetaInformationRepository;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class QuestionMetaInformationServiceImp implements QuestionMetaInformationService {

    @Autowired
    private QuestionMetaInformationService questionMetaInformationService;

    @Autowired
    private QuestionMetaInformationRepository questionMetaInformationRepository;
    @Autowired
    private SurveyService surveyService;

    @Override
    public QuestionMetaInformation save(QuestionMetaInformation t) {
        return questionMetaInformationRepository.save(t);
    }

    @Cacheable(cacheNames = "questionMetaInformation")
    @Override
    public QuestionMetaInformation get(long id) {
        return questionMetaInformationRepository.findOne(id);
    }

    @Override
    public void delete(QuestionMetaInformation t) {
        questionMetaInformationRepository.delete(t);
    }

    @Cacheable(cacheNames = "listOfQuestionMetaInformation", key = "{ #root.methodName}")
    @Override
    public List<QuestionMetaInformation> getAll() {
        return questionMetaInformationRepository.findAll();
    }

    @Cacheable(cacheNames = "getIdById", key = "{ #root.methodName, #id}")
    @Override
    public Long getOther_idByQuestionMetaInformationId(Long id) {

        return Optional.
                ofNullable(questionMetaInformationRepository.findOne(id)).
                map(QuestionMetaInformation::getAnswers).
                map(AnswerMetaInformation::getOther).
                map(Other::getId).orElse(null);
    }

    @Cacheable(cacheNames = "listOfChoice")
    @Override
    public List<Choice> getChoicesByQuestionMetaInformationId(Long id) {
        return questionMetaInformationRepository.getChoicesByQuestionMetaInformationId(id);
    }

    @Cacheable(cacheNames = "listOfRow")
    @Override
    public List<Row> getRowsByQuestionMetaInformationId(Long id) {
        return questionMetaInformationRepository.getRowsByQuestionMetaInformationId(id);
    }


    public List<? extends ChoiceOrRow> getChoiceOrRowsByQuestionMetaInformationId(Long id, boolean UseRow_idInstedOfChoice_id) {
        if (UseRow_idInstedOfChoice_id) {
            return questionMetaInformationService.getRowsByQuestionMetaInformationId(id);
        } else {
            return questionMetaInformationService.getChoicesByQuestionMetaInformationId(id);
        }
    }

    @Transactional
    @Override
    public List<QuestionMetaInformation> getQuestionMetaInformationBySurveyId(Long id) {
        List<QuestionMetaInformation> list = new ArrayList<>();
        Survey survey = surveyService.get(id);
        survey.getPages().forEach((t) -> {
            List<QuestionMetaInformation> list2 = t.getQuestions();
            list.addAll(list2);
        });
        return list;
    }

    @Cacheable(cacheNames = "countById", key = "{ #root.methodName, #id}")
    public Integer countChoicesByQuestionMetaInformationId(Long id) {
        return questionMetaInformationService.get(id).getAnswers().getChoices().size();
    }

    @Cacheable(cacheNames = "countById", key = "{ #root.methodName, #id}")
    public Integer countRowsByQuestionMetaInformationId(Long id) {
        return questionMetaInformationService.get(id).getAnswers().getRows().size();
    }

    @Cacheable(cacheNames = "getIdById", key = "{ #root.methodName, #id}")
    public Long findQuestionMetaInformationIdByChoiceId(Long id) {
        return questionMetaInformationRepository.findQuestionMetaInformationIdByChoiceId(id);
    }

    @Cacheable(cacheNames = "getIdById", key = "{ #root.methodName, #id}")
    public Long findQuestionMetaInformationIdByRowId(Long id) {
        return questionMetaInformationRepository.findQuestionMetaInformationIdByRowId(id);
    }


    @Cacheable(cacheNames = "stringsById", key = "{ #root.methodName, #id}")
    @Override
    public String getHeadingAsStringFromQuestionMetaInformationId(Long id) {
        QuestionMetaInformation q = questionMetaInformationService.get(id);
        StringBuilder sb = new StringBuilder();
        q.getHeadings().forEach(sb::append);
        return sb.toString();
    }

    /**
     * Если Choices больше или равно, используем их
     * в противном случае используем Rows
     */
    @Cacheable(cacheNames = "booleanById", key = "{ #root.methodName, #id}")
    @Override
    public boolean isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(Long id) {
        return (questionMetaInformationRepository.countAvailableRowsByQuestionMetaInformationId(id) >=
                questionMetaInformationRepository.countAvailableChoicesByQuestionMetaInformationId(id));
    }
}
