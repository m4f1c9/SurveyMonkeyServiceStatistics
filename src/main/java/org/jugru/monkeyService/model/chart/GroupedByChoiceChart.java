package org.jugru.monkeyService.model.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
@Entity
public class GroupedByChoiceChart extends Chart {

  
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChoiceGroup> choiceGroups = new ArrayList<>();
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionDetails> questionDetails = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ChartOptions chartOptions;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private QuestionOptions questionOptions;
    
    @Transient
    Class clazz = this.getClass();

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
    
    

    public GroupedByChoiceChart() {
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

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    public GroupedByChoiceChart(String name, ChartOptions chartOptions) {
        super.setChartName(name);
        this.chartOptions = chartOptions;
    }

    public QuestionOptions getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(QuestionOptions questionOptions) {
        this.questionOptions = questionOptions;
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
