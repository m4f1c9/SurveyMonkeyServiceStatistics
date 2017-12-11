package org.jugru.monkeyService.model.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

@Entity
public class CrossGroupingChart extends Chart {

    @Column
    private Long firstQuestionMetaInformationId;
    @Column
    private Long secondQuestionMetaInformationId;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private QuestionOptions firstQuestionOptions;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private QuestionOptions secondQuestionOptions;
    @Column
    private boolean hideLastChoiceInFirstQuestion;
    @Column
    private boolean hideLastChoiceInSecondQuestion;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ChartOptions chartOptions;

    @Transient
    private Long surveyId;
    @Transient
    private Class clazz = this.getClass();

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public CrossGroupingChart() {
    }

    public QuestionOptions getFirstQuestionOptions() {
        return firstQuestionOptions;
    }

    public void setFirstQuestionOptions(QuestionOptions firstQuestionOptions) {
        this.firstQuestionOptions = firstQuestionOptions;
    }

    public QuestionOptions getSecondQuestionOptions() {
        return secondQuestionOptions;
    }

    public void setSecondQuestionOptions(QuestionOptions secondQuestionOptions) {
        this.secondQuestionOptions = secondQuestionOptions;
    }

    public boolean isHideLastChoiceInFirstQuestion() {
        return hideLastChoiceInFirstQuestion;
    }

    public void setHideLastChoiceInFirstQuestion(boolean hideLastChoiceInFirstQuestion) {
        this.hideLastChoiceInFirstQuestion = hideLastChoiceInFirstQuestion;
    }

    public boolean isHideLastChoiceInSecondQuestion() {
        return hideLastChoiceInSecondQuestion;
    }

    public void setHideLastChoiceInSecondQuestion(boolean hideLastChoiceInSecondQuestion) {
        this.hideLastChoiceInSecondQuestion = hideLastChoiceInSecondQuestion;
    }

    public Long getFirstQuestionMetaInformationId() {
        return firstQuestionMetaInformationId;
    }

    public void setFirstQuestionMetaInformationId(Long firstQuestionMetaInformationId) {
        this.firstQuestionMetaInformationId = firstQuestionMetaInformationId;
    }

    public Long getSecondQuestionMetaInformationId() {
        return secondQuestionMetaInformationId;
    }

    public void setSecondQuestionMetaInformationId(Long secondQuestionMetaInformationId) {
        this.secondQuestionMetaInformationId = secondQuestionMetaInformationId;
    }

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    public CrossGroupingChart(String chartName, Long firstQuestionMetaInformationId, Long secondQuestionMetaInformationId, ChartOptions chartOptions) {
        super.setChartName(chartName);
        this.firstQuestionMetaInformationId = firstQuestionMetaInformationId;
        this.secondQuestionMetaInformationId = secondQuestionMetaInformationId;
        this.chartOptions = chartOptions;
    }

    @Override
    public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder) {
        return Arrays.asList(chartDataBuilder.createChartDataFromCrossGroupingChart(this));
    }

    @Override
    public void prepareForSending(SurveyService surveyService) {
        this.surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(firstQuestionMetaInformationId);
    }

}
