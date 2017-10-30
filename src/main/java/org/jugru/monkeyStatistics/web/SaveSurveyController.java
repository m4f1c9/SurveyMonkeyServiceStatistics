package org.jugru.monkeyStatistics.web;

import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.service.impl.SurveyMonkeyService;
import org.jugru.monkeyStatistics.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaveSurveyController {

    @Autowired
    SurveyMonkeyService surveyMonkeyService;

    @RequestMapping(value = "/save")
    public String save(Model model) {
        Survey survey = new Survey();
        survey.setId(80191211L);
        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);

        Survey survey2 = new Survey();
        survey2.setId(87269535L);
        surveyMonkeyService.parseAndSaveDetailedSurvey(survey2);

        Survey survey3 = new Survey();
        survey3.setId(117652322L);
        surveyMonkeyService.parseAndSaveDetailedSurvey(survey3);

        surveyMonkeyService.refreshAnswers();
        return "OK";
    }
}
