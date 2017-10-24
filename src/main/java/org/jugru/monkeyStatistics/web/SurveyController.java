package org.jugru.monkeyStatistics.web;

import javax.transaction.Transactional;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.client.RestClient;
import org.jugru.monkeyStatistics.repository.SurveyRepository;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @Autowired
    SurveyMonkeyClient surveyMonkeyClient;

    @RequestMapping(value = "/survey")
    public String survey(Model model) {
        Survey s = surveyService.get(88971560L);
        model.addAttribute("Survey", s);
        return "survey";
    }
}
