package org.jugru.monkeyStatistics.web;

import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @Autowired
    SurveyMonkeyClient surveyMonkeyClient;

    @RequestMapping(value = "/survey")
    public String survey() {
        List<Survey> l =  surveyService.getAll();
        l.forEach(surveyService::delete);
        return "OK";
    }
}
