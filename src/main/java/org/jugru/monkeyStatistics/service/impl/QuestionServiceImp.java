
package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import org.jugru.monkeyService.model.Answer;
import org.jugru.monkeyService.model.Question;
import org.jugru.monkeyStatistics.repository.QuestionRepository;
import org.jugru.monkeyStatistics.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImp implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Integer countById(long other_id) {
       return questionRepository.countById(other_id);
    }

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

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

   
    
    
}
