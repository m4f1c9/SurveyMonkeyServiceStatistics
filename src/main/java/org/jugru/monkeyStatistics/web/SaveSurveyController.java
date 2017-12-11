package org.jugru.monkeyStatistics.web;

import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyStatistics.client.SurveyMonkeyClient;
import org.jugru.monkeyStatistics.service.impl.SurveyMonkeyService;
import org.jugru.monkeyStatistics.client.RestClient;
import org.jugru.monkeyStatistics.service.ChartsPresetService;
import org.jugru.monkeyStatistics.tempData.Conferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaveSurveyController {

    @Autowired
    ChartsPresetService chartsPresetService;

    @Autowired
    SurveyMonkeyService surveyMonkeyService;

    @RequestMapping(value = "/save")
    public String save(Model model) {
        //        Survey survey;
        //        
        //        survey = new Survey();
        //        survey.setId(80191211L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //        survey = new Survey();
        //        survey.setId(87269535L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //        
        //        survey = new Survey();
        //        survey.setId(117652322L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //         survey = new Survey();
        //        survey.setId(125742994L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //        survey = new Survey();
        //        survey.setId(88971560L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //        
        //        survey = new Survey();
        //        survey.setId(78199292L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //         survey = new Survey();
        //        survey.setId(63616183L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //        survey = new Survey();
        //        survey.setId(89235000L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //        
        //        survey = new Survey();
        //        survey.setId(80136513L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //         survey = new Survey();
        //        survey.setId(63175554L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //        survey = new Survey();
        //        survey.setId(70153290L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //        
        //        survey = new Survey();
        //        survey.setId(85694193L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //         survey = new Survey();
        //        survey.setId(125137353L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //
        //        survey = new Survey();
        //        survey.setId(76600618L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);
        //        
        //        survey = new Survey();
        //        survey.setId(88993967L);
        //        surveyMonkeyService.parseAndSaveDetailedSurvey(survey);

        //    surveyMonkeyService.refreshAnswers();
        chartsPresetService.save(Conferences.test1());
        chartsPresetService.save(Conferences.test2());
        return "OK";
    }
}
