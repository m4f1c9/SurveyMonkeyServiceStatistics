package org.jugru.monkeyStatistics.repository;

import org.jugru.monkeyStatistics.model.QuestionMetaInformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionMetaInformationRepository extends JpaRepository<QuestionMetaInformation, Long> {

    @Query("Select q.id from QuestionMetaInformation q JOIN q.answers a JOIN a.choices c where c.id = ?1")
    Long findQuestionMetaInformationIdByChoiceId(Long id);

    @Query("Select q.id from QuestionMetaInformation q JOIN q.answers a JOIN a.rows c where c.id = ?1")
    Long findQuestionMetaInformationIdByRowId(Long id);
}
