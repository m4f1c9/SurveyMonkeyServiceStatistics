package org.jugru.monkeyStatistics.service;

import org.jugru.monkeyService.model.Answer;
import org.jugru.monkeyService.model.Question;

public interface QuestionService extends Service<Question>{
    Integer countById(long other_id);
}
