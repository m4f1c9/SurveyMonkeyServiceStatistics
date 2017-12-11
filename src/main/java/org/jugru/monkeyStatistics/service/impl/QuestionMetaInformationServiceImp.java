package org.jugru.monkeyStatistics.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.AnswerMetaInformation;
import org.jugru.monkeyService.model.Choice;
import org.jugru.monkeyService.model.ChoiceOrRow;
import org.jugru.monkeyService.model.Other;
import org.jugru.monkeyService.model.QuestionMetaInformation;
import org.jugru.monkeyService.model.Row;
import org.jugru.monkeyService.model.Survey;
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
    private QuestionMetaInformationRepository questionMetaInformationRepository;
    @Autowired
    private SurveyService surveyService;

    @Override
    public QuestionMetaInformation save(QuestionMetaInformation t) {
        return questionMetaInformationRepository.save(t);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public QuestionMetaInformation get(long id) {
        return questionMetaInformationRepository.findOne(id);
    }

    @Override
    public void delete(QuestionMetaInformation t) {
        questionMetaInformationRepository.delete(t);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<QuestionMetaInformation> getAll() {
        return questionMetaInformationRepository.findAll();
    }

    // @Cacheable(cacheNames = "default")
    @Override
    public Long getOther_idByQuestionMetaInformationId(Long id) {

        return Optional.
                ofNullable(questionMetaInformationRepository.findOne(id)).
                map(QuestionMetaInformation::getAnswers).
                map(AnswerMetaInformation::getOther).
                map(Other::getId).orElse(null);
    }

   // @Cacheable(cacheNames = "default")
    @Override
    public List<Choice> getChoicesByQuestionMetaInformationId(Long id) {

        List<Choice> l = get(id).getAnswers().getChoices();
        l.size(); //TODO
        return l;

    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<Row> getRowsByQuestionMetaInformationId(Long id) {

        List<Row> l = get(id).getAnswers().getRows();
        l.size(); //TODO
        return l;

    }

    @Cacheable(cacheNames = "default")
    public List<? extends ChoiceOrRow> getChoiceOrRowsByQuestionMetaInformationId(Long id, boolean UseRow_idInstedOfChoice_id) {
        if (UseRow_idInstedOfChoice_id) {
            return getRowsByQuestionMetaInformationId(id);
        } else {
            return getChoicesByQuestionMetaInformationId(id);
        }
    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<QuestionMetaInformation> getQuestionMetaInformationsBySurveyId(Long id) {
        List<QuestionMetaInformation> list = new ArrayList<>();
        Survey survey = surveyService.get(id);
        survey.getPages().forEach((t) -> {
            List<QuestionMetaInformation> list2 = t.getQuestions();
            list.addAll(list2);
        });
        return list;
    }

    @Cacheable(cacheNames = "default")
    public Integer countChoicesByQuestionMetaInformationId(Long id) {
        return get(id).getAnswers().getChoices().size();
    }

    @Cacheable(cacheNames = "default")
    public Integer countRowsByQuestionMetaInformationId(Long id) {
        return get(id).getAnswers().getRows().size();
    }

    @Cacheable(cacheNames = "default")
    public Long findQuestionMetaInformationIdByChoiceId(Long id) {
        return questionMetaInformationRepository.findQuestionMetaInformationIdByChoiceId(id);
    }

    @Cacheable(cacheNames = "default")
    public Long findQuestionMetaInformationIdByRowId(Long id) {
        return questionMetaInformationRepository.findQuestionMetaInformationIdByRowId(id);
    }

}
