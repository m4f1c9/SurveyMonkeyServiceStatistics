package org.jugru.monkeyStatistics.service;

import java.util.List;
import org.jugru.monkeyService.model.Answer;

public interface AnswerService extends Service<Answer> {

    List<Answer> getByOther_id(long id);

    List<Answer> getByChoice_id(long choice_id);

    List<Answer> getByRow_id(long row_id);
}
