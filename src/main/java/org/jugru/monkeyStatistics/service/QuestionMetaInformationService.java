package org.jugru.monkeyStatistics.service;

import org.jugru.monkeyService.model.AnswerMetaInformation;
import org.jugru.monkeyService.model.QuestionMetaInformation;

public interface QuestionMetaInformationService extends Service<QuestionMetaInformation> {

    Long getOther_idByQuestionMetaInformationId(long id);
}
