package org.jugru.monkeyService.model.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyService.model.view.ChoiceGroup;
import org.jugru.monkeyService.model.view.ConferenceQuestionPair;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

public class GroupedByChoiceChart implements Chart {

    private String name;

    private List<ChoiceGroup> choiceGroups = new LinkedList<>();
    private List<ConferenceQuestionPair> conferenceQuestionPairs = new ArrayList<>();
    private ChartOptions chartOptions;

    public void AddConferenceQuestionPair(ConferenceQuestionPair conferenceQuestionPair) {
        conferenceQuestionPairs.add(conferenceQuestionPair);
    }

    public void addChoiceGroup(ChoiceGroup choiceGroup) {
        choiceGroups.add(choiceGroup);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChoiceGroup> getChoiceGroups() {
        return choiceGroups;
    }

    public void setChoiceGroups(List<ChoiceGroup> choiceGroups) {
        this.choiceGroups = choiceGroups;
    }

    public List<ConferenceQuestionPair> getConferenceQuestionPairs() {
        return conferenceQuestionPairs;
    }

    public void setConferenceQuestionPairs(List<ConferenceQuestionPair> conferenceQuestionPairs) {
        this.conferenceQuestionPairs = conferenceQuestionPairs;
    }

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    public GroupedByChoiceChart(String name, ChartOptions chartOptions) {
        this.name = name;
        this.chartOptions = chartOptions;
    }

    
    
    @Override
    public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder) {
        return Arrays.asList(chartDataBuilder.createChartDataFromGroupedByChoiceChart(this));
    }

}
