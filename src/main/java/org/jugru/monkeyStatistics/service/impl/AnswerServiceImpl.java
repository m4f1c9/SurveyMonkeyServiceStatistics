package org.jugru.monkeyStatistics.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.jugru.monkeyStatistics.model.Answer;
import org.jugru.monkeyStatistics.repository.AnswerRepository;
import org.jugru.monkeyStatistics.service.AnswerService;
import org.jugru.monkeyStatistics.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Answer get(long id) {
        return answerRepository.findOne(id);
    }

    @Override
    public void delete(Answer entity) {
        answerRepository.delete(entity);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<Answer> getByOther_id(long id) {
        return answerRepository.findAnswerByOther_id(id);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<Answer> getByChoice_id(long choice_id) {
        return answerRepository.findAnswerByChoice_id(choice_id);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public List<Answer> getByRow_id(long row_id) {
        return answerRepository.findAnswerByRow_id(row_id);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByChoice_id(long choice_id) {
        return answerRepository.countByChoice_id(choice_id);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByOther_id(Long other_id) {
        return answerRepository.countByOther_id(other_id);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByRow_id(long row_id) {
        return answerRepository.countByRow_id(row_id);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByTwoChoice_id(Long first, Long second) {
        return answerRepository.countByTwoChoice_id(first, second);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByTwoRow_id(Long first, Long second) {
        return answerRepository.countByTwoRow_id(first, second);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByChoice_idAndRow_id(Long first, Long second) {
        return answerRepository.countByChoice_idAndRow_id(first, second);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByRow_idAndChoice_id(Long first, Long second) {
        return answerRepository.countByRow_idAndChoice_id(first, second);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countUniqueAnswersByQuestionMetaInformationId(long id) {
        return questionService.countByQuestionMetaInformationId(id);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countById(Long id, boolean UseRow_idInstedOfChoice_id) {
        if (UseRow_idInstedOfChoice_id) {
            return answerService.countByRow_id(id);
        } else {
            return answerService.countByChoice_id(id);
        }
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByTwoId(Long first, Long second, boolean UseRow_idInstedOfChoice_idForFirst, boolean UseRow_idInstedOfChoice_idForSecond) {
        if (UseRow_idInstedOfChoice_idForFirst & UseRow_idInstedOfChoice_idForSecond) {
            return answerService.countByTwoRow_id(first, second);
        } else if (UseRow_idInstedOfChoice_idForFirst) {
            return answerService.countByRow_idAndChoice_id(first, second);
        } else if (UseRow_idInstedOfChoice_idForSecond) {
            return answerService.countByChoice_idAndRow_id(first, second);
        } else {
            return answerService.countByTwoChoice_id(first, second);
        }
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByChoice_idAndOther_id(Long first, Long second) {
        return answerRepository.countByChoice_idAndOther_id(first, second);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByRow_idAndOther_id(Long first, Long second) {
        return answerRepository.countByRow_idAndOther_id(first, second);
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByIdAndOther_id(Long first, Long second, boolean UseRow_idInstedOfChoice_id) {
        if (UseRow_idInstedOfChoice_id) {
            return answerService.countByRow_idAndOther_id(first, second);
        } else {
            return answerService.countByChoice_idAndOther_id(first, second);
        }
    }

    @Cacheable(cacheNames = "default")
    @Override
    public Integer countByQuestion_idAndChoice_id(Long first, Long second, boolean UseRow_idInstedOfChoice_id) {
        if (UseRow_idInstedOfChoice_id) {
            return answerRepository.countByQuestion_idAndRow_id(first, second);
        } else {
            return answerRepository.countByQuestion_idAndChoice_id(first, second);
        }
    }

}
