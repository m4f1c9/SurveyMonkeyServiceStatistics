package org.jugru.monkeyStatistics.tempData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.chart.ChartOptions;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyService.model.chart.CrossGroupingChart;
import org.jugru.monkeyService.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyService.model.chart.QuestionOptions;
import org.jugru.monkeyService.model.chart.SingleQuestionChart;
import org.jugru.monkeyService.model.chart.UngroupedCharts;
import org.jugru.monkeyService.model.chart.QuestionDetails;
import org.jugru.monkeyService.model.chart.ChoiceGroup;

public class Conferences {

    public static ChartsPreset test() {

        ChartsPreset preset = new ChartsPreset("1111!!!!!");

//        {
//            UngroupedCharts ungroupedCharts = new UngroupedCharts();
//            ungroupedCharts.setChartName("Ваша позиция в компании?");
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT);
//
//            ungroupedCharts.setChartOptions(chartOptions);
//
//            List<SingleQuestionChart> charts = new ArrayList<>();
//            SingleQuestionChart cqc;
//            cqc = new SingleQuestionChart("Mobius 2017 Moscow", 203746709L);
//            cqc.setQuestionOptions(new QuestionOptions(true, true, false));
//            charts.add(cqc);
//
//            ungroupedCharts.setCharts(charts);
//            preset.AddChart(ungroupedCharts);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT);
//            CrossGroupingChart cgc = new CrossGroupingChart("Слот 10:30 – 11:20.", 203789246L, 203789403L, chartOptions);
//            cgc.setHideLastChoiceInFirstQuestion(true);
//            cgc.setHideLastChoiceInSecondQuestion(true);
//            cgc.setFirstQuestionOptions(new QuestionOptions(true, true, false));
//            cgc.setSecondQuestionOptions(new QuestionOptions(true, true, false));
//            preset.AddChart(cgc);
//
//        }
        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT);
            CrossGroupingChart cgc = new CrossGroupingChart("1212121212", 203746709L, 203746707L, chartOptions);
            cgc.setHideLastChoiceInFirstQuestion(false);
            cgc.setHideLastChoiceInSecondQuestion(false);
            cgc.setFirstQuestionOptions(new QuestionOptions(true, true, false));
            cgc.setSecondQuestionOptions(new QuestionOptions(true, true, false));
            preset.AddChart(cgc);

        }

//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Как вы покупали билет?", 125742994L, 203746709L, 203746713L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Насколько конференция в целом соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746770L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Оцените программу конференции в целом", 125742994L, 203746709L, 203746764L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Оцените техническую глубину программы", 125742994L, 203746709L, 203746765L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Насколько техническая глубина соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746768L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Оцените практическую применимость услышанного вами в докладах", 125742994L, 203746709L, 203746766L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Насколько практическая применимость услышанного вами на конференции соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746769L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
//        {
//            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
//            CrossGroupingChart cgc = new CrossGroupingChart("Конференции на какие другие темы вы бы посетили ?", 125742994L, 203746709L, 203746759L, chartOptions);
//
//            preset.AddChart(cgc);
//
//        }
//
        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.FULL, ChartOptions.Annotation.SHORT);
            QuestionOptions o = new QuestionOptions(true, true, false);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваша позиция в компании?", chartOptions);
            chart.setQuestionOptions(o);
            
            chart.AddQuestionDetails(new QuestionDetails("HolyJS 2016 Piter", 966831639L, new QuestionOptions(true, true, false)));
            chart.AddQuestionDetails(new QuestionDetails("HolyJS 2016 Moscow", 1045020001L, new QuestionOptions(true, true, false)));
            chart.AddQuestionDetails(new QuestionDetails("HolyJS 2017 Piter", 118678197L, new QuestionOptions(true, true, false)));

            ChoiceGroup answer1 = new ChoiceGroup();
            answer1.setText("Junior Developer");
            answer1.setID(new LinkedList<Long>() {
                {
                    add(10239887091L);
                    add(10789207613L);
                    add(874803001L);
                }
            });

            ChoiceGroup answer2 = new ChoiceGroup();
            answer2.setText("Middle Developer");
            answer2.setID(new LinkedList<Long>() {
                {
                    add(10239887092L);
                    add(10789207614L);
                    add(874803002L);
                }
            });

            ChoiceGroup answer3 = new ChoiceGroup();
            answer3.setText("Senior Developer");
            answer3.setID(new LinkedList<Long>() {
                {
                    add(10239887093L);
                    add(10789207615L);
                    add(874803003L);
                }
            });

            chart.addChoiceGroup(answer1);
            chart.addChoiceGroup(answer2);
            chart.addChoiceGroup(answer3);

            preset.AddChart(chart);
        }
        return preset;

    }

}
