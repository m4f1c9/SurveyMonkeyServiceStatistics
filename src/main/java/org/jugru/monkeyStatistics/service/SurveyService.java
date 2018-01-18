package org.jugru.monkeyStatistics.service;

import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.SurveyPage;
import org.jugru.monkeyStatistics.util.IdNamePair;
import org.jugru.monkeyStatistics.util.SurveyMetaInformation;

import java.util.List;
import java.util.Set;

public interface SurveyService extends Service<Survey> {

    /*
    * Считает количество уникальных ответов на опрос
     */
    Long findSurveyIdByQuestionMetaInformationId(Long id);

    int countResponsesBySurveyId(Long id);

    List<SurveyPage> getSurveyPagesFromSurvey(Long id);

    void addNewResponses (Survey s);

    void parseAndSetStatus (Survey s);

    String getSurveyNameBySurveyId(Long id);

    Set<IdNamePair>  getIdNamePairOfSurveys();

    Set<SurveyMetaInformation>  getSurveyMetaInformationOfNewSurveys();

    Set<SurveyMetaInformation> getSurveyMetaInformationOfAllSurveys();

    void setConferenceSurvey(Long id, boolean isConferenceSurvey);

    void refreshAnswers();
}
