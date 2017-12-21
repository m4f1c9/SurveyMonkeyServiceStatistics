package org.jugru.monkeyStatistics.model.chart;

import java.util.Arrays;
import java.util.List;
import javax.persistence.*;

import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

@Entity
public class CrossGroupingChart extends Chart {

    @Column
    private Long firstQuestionMetaInformationId;
    @Column
    private Long secondQuestionMetaInformationId;
    @Embedded
    private QuestionOptions firstQuestionOptions;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="withCustomChoice", column=@Column(name="secondWithCustomChoice")),
            @AttributeOverride(name="withNoChoice", column=@Column(name="secondWithNoChoice")),
            @AttributeOverride(name="useRow_idInstedOfChoice_id", column=@Column(name="secondUseRow_idInstedOfChoice_id"))
    })
    private QuestionOptions secondQuestionOptions;
    @Column
    private boolean hideLastChoiceInFirstQuestion;
    @Column
    private boolean hideLastChoiceInSecondQuestion;


    @Transient
    private Long surveyId;




    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public CrossGroupingChart() {
    }

    public CrossGroupingChart(QuestionOptions firstQuestionOptions, QuestionOptions secondQuestionOptions) {
        this.firstQuestionOptions = firstQuestionOptions;
        this.secondQuestionOptions = secondQuestionOptions;
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



    public CrossGroupingChart(String chartName, Long firstQuestionMetaInformationId, Long secondQuestionMetaInformationId, ChartOptions chartOptions) {
        super.setChartName(chartName);
        this.firstQuestionMetaInformationId = firstQuestionMetaInformationId;
        this.secondQuestionMetaInformationId = secondQuestionMetaInformationId;
       setChartOptions(chartOptions);
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
