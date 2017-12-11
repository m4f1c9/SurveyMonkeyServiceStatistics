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
import org.jugru.monkeyService.model.chart.QuestionOptions;
import org.jugru.monkeyService.model.chart.ChartData;
import org.jugru.monkeyService.model.chart.ChoiceGroup;
import org.jugru.monkeyService.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyService.model.chart.QuestionDetails;
import org.jugru.monkeyService.model.chart.SingleQuestionChart;
import org.jugru.monkeyService.model.chart.UngroupedCharts;
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
        return chartDataBuilder.createChartDataFromChartsPreset(Conferences.test1());
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
        ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.FULL, ChartOptions.Annotation.SHORT);
        CrossGroupingChart cgc = new CrossGroupingChart("", fQuestionId, sQuestionId, chartOptions);
        cgc.setFirstQuestionOptions(new QuestionOptions(true, true, false));
        cgc.setSecondQuestionOptions(new QuestionOptions(true, true, false));
        return chartDataBuilder.createChartDataFromCrossGroupingChart(cgc);
    }

    @RequestMapping("/jtest")
    public ChartOptions jtest() {

        return new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.FULL);
    }

    @RequestMapping("/cgc11")
    public GroupedByChoiceChart cgc11() {

        ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.FULL, ChartOptions.Annotation.SHORT);
        QuestionOptions o = new QuestionOptions(true, true, false);
        GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваша позиция в компании?", chartOptions);
        chart.setQuestionOptions(o);

        chart.AddQuestionDetails(new QuestionDetails("HolyJS 2016 Piter", 966831639L, new QuestionOptions(true, true, false)));
        chart.AddQuestionDetails(new QuestionDetails("HolyJS 2016 Moscow", 1045020001L, new QuestionOptions(true, true, false)));
        chart.AddQuestionDetails(new QuestionDetails("HolyJS 2017 Piter", 118678197L, new QuestionOptions(true, true, false)));

        ChoiceGroup answer1 = new ChoiceGroup();
        answer1.setText("Junior Developer");
        answer1.setChoicesId(new LinkedList<Long>() {
            {
                add(10239887091L);
                add(10789207613L);
                add(874803001L);
            }
        });

        ChoiceGroup answer2 = new ChoiceGroup();
        answer2.setText("Middle Developer");
        answer2.setChoicesId(new LinkedList<Long>() {
            {
                add(10239887092L);
                add(10789207614L);
                add(874803002L);
            }
        });

        ChoiceGroup answer3 = new ChoiceGroup();
        answer3.setText("Senior Developer");
        answer3.setChoicesId(new LinkedList<Long>() {
            {
                add(10239887093L);
                add(10789207615L);
                add(874803003L);
            }
        });

        chart.addChoiceGroup(answer1);
        chart.addChoiceGroup(answer2);
        chart.addChoiceGroup(answer3);

        return chart;
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
