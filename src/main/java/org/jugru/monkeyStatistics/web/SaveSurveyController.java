package org.jugru.monkeyStatistics.web;

import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.client.SurveyMonkeyService;
import org.jugru.monkeyStatistics.util.RestClient;
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
        survey.setId(88971560L);
        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        surveyMonkeyService.refreshAnswers();
        return "OK";
    }
}
