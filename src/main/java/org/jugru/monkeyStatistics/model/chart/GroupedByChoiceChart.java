package org.jugru.monkeyStatistics.model.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

@Entity
@Table
public class GroupedByChoiceChart extends Chart {

    @OrderColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChoiceGroup> choiceGroups = new ArrayList<>();

    @OrderColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionDetails> questionDetails = new ArrayList<>();

    @Embedded
    private QuestionOptions questionOptions;


    public QuestionOptions getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(QuestionOptions questionOptions) {
        this.questionOptions = questionOptions;
    }

    public GroupedByChoiceChart() {
    }

    public GroupedByChoiceChart(QuestionOptions questionOptions) {
        this.questionOptions = questionOptions;
    }

    public List<QuestionDetails> getQuestionDetails() {
        return questionDetails;
    }

    public void setQuestionDetails(List<QuestionDetails> questionDetails) {
        this.questionDetails = questionDetails;
    }

    public void AddQuestionDetails(QuestionDetails questionDetails) {
        this.questionDetails.add(questionDetails);
    }

    public void addChoiceGroup(ChoiceGroup choiceGroup) {
        choiceGroups.add(choiceGroup);
    }


    public List<ChoiceGroup> getChoiceGroups() {
        return choiceGroups;
    }

    public void setChoiceGroups(List<ChoiceGroup> choiceGroups) {
        this.choiceGroups = choiceGroups;
    }


    public GroupedByChoiceChart(String name, ChartOptions chartOptions) {
        super.setChartName(name);
        setChartOptions(chartOptions);
    }


    @Override
    public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder) {
        return Arrays.asList(chartDataBuilder.createChartDataFromGroupedByChoiceChart(this));

    }

    @Override
    public void prepareForSending(SurveyService surveyService) {
        questionDetails.forEach((t) -> {
            t.setSurveyId(surveyService.findSurveyIdByQuestionMetaInformationId(t.getQuestionId()));
        });
    }


}
