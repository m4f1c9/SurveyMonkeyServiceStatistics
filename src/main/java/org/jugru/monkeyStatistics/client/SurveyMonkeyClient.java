package org.jugru.monkeyStatistics.client;

import java.util.Set;
import java.util.TreeSet;
import org.jugru.monkeyService.model.Response;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyService.model.util.ListOfResponses;
import org.jugru.monkeyService.model.util.ListOfSurveys;
import org.jugru.monkeyStatistics.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurveyMonkeyClient {

    @Autowired
    private RestClient restClient;

    public SurveyMonkeyClient() {
    }

    public SurveyMonkeyClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Set<Survey> getAllSurveys() {
        Set<Survey> answer = new TreeSet<>();
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
    
    public Survey getSurvey (long id){
        return restClient.getSurvey(id);
    }

}
