package org.jugru.monkeyStatistics.service;

import java.util.List;
import org.jugru.monkeyService.model.Answer;
import org.jugru.monkeyService.model.Question;

public interface QuestionService extends Service<Question>{
    Integer countById(long other_id);
    
}
