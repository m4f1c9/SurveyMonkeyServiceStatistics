package org.jugru.monkeyService.model.view;

public class ConferenceQuestionPair {

    private String name;
    private long surveyId;
    private long questionId;

    public ConferenceQuestionPair() {
    }

    public ConferenceQuestionPair(String name, long surveyId, long questionId) {
        this.name = name;
        this.surveyId = surveyId;
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

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

}
