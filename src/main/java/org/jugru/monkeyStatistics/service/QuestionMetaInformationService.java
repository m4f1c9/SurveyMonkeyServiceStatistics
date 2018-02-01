package org.jugru.monkeyStatistics.service;

import org.jugru.monkeyStatistics.model.Choice;
import org.jugru.monkeyStatistics.model.ChoiceOrRow;
import org.jugru.monkeyStatistics.model.QuestionMetaInformation;
import org.jugru.monkeyStatistics.model.Row;
import org.jugru.monkeyStatistics.util.IdNamePair;
import org.jugru.monkeyStatistics.util.Questions;

import java.util.List;

public interface QuestionMetaInformationService extends Service<QuestionMetaInformation> {

    Long getOther_idByQuestionMetaInformationId(Long id);

    List<Choice> getChoicesByQuestionMetaInformationId(Long id);

    List<Row> getRowsByQuestionMetaInformationId(Long id);

    List<? extends ChoiceOrRow> getChoiceOrRowsByQuestionMetaInformationId(Long id, boolean UseRow_idInsteadOfChoice_id);

    public List<? extends ChoiceOrRow> getChoiceOrRowsByQuestionMetaInformationId(Long id);

    List<QuestionMetaInformation> getQuestionMetaInformationBySurveyId(Long id);

    List<IdNamePair> getIdNamePairOfChoiceOrRowByQuestionMetaInformationId(Long id);

    List<Questions> getQuestionsBySurveyId(Long id);

    Integer countChoicesByQuestionMetaInformationId(Long id);

    Integer countRowsByQuestionMetaInformationId(Long id);

    Long findQuestionMetaInformationIdByChoiceId(Long id);

    Long findQuestionMetaInformationIdByRowId(Long id);

    String getHeadingAsStringFromQuestionMetaInformationId(Long id);

    boolean isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(Long id);

    boolean isWithNoChoice(Long id);

    boolean isWithCustomChoice(Long id);

    boolean isSupportedElseThrowException(QuestionMetaInformation questionMetaInformation);

    boolean isSupportedElseThrowException(Long id);

}
