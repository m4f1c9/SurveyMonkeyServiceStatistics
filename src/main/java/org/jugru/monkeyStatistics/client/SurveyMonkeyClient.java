package org.jugru.monkeyStatistics.client;

import org.jugru.monkeyStatistics.model.Response;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.util.Collector;
import org.jugru.monkeyStatistics.model.util.CollectorWrapper;
import org.jugru.monkeyStatistics.model.util.ListOfResponses;
import org.jugru.monkeyStatistics.model.util.ListOfSurveys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Работает с SurveyMonkey API.
 * 
*/
@Component
public class SurveyMonkeyClient {

    @Autowired
    private RestClient restClient;

    public SurveyMonkeyClient() {
    }

    public SurveyMonkeyClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Survey> getAllSurveys() {
        List<Survey> answer = new ArrayList<>(200);
        int page = 1;
        int per_page = 100;
        ListOfSurveys surveyWrapper;
        do {
            surveyWrapper = restClient.getListOfSurveys(page, per_page);
            answer.addAll(surveyWrapper.getSurveys());
        } while (page++ * per_page < surveyWrapper.getTotal());
        return answer;
    }

    public Set<Response> getAllResponsesBySurveyId(long id) {
        Set<Response> answer = new TreeSet<>();
        int page = 1;
        int per_page = 100;
        ListOfResponses listOfResponses;
        do {
            listOfResponses = restClient.getListOfResponses(id, page, per_page);
            answer.addAll(listOfResponses.getData());
        } while (page++ * per_page < listOfResponses.getTotal());
        return answer;
    }

    public Survey getSurvey(long id) {
        return restClient.getSurvey(id);
    }

    public String getSurveyStatus(Survey survey) {
        return getSurveyStatus(survey.getId());
    }

    //TODO разбить на методы
    public String getSurveyStatus(long id) {
        CollectorWrapper collectorWrapper = restClient.getCollectorWrapper(id);

       Set<Long> collectorsID = new HashSet<>();
        collectorWrapper.getData().forEach((collectors) -> {
            collectorsID.add(collectors.getId());
        });

        if (collectorsID.isEmpty()) {
            return null;
        } 
        String answer = "closed";

        for (Long monkeyCollectorID : collectorsID) {
            Collector collector = restClient.getCollector(monkeyCollectorID);
            if (!collector.getStatus().equals("closed")) {
                answer = "open";
            }
        }
        return answer;
    }

}
