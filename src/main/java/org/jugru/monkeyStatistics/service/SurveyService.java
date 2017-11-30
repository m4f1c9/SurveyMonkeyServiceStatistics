package org.jugru.monkeyStatistics.service;

import java.util.List;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyService.model.SurveyPage;

public interface SurveyService extends Service<Survey> {

    /*
    * Считает количество уникальных ответов на опрос
     */
    Long findSurveyIdByQuestionMetaInformationId(Long id);

    int countResponsesBySurveyId(long id);

    List<SurveyPage> getSurveyPagesFromSurvey(Long id);
}
