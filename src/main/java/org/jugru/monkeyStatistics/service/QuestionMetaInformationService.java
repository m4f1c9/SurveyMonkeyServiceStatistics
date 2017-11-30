package org.jugru.monkeyStatistics.service;

import java.util.List;
import java.util.Set;
import org.jugru.monkeyService.model.AnswerMetaInformation;
import org.jugru.monkeyService.model.Choice;
import org.jugru.monkeyService.model.QuestionMetaInformation;
import org.jugru.monkeyService.model.Row;
import org.jugru.monkeyService.model.Survey;

public interface QuestionMetaInformationService extends Service<QuestionMetaInformation> {

    Long getOther_idByQuestionMetaInformationId(Long id);

    List<Choice> getChoicesByQuestionMetaInformationId(Long id);

    List<Row> getRowsByQuestionMetaInformationId(Long id);

    List<QuestionMetaInformation> getQuestionMetaInformationsBySurveyId(Long id);

    Integer countChoicesByQuestionMetaInformationId(Long id);

    Integer countRowsByQuestionMetaInformationId(Long id);

    Long findQuestionMetaInformationIdByChoiceId(Long id);

    Long findQuestionMetaInformationIdByRowId(Long id);
}
