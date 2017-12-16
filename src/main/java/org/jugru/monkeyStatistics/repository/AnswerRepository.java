package org.jugru.monkeyStatistics.repository;

import java.util.List;
import org.jugru.monkeyStatistics.model.Answer;
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

    @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN   q1.answers a1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where a1.choice_id = ?1 and a2.choice_id = ?2 ")
    Integer countByTwoChoice_id(Long first, Long second);

    @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN   q1.answers a1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where a1.row_id = ?1 and a2.row_id = ?2 ")
    Integer countByTwoRow_id(Long first, Long second);

    @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN   q1.answers a1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where a1.choice_id = ?1 and a2.row_id = ?2 ")
    Integer countByChoice_idAndRow_id(Long first, Long second);

    @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN   q1.answers a1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where a1.row_id = ?1 and a2.choice_id = ?2 ")
    Integer countByRow_idAndChoice_id(Long first, Long second);

    @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN   q1.answers a1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where a1.choice_id = ?1 and a2.other_id = ?2 ")
    Integer countByChoice_idAndOther_id(Long first, Long second);

    @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN   q1.answers a1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where a1.row_id = ?1 and a2.other_id = ?2 ")
    Integer countByRow_idAndOther_id(Long first, Long second);
    
    
    @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where q1.id = ?1 and a2.choice_id = ?2 ")
   Integer countByQuestion_idAndChoice_id(Long first, Long second);
   
   @Query("Select count(r) from Response r JOIN r.pages p1 JOIN  p1.questions q1 JOIN  r.pages p2 JOIN      p2.questions q2 JOIN   q2.answers a2  where q1.id = ?1 and a2.row_id = ?2 ")
   Integer countByQuestion_idAndRow_id(Long first, Long second);

   
   
    

    



}
