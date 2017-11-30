package org.jugru.monkeyStatistics.service;

import java.util.List;
import org.jugru.monkeyService.model.Answer;

public interface AnswerService extends Service<Answer> {

    List<Answer> getByOther_id(long id);

    List<Answer> getByChoice_id(long choice_id);

    List<Answer> getByRow_id(long row_id);

    Integer countByChoice_id(long choice_id);

    Integer countByRow_id(long row_id);

    Integer countByOther_id(Long other_id);

    Integer countByTwoChoice_id(Long first, Long second);

    Integer countByTwoOther_id(Long first, Long second);

    Integer countByChoice_idAndOther_id(Long first, Long second);

    Integer countByOther_idAndChoice_id(Long first, Long second);
    
    Integer countUniqueAnswersByQuestionMetaInformationId(long id);

}
