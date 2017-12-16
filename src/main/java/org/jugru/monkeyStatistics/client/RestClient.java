package org.jugru.monkeyStatistics.client;

import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.util.CollectorWrapper;
import org.jugru.monkeyStatistics.model.util.Collector;
import org.jugru.monkeyStatistics.model.util.ListOfResponses;
import org.jugru.monkeyStatistics.model.util.ListOfSurveys;
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

    private HttpEntity<String> createHttpEntity() {
        return new HttpEntity<>(headers);
    }

    public ListOfSurveys getListOfSurveys(int page, int per_page) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ListOfSurveys> responseEntity
                = restTemplate.
                        exchange(baseURL + "surveys?page={page}&per_page={per_page}",
                                HttpMethod.GET,
                                createHttpEntity(),
                                ListOfSurveys.class,
                                page,
                                per_page);
        return responseEntity.getBody();
    }

    public Survey getSurvey(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Survey> responseEntity
                = restTemplate.
                        exchange(baseURL + "surveys/{id}/details",
                                HttpMethod.GET,
                                createHttpEntity(),
                                Survey.class,
                                id);
        return responseEntity.getBody();
    }

    public ListOfResponses getListOfResponses(long survey, int page, int per_page) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ListOfResponses> responseEntity
                = restTemplate.
                        exchange(baseURL + "surveys/{survey}/responses/bulk?page={page}&per_page={per_page}",
                                HttpMethod.GET,
                                createHttpEntity(),
                                ListOfResponses.class,
                                survey,
                                page,
                                per_page);
        return responseEntity.getBody();
    }

    public CollectorWrapper getCollectorWrapper(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CollectorWrapper> responseEntity
                = restTemplate.
                        exchange(baseURL + "surveys/" + id + "/collectors",
                                HttpMethod.GET,
                                createHttpEntity(),
                                CollectorWrapper.class);
        return responseEntity.getBody();
    }

    public Collector getCollector(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Collector> responseEntity
                = restTemplate.
                        exchange(baseURL + "/collectors/" + id,
                                HttpMethod.GET,
                                createHttpEntity(),
                                Collector.class);
        return responseEntity.getBody();
    }

}
