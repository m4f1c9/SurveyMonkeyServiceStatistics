package org.jugru.monkeyStatistics.repository;

import org.jugru.monkeyStatistics.model.Choice;
import org.jugru.monkeyStatistics.model.QuestionMetaInformation;

import org.jugru.monkeyStatistics.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionMetaInformationRepository extends JpaRepository<QuestionMetaInformation, Long> {

    @Query("Select q.id from QuestionMetaInformation q JOIN q.answers a JOIN a.choices c where c.id = ?1")
    Long findQuestionMetaInformationIdByChoiceId(Long id);

    @Query("Select q.id from QuestionMetaInformation q JOIN q.answers a JOIN a.rows c where c.id = ?1")
    Long findQuestionMetaInformationIdByRowId(Long id);

    @Query("Select c from QuestionMetaInformation q JOIN q.answers a JOIN a.choices c where q.id = ?1")
    List<Choice> getChoicesByQuestionMetaInformationId(Long id);

    @Query("Select c from QuestionMetaInformation q JOIN q.answers a JOIN a.rows c where q.id = ?1")
    List<Row> getRowsByQuestionMetaInformationId(Long id);

    @Query("Select count(c) from QuestionMetaInformation q JOIN q.answers a JOIN a.choices c where q.id = ?1")
    Integer countAvailableChoicesByQuestionMetaInformationId(Long id);

    @Query("Select count(c) from QuestionMetaInformation q JOIN q.answers a JOIN a.rows c where q.id = ?1")
    Integer countAvailableRowsByQuestionMetaInformationId(Long id);

}
