package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.AnswerMetaInformation;
import org.jugru.monkeyService.model.QuestionMetaInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.jugru.monkeyStatistics.repository.QuestionMetaInformationRepository;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.springframework.stereotype.Service;

@Service
public class QuestionMetaInformationServiceImp implements QuestionMetaInformationService {

    @Autowired
    private QuestionMetaInformationRepository questionMetaInformationRepository;

    @Transactional
    @Override
    public QuestionMetaInformation save(QuestionMetaInformation t) {
        return questionMetaInformationRepository.save(t);
    }

    @Transactional
    @Override
    public QuestionMetaInformation get(long id) {
        return questionMetaInformationRepository.findOne(id);
    }

    @Transactional
    @Override
    public void delete(QuestionMetaInformation t) {
        questionMetaInformationRepository.delete(t);
    }

    @Transactional
    @Override
    public List<QuestionMetaInformation> getAll() {
        return questionMetaInformationRepository.findAll();
    }

    
    //TODO сделать цепочку проверок
    @Transactional
    @Override
    public Long getOther_idByQuestionMetaInformationId(long id) {
        try {
            return questionMetaInformationRepository.findOne(id).getAnswers().getOther().getId();
        } catch (NullPointerException e) {
            return null;
        }
    }

}
