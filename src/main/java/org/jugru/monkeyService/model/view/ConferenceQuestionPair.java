package org.jugru.monkeyService.model.view;

public class ConferenceQuestionPair {

    private String name;
    private long surveyId;
    private long questionId;
    private boolean useRow_idInstedOfChoice_id;

    public ConferenceQuestionPair() {
    }

    public boolean isUseRow_idInstedOfChoice_id() {
        return useRow_idInstedOfChoice_id;
    }

    public void setUseRow_idInstedOfChoice_id(boolean useRow_idInstedOfChoice_id) {
        this.useRow_idInstedOfChoice_id = useRow_idInstedOfChoice_id;
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
