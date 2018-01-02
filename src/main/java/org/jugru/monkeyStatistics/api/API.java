package org.jugru.monkeyStatistics.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.jugru.monkeyStatistics.model.Choice;
import org.jugru.monkeyStatistics.model.QuestionMetaInformation;
import org.jugru.monkeyStatistics.model.Survey;
import org.jugru.monkeyStatistics.model.chart.*;
import org.jugru.monkeyStatistics.service.ChartService;
import org.jugru.monkeyStatistics.service.ChartsPresetService;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
import org.jugru.monkeyStatistics.util.IdNamePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API {

    @Autowired
    QuestionMetaInformationService questionMetaInformationService;

    @Autowired
    ChartDataBuilder chartDataBuilder;

    @Autowired
    ChartsPresetService chartsPresetService;

    @Autowired
    ChartService chartService;

    @Autowired
    SurveyService surveyService;


    @RequestMapping("/api/saveChart")
    public Chart saveChart(@RequestBody Chart chart) {
        return chartService.save(chart);
    }


    @RequestMapping("/api/create/preset")
    public ChartsPreset preset(@RequestParam(value = "name") String name) {
        return chartsPresetService.save(new ChartsPreset(name));

    }


    @RequestMapping("/api/create/chart")
    public Chart createChart(@RequestParam(value = "id") Long id, @RequestParam(value = "type") String type) {
        return chartsPresetService.createChart(id, type);


    }

    @RequestMapping("/api/delete/preset")
    public void deletePreset(@RequestParam(value = "id") Long id) {
        chartsPresetService.delete(chartsPresetService.get(id));

    }

    @RequestMapping("/api/delete/chart")
    public void deleteChart(@RequestParam(value = "id") Long id) {
        chartService.delete(chartService.get(id));

    }


    // TODO
    @RequestMapping("/api/presets")
    public List<IdNamePair> presets() {
        List<ChartsPreset> presets = chartsPresetService.getAll();
        List<IdNamePair> pairs = new ArrayList<>();
        presets.forEach((t) -> {
            pairs.add(new IdNamePair(t.getId(), t.getName()));
        });
        return pairs;
    }

    @RequestMapping("/api/surveys")
    public Set<IdNamePair> surveys() {
        List<Survey> surveys = surveyService.getAll();
        Set<IdNamePair> pairs = new TreeSet<>();
        surveys.forEach((t) -> {
            pairs.add(new IdNamePair(t.getId(), t.getTitle()));
        });
        return pairs;
    }

    @RequestMapping("/api/questionsByOneQuestion")
    public List<IdNamePair> questions(@RequestParam(value = "id") Long id) {

        Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(id);
        List<IdNamePair> questions = new ArrayList<>();
        List<QuestionMetaInformation> list = questionMetaInformationService.getQuestionMetaInformationsBySurveyId(surveyId);
        list.forEach((t) -> {
            questions.add(new IdNamePair(t.getId(), ChartDataBuilder.removeTags(t.getHeadingAsString())));
        });
        return questions;
    }

    @RequestMapping("/api/questionsBySurveyId")
    public List<IdNamePair> questionsBySurveyId(@RequestParam(value = "id") Long id) {

        List<IdNamePair> questions = new ArrayList<>();
        List<QuestionMetaInformation> list = questionMetaInformationService.getQuestionMetaInformationsBySurveyId(id);
        list.forEach((t) -> {
            questions.add(
                    new IdNamePair(
                            t.getId(),
                            ChartDataBuilder.removeTags(questionMetaInformationService.getHeadingAsStringFromQuestionMetaInformationId(t.getId()))));
        });
        return questions;
    }

    @RequestMapping("/api/answers")
    public List<IdNamePair> answers(@RequestParam(value = "id") Long id) {

        List<IdNamePair> answers = new ArrayList<>();
        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(id);
        choices.forEach((t) -> {
            answers.add(new IdNamePair(t.getId(), ChartDataBuilder.removeTags(t.getText())));
        });
        return answers;
    }

    /**
     * @param id id пресета
     * @return пары id/имя графиков
     */
    @RequestMapping("/api/charts")
    public List<IdNamePair> charts(@RequestParam(value = "id") Long id) {
        return chartsPresetService.getIdNamePairsByPresetId(id);
    }

    @RequestMapping("/api/chart")
    public Chart chart(@RequestParam(value = "id") Long id) {
        Chart chart = chartService.get(id);
        chart.prepareForSending(surveyService);
        return chart;
    }

    @RequestMapping("/api/draw/chart")
    public List<ChartData> chartData(@RequestParam(value = "id") Long id) {
        return chartService.get(id).createChartData(chartDataBuilder);
    }

    @RequestMapping("/api/preview/CGC")
    public ChartData drawCGC(@RequestBody CrossGroupingChart cgc) {
        return chartDataBuilder.createChartDataFromCrossGroupingChart(cgc);
    }

    @RequestMapping("/api/preview/UC")
    public List<ChartData> drawUC(@RequestBody UngroupedCharts uc) {
        return chartDataBuilder.createChartDataFromUngroupedCharts(uc);
    }

    @RequestMapping("/api/preview")
    public List<ChartData> preview(@RequestBody Chart chart) {
        return chart.createChartData(chartDataBuilder);
    }

}
