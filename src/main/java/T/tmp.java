package T;

import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.util.RestClient;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;

public class tmp {

    public static void main(String[] args) {
        //        SurveyMonkeyClient rc = new SurveyMonkeyClient(new RestClient());
        //        rc.getAllSurveys().forEach(System.out::println);

    RestClient rc = new RestClient();
    Survey jss = rc.getSurvey(118568344L);
    jss.getPages().forEach((t) -> {
        t.getQuestions().forEach(System.out::println);
    });
    
//        RestClient rc = new RestClient();
//        //rc.get22(118568344L).getData().forEach(System.out::println);
//        rc.getListOfResponses (118568344L, 1, 50).getData().forEach(System.out::println);

//        SurveyMonkeyClient rc = new SurveyMonkeyClient(new RestClient());
//        rc.getAllResponsesBySurveyId(118568344L).forEach(System.out::println);
    }
}
