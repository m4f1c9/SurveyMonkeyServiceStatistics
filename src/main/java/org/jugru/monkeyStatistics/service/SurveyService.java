package org.jugru.monkeyStatistics.service;

import java.util.Collection;
import java.util.List;

import org.jugru.monkeyStatistics.model.Response;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.SurveyPage;

public interface SurveyService extends Service<Survey> {

    /*
    * Считает количество уникальных ответов на опрос
     */
    Long findSurveyIdByQuestionMetaInformationId(Long id);

    int countResponsesBySurveyId(Long id);

    List<SurveyPage> getSurveyPagesFromSurvey(Long id);

    void addNewResponses (Survey s, Collection<Response> c);

    String getSurveyNameBySurveyId(Long id);
}
