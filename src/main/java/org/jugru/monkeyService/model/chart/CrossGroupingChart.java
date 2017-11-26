package org.jugru.monkeyService.model.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

public class CrossGroupingChart implements Chart {

    private String chartName;

    private Long firstQuestionMetaInfId;
    private Long secondQuestionMetaInfId;
    private Long surveyID;
    private boolean useRow_idInstedOfChoice_idForFirstQuestion;
    private boolean useRow_idInstedOfChoice_idForSecondQuestion;

    private ChartOptions chartOptions;

    public boolean isUseRow_idInstedOfChoice_idForFirstQuestion() {
        return useRow_idInstedOfChoice_idForFirstQuestion;
    }

    public void setUseRow_idInstedOfChoice_idForFirstQuestion(boolean useRow_idInstedOfChoice_idForFirstQuestion) {
        this.useRow_idInstedOfChoice_idForFirstQuestion = useRow_idInstedOfChoice_idForFirstQuestion;
    }

    public boolean isUseRow_idInstedOfChoice_idForSecondQuestion() {
        return useRow_idInstedOfChoice_idForSecondQuestion;
    }

    public void setUseRow_idInstedOfChoice_idForSecondQuestion(boolean useRow_idInstedOfChoice_idForSecondQuestion) {
        this.useRow_idInstedOfChoice_idForSecondQuestion = useRow_idInstedOfChoice_idForSecondQuestion;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public Long getFirstQuestionMetaInfId() {
        return firstQuestionMetaInfId;
    }

    public void setFirstQuestionMetaInfId(Long firstQuestionMetaInfId) {
        this.firstQuestionMetaInfId = firstQuestionMetaInfId;
    }

    public Long getSecondQuestionMetaInfId() {
        return secondQuestionMetaInfId;
    }

    public void setSecondQuestionMetaInfId(Long secondQuestionMetaInfId) {
        this.secondQuestionMetaInfId = secondQuestionMetaInfId;
    }

    public Long getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(Long surveyID) {
        this.surveyID = surveyID;
    }

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    public CrossGroupingChart(String chartName, Long surveyID, Long firstQuestionMetaInfId, Long secondQuestionMetaInfId, ChartOptions chartOptions) {
        this.chartName = chartName;
        this.firstQuestionMetaInfId = firstQuestionMetaInfId;
        this.secondQuestionMetaInfId = secondQuestionMetaInfId;
        this.surveyID = surveyID;
        this.chartOptions = chartOptions;
    }

    @Override
    public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder) {
        return Arrays.asList(chartDataBuilder.createChartDataFromCrossGroupingChart(this));
    }

}
