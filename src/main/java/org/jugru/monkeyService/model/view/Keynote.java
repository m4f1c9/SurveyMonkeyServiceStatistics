package org.jugru.monkeyService.model.view;

public class Keynote {

    private Long keynoteQuestionMetaInfID;
    private String text;
    private Long surveyID;

    public Keynote(Long keynoteQuestionMetaInfID, String text, Long surveyID) {
        this.keynoteQuestionMetaInfID = keynoteQuestionMetaInfID;
        this.text = text;
        this.surveyID = surveyID;
    }
    
    

    public Long getKeynoteQuestionMetaInfID() {
        return keynoteQuestionMetaInfID;
    }

    public void setKeynoteQuestionMetaInfID(Long keynoteQuestionMetaInfID) {
        this.keynoteQuestionMetaInfID = keynoteQuestionMetaInfID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(Long surveyID) {
        this.surveyID = surveyID;
    }

    
}
