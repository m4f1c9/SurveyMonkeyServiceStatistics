package org.jugru.monkeyStatistics.repository;

import java.util.List;
import org.jugru.monkeyService.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("Select answer from Answer answer where answer.other_id = ?1")
    List<Answer> findAnswerByOther_id(long other_id);

    @Query("Select answer from Answer answer where answer.choice_id = ?1")
    List<Answer> findAnswerByChoice_id(long choice_id);

    @Query("Select answer from Answer answer where answer.row_id = ?1")
    List<Answer> findAnswerByRow_id(long row_id);
}
