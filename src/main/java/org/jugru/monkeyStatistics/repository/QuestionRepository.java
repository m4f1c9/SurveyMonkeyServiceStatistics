package org.jugru.monkeyStatistics.repository;

import org.jugru.monkeyService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("Select count(question) from Question question where question.id = ?1")
    Integer countById(long other_id);

  
  
}
