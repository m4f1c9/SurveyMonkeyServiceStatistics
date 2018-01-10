package org.jugru.monkeyStatistics.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.jugru.monkeyStatistics.model.Response;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.SurveyPage;
import org.jugru.monkeyStatistics.util.IdNamePair;

public interface SurveyService extends Service<Survey> {

    /*
    * Считает количество уникальных ответов на опрос
     */
    Long findSurveyIdByQuestionMetaInformationId(Long id);

    int countResponsesBySurveyId(Long id);

    List<SurveyPage> getSurveyPagesFromSurvey(Long id);

    void addNewResponses (Survey s, Collection<Response> c);

    String getSurveyNameBySurveyId(Long id);

    Set<IdNamePair>  getIdNamePairOfSurveys();
}
