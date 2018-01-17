package org.jugru.monkeyStatistics.api;

import org.jugru.monkeyStatistics.model.chart.Chart;
import org.jugru.monkeyStatistics.model.chart.ChartData;
import org.jugru.monkeyStatistics.model.chart.ChartsPreset;
import org.jugru.monkeyStatistics.service.ChartService;
import org.jugru.monkeyStatistics.service.ChartsPresetService;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
import org.jugru.monkeyStatistics.util.IdNamePair;
import org.jugru.monkeyStatistics.util.Questions;
import org.jugru.monkeyStatistics.util.SurveyMetaInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    Logger logger = LoggerFactory.getLogger(API.class);

    @RequestMapping(value = "/api/presets")
    public List<IdNamePair> presets() {
        return chartsPresetService.getIdNamePairOfPresets();
    }



    @RequestMapping(value = "/api/questionsBySurveyId")
    public List<Questions> questionsBySurveyId(@RequestParam(value = "id") Long id) {
        return questionMetaInformationService.getQuestionsBySurveyId(id);
    }

    @RequestMapping(value = "/api/answers")
    public List<IdNamePair> answers(@RequestParam(value = "id") Long id) {
        return questionMetaInformationService.getIdNamePairOfChoiceOrRowByQuestionMetaInformationId(id);
    }

    /**
     * @param id id пресета
     * @return пары id/имя графиков
     */
    @RequestMapping(value = "/api/charts", method = RequestMethod.GET)
    public List<IdNamePair> charts(@RequestParam(value = "id") Long id) {
        return chartsPresetService.getIdNamePairsOfChartsByPresetId(id);
    }

    @RequestMapping(value = "/api/preset", method = RequestMethod.POST)
    public ChartsPreset preset(@RequestParam(value = "name") String name) {
        return chartsPresetService.save(new ChartsPreset(name));
    }

    @RequestMapping(value = "/api/preset", method = RequestMethod.DELETE)
    public void deletePreset(@RequestParam(value = "id") Long id) {
        chartsPresetService.delete(chartsPresetService.get(id));
    }

    @RequestMapping(value = "/api/preset", method = RequestMethod.GET)
    public Set<IdNamePair> surveys() {
        return surveyService.getIdNamePairOfSurveys();
    }

    @RequestMapping(value = "/api/chart", method = RequestMethod.PUT)
    public Chart saveChart(@RequestBody Chart chart) {
        return chartService.save(chart);
    }

    @RequestMapping(value = "/api/chart", method = RequestMethod.POST)
    public Chart createChart(@RequestParam(value = "id") Long id, @RequestParam(value = "type") String type) {
        return chartsPresetService.createChart(id, type);
    }

    @RequestMapping(value = "/api/chart", method = RequestMethod.DELETE)
    public void deleteChart(@RequestParam(value = "id") Long id) {
        chartService.delete(chartService.get(id));
    }

    @RequestMapping(value = "/api/chart", method = RequestMethod.GET)
    public Chart chart(@RequestParam(value = "id") Long id) {
        return chartService.getPreparedForSending(id);
    }

    @RequestMapping(value = "/api/draw", method = RequestMethod.GET)
    public List<ChartData> chartData(@RequestParam(value = "id") Long id) {
        logger.debug("Draw chart. Id is {}", id);
        return chartService.get(id).createChartData(chartDataBuilder);
    }

    @RequestMapping(value = "/api/preview", method = RequestMethod.POST)
    public List<ChartData> preview(@RequestBody Chart chart) {
        return chart.createChartData(chartDataBuilder);
    }

    @RequestMapping(value = "/api/surveys/new")
    public Set<SurveyMetaInformation> newSurveys() {
        return surveyService.getSurveyMetaInformationOfNewSurveys();
    }

    @RequestMapping(value = "/api/surveys/all")
    public Set<SurveyMetaInformation> allSurveys() {
        return surveyService.getSurveyMetaInformationOfAllSurveys();
    }

    @RequestMapping(value = "/api/surveys")
    public void saveSurvey(@RequestParam(value = "id") Long id, @RequestParam(value = "isConferenceSurvey") boolean isConferenceSurvey) {
        surveyService.setConferenceSurvey(id, isConferenceSurvey);
    }
}
