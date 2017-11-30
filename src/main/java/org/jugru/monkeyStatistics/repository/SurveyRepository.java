package org.jugru.monkeyStatistics.repository;

import org.jugru.monkeyService.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query("Select survey.id from Survey survey JOIN survey.pages p JOIN p.questions q where q.id = ?1")
    Long findSurveyIdByQuestionMetaInformationId(Long id);
}
