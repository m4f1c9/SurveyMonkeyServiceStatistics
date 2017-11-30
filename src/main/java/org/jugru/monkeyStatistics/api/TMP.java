package org.jugru.monkeyStatistics.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.transaction.Transactional;
import org.jugru.monkeyService.model.QuestionMetaInformation;
import org.jugru.monkeyService.model.Survey;
import org.jugru.monkeyService.model.SurveyPage;
import org.jugru.monkeyService.model.chart.ChartOptions;
import org.jugru.monkeyService.model.chart.CrossGroupingChart;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.tempData.Conferences;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TMP {

    @Autowired
    SurveyService surveyService;
    @Autowired
    QuestionMetaInformationService questionMetaInformationService;
    @Autowired
    ChartDataBuilder chartDataBuilder;


    @RequestMapping("/test")
    public List<ChartData> test() {
        return chartDataBuilder.createChartDataFromChartsPreset(Conferences.test());
    }

  
    @Transactional  //TODO !!!!!!!!!111111oneone
    @RequestMapping("/surveys")
    public Set<StringLongPair> surveys() {
        Set<StringLongPair> set = new TreeSet<>();
        List<Survey> list = surveyService.getAll();
        list.forEach((t) -> {
            set.add(new StringLongPair(t.getId(), t.getTitle()));
        });
        return set;
    }

   
    @RequestMapping("/questions")
    public List<StringLongPair> questions(@RequestParam(value = "id") long id) {
        List<StringLongPair> list2 = new ArrayList<>();
        List<QuestionMetaInformation> list = questionMetaInformationService.getQuestionMetaInformationsBySurveyId(id);
        list.forEach((t) -> {
            list2.add(new StringLongPair(t.getId(), ChartDataBuilder.removeTags(t.getHedingAsString())));
            // set.add(new StringLongPair(t.getId(), t.getHedingAsString()));
        });
        return list2;
    }

    @RequestMapping("/pages")
    public Set<StringLongPair> pages(@RequestParam(value = "id") long id) {
        Set<StringLongPair> set = new TreeSet<>();
        List<SurveyPage> list = surveyService.getSurveyPagesFromSurvey(id);
        list.forEach((t) -> {
            set.add(new StringLongPair(t.getId(), t.getTitle() + t.getDescription()));

        });
        return set;
    }

    @RequestMapping("/сrossGroupingChart")
    public ChartData сrossGroupingChart(@RequestParam(value = "surveyId") long surveyId, @RequestParam(value = "fQuestionId") long fQuestionId, @RequestParam(value = "sQuestionId") long sQuestionId) {
        ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
        CrossGroupingChart cgc = new CrossGroupingChart("", surveyId, fQuestionId, sQuestionId, chartOptions);
        return chartDataBuilder.createChartDataFromCrossGroupingChart(cgc);
    }

    private class StringLongPair implements Comparable<StringLongPair> {

        public StringLongPair(Long Id, String Title) {
            this.Id = Id;
            this.Title = Title;
        }

        public Long Id;
        public String Title;

        @Override
        public int compareTo(StringLongPair o) {
            return Id.compareTo(o.Id);
        }

    }

}
