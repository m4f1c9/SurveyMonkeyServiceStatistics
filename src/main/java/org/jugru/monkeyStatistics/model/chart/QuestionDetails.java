package org.jugru.monkeyStatistics.model.chart;

import javax.persistence.*;

@Entity
public class QuestionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private long questionId;

    /**
     * NULL по умолчанию
     * нужет для отправки на UI
     */
    @Embedded
    private QuestionOptions questionOptions;

    
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

    public QuestionDetails() {
    }

    public QuestionOptions getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(QuestionOptions questionOptions) {
        this.questionOptions = questionOptions;
    }

    public QuestionDetails(String name, long questionId) {
        this.name = name;
        this.questionId = questionId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuestionDetails(String name, long questionId, QuestionOptions questionOptions) {
        this.name = name;
        this.questionId = questionId;
        this.questionOptions = questionOptions;
    }

}
