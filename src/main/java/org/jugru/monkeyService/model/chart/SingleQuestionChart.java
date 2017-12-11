package org.jugru.monkeyService.model.chart;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class SingleQuestionChart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Long questionMetaInfId;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private QuestionOptions questionOptions;

    public SingleQuestionChart() {
    }

    @Transient
    private Long surveyId;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionOptions getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(QuestionOptions questionOptions) {
        this.questionOptions = questionOptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuestionMetaInfId() {
        return questionMetaInfId;
    }

    public void setQuestionMetaInfId(Long questionMetaInfId) {
        this.questionMetaInfId = questionMetaInfId;
    }

    public SingleQuestionChart(String name, Long questionMetaInfId) {
        this.name = name;
        this.questionMetaInfId = questionMetaInfId;

    }

}
