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

    Integer countByTwoRow_id(Long first, Long second);

    Integer countByChoice_idAndRow_id(Long first, Long second);

    Integer countByRow_idAndChoice_id(Long first, Long second);

    Integer countUniqueAnswersByQuestionMetaInformationId(long id);

    Integer countById(Long id, boolean UseRow_idInstedOfChoice_id);

    Integer countByTwoId(Long first, Long second, boolean UseRow_idInstedOfChoice_idForFirst, boolean UseRow_idInstedOfChoice_idForSecond);

    Integer countByChoice_idAndOther_id(Long first, Long second);

    Integer countByRow_idAndOther_id(Long first, Long second);

    Integer countByIdAndOther_id(Long first, Long second, boolean UseRow_idInstedOfChoice_id);

    Integer countByQuestion_idAndChoice_id(Long first, Long second, boolean UseRow_idInstedOfChoice_id);
}
