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

    @Query("Select count(answer) from Answer answer where answer.choice_id = ?1")
    Integer countByChoice_id(long choice_id);

    @Query("Select count(answer) from Answer answer where answer.other_id = ?1")
    Integer countByOther_id(Long other_id);

    @Query("Select count(answer) from Answer answer where answer.row_id = ?1")
    Integer countByRow_id(long row_id);

    //@Query("Select count(r) from Response r JOIN r.pages p JOIN  p.questions q JOIN   q.answers a1 JOIN   q.answers a2  where a1.choice_id = ?1 or a2.choice_id = ?2 ")
    @Query("Select count(r) from Response r JOIN r.pages p JOIN  p.questions q1 JOIN   q1.answers a1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where a1.choice_id = ?1 and a2.choice_id = ?2 ")
    Integer countByTwoChoice_id(Long first, Long second);

}
