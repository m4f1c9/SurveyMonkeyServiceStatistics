package org.jugru.monkeyStatistics.tempData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.chart.ChartOptions;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyService.model.chart.CrossGroupingChart;
import org.jugru.monkeyService.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyService.model.chart.SingleQuestionChart;
import org.jugru.monkeyService.model.chart.UngroupedCharts;
import org.jugru.monkeyService.model.view.ConferenceQuestionPair;
import org.jugru.monkeyService.model.view.ChoiceGroup;

public class Conferences {

    public static ChartsPreset test() {

        ChartsPreset preset = new ChartsPreset("1111!!!!!");
                {
                    UngroupedCharts ungroupedCharts = new UngroupedCharts();
                    ungroupedCharts.setChartName("Оцените организацию онлайн-трансляции");
                    ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.FULL, false, false);
                    chartOptions.setShowTitle(true);
                    ungroupedCharts.setChartOptions(chartOptions);
        
                    List<SingleQuestionChart> charts = new ArrayList<>();
                    SingleQuestionChart cqc;
                    cqc = new SingleQuestionChart("JPoint 2015", 63616183L, 790944403L, true);
                    cqc.setUseRow_idInstedOfChoice_id(false);
                    charts.add(cqc);
                    
                    cqc = new SingleQuestionChart("JPoint 2016", 78199292L, 945412851L, true);
                    cqc.setUseRow_idInstedOfChoice_id(false);
                    charts.add(cqc);
                    
                    cqc = new SingleQuestionChart("JPoint 2017", 88971560L, 1072183354L, true);
                    cqc.setUseRow_idInstedOfChoice_id(false);
                    charts.add(cqc);
                    
                    System.out.println(charts);
                    System.out.println(charts);
                    System.out.println(charts);
        
                    ungroupedCharts.setCharts(charts);
                    preset.AddChart(ungroupedCharts);
        
                }
                {
                    ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
                    CrossGroupingChart cgc = new CrossGroupingChart("Слот 10:30 – 11:20.", 125742994L, 203789246L, 203789403L, chartOptions);
                     cgc.setHideLastChoiceInFirst(true);
                    cgc.setHideLastChoiceInSecond(true);
                    preset.AddChart(cgc);
        
                }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Как вы покупали билет?", 125742994L, 203746709L, 203746713L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Насколько конференция в целом соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746770L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Оцените программу конференции в целом", 125742994L, 203746709L, 203746764L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Оцените техническую глубину программы", 125742994L, 203746709L, 203746765L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Насколько техническая глубина соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746768L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Оцените практическую применимость услышанного вами в докладах", 125742994L, 203746709L, 203746766L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Насколько практическая применимость услышанного вами на конференции соответствовала вашим ожиданиям?", 125742994L, 203746709L, 203746769L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {
            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            CrossGroupingChart cgc = new CrossGroupingChart("Конференции на какие другие темы вы бы посетили ?", 125742994L, 203746709L, 203746759L, chartOptions);
            cgc.setHideLastChoiceInFirst(false);
            cgc.setHideLastChoiceInSecond(false);
            preset.AddChart(cgc);

        }

        {

            ChartOptions chartOptions = new ChartOptions(ChartOptions.Tooltip.SHORT, ChartOptions.Annotation.SHORT, true, true);
            GroupedByChoiceChart chart = new GroupedByChoiceChart("Ваша позиция в компании?", chartOptions);

            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Piter", 80191211, 966831639L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2016 Moscow", 87269535, 1045020001L));
            chart.AddConferenceQuestionPair(new ConferenceQuestionPair("HolyJS 2017 Piter", 117652322, 118678197L));

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
