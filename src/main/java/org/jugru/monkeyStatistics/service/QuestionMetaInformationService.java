package org.jugru.monkeyStatistics.service;

import java.util.List;

import org.jugru.monkeyStatistics.model.Choice;
import org.jugru.monkeyStatistics.model.ChoiceOrRow;
import org.jugru.monkeyStatistics.model.QuestionMetaInformation;
import org.jugru.monkeyStatistics.model.Row;

public interface QuestionMetaInformationService extends Service<QuestionMetaInformation> {

    Long getOther_idByQuestionMetaInformationId(Long id);

    List<Choice> getChoicesByQuestionMetaInformationId(Long id);

    List<Row> getRowsByQuestionMetaInformationId(Long id);

    List<? extends ChoiceOrRow> getChoiceOrRowsByQuestionMetaInformationId(Long id, boolean UseRow_idInstedOfChoice_id);

    List<QuestionMetaInformation> getQuestionMetaInformationsBySurveyId(Long id);

    Integer countChoicesByQuestionMetaInformationId(Long id);

    Integer countRowsByQuestionMetaInformationId(Long id);

    Long findQuestionMetaInformationIdByChoiceId(Long id);

    Long findQuestionMetaInformationIdByRowId(Long id);
}
