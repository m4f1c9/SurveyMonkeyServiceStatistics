package org.jugru.monkeyStatistics.service;

import java.util.List;
import java.util.Set;
import org.jugru.monkeyService.model.AnswerMetaInformation;
import org.jugru.monkeyService.model.Choice;
import org.jugru.monkeyService.model.QuestionMetaInformation;

public interface QuestionMetaInformationService extends Service<QuestionMetaInformation> {

    Long getOther_idByQuestionMetaInformationId(long id);
    List<Choice> getChoicesByQuestionMetaInformationId(long id);
}
