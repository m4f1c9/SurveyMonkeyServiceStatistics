package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.jugru.monkeyStatistics.model.Question;
import org.jugru.monkeyStatistics.repository.QuestionRepository;
import org.jugru.monkeyStatistics.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class QuestionServiceImp implements QuestionService {

    

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question save(Question t) {
        return questionRepository.save(t);
    }

    @Override
    public Question get(long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public void delete(Question t) {
        questionRepository.delete(t);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

   // @Cacheable(cacheNames = "default")
    @Override
    public int countByQuestionMetaInformationId(Long id) {
        return questionRepository.countById(id);
    }

}
