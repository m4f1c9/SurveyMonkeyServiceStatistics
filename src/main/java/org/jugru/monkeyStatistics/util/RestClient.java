package org.jugru.monkeyStatistics.util;

import java.util.HashSet;
import java.util.Set;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyService.model.util.ListOfResponses;
import org.jugru.monkeyService.model.util.ListOfSurveys;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    private String baseURL = "https://api.surveymonkey.net/v3/";
    private String token = "8lJRSVrF85Axa8Y-pmjwZYvlzqNOqZ-5gcHdzy3nVNdtJ-Ir9S3CGZVJ7rHSd2FHsGA5iE28UGzva76-uyTbQ7V5o9BckGKAhld7QcUFx83.ZDimelpZsO59UZF6mByX";
    private HttpHeaders headers;

    public RestClient() {
        createHeaders();
    }

    public RestClient(String baseURL, String token) {
        this.baseURL = baseURL;
        this.token = token;
        createHeaders();
    }

    private void createHeaders() {
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.set("Authorization", "bearer " + token);
    }

    public ListOfSurveys getListOfSurveys(int page, int per_page) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ListOfSurveys> responseEntity
                = restTemplate.
                        exchange(baseURL + "surveys?page={page}&per_page={per_page}",
                                HttpMethod.GET,
                                entity,
                                ListOfSurveys.class,
                                page,
                                per_page);
        return responseEntity.getBody();
    }

    public Survey getSurvey(long id) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Survey> responseEntity
                = restTemplate.
                        exchange(baseURL + "surveys/{id}/details",
                                HttpMethod.GET,
                                entity,
                                Survey.class,
                                id);
        return responseEntity.getBody();
    }

    public ListOfResponses getListOfResponses(long survey, int page, int per_page) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ListOfResponses> responseEntity
                = restTemplate.
                        exchange(baseURL + "surveys/{survey}/responses/bulk?page={page}&per_page={per_page}",
                                HttpMethod.GET,
                                entity,
                                ListOfResponses.class,
                                survey,
                                page,
                                per_page);
        return responseEntity.getBody();
    }

}
