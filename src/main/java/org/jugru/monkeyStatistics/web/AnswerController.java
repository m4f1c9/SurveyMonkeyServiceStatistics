package org.jugru.monkeyStatistics.web;

import java.util.List;
import org.jugru.monkeyStatistics.model.Answer;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.service.AnswerService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @Autowired
    SurveyService surveyService;

    @Autowired
    SurveyMonkeyClient surveyMonkeyClient;

    @RequestMapping(value = "/answer")
    public String answer(@RequestParam("id") long id, Model model) {
        List<Answer> answers = answerService.getByOther_id(id);
        model.addAttribute("answers", answers);
        return "answer";
    }
}
