package org.jugru.monkeyService.model.view;

public class SpeakersRatingPair {

    private Long speakersAnswerID;
    private Long RatingAnswerID;
    private String text;
    private Long surveyID;

    public SpeakersRatingPair(Long speakersAnswerID, Long RatingAnswerID, String text, Long surveyID) {
        this.speakersAnswerID = speakersAnswerID;
        this.RatingAnswerID = RatingAnswerID;
        this.text = text;
        this.surveyID = surveyID;
    }

    public Long getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(Long surveyID) {
        this.surveyID = surveyID;
    }

    public Long getSpeakersAnswerID() {
        return speakersAnswerID;
    }

    public void setSpeakersAnswerID(Long speakersAnswerID) {
        this.speakersAnswerID = speakersAnswerID;
    }

    public Long getRatingAnswerID() {
        return RatingAnswerID;
    }

    public void setRatingAnswerID(Long RatingAnswerID) {
        this.RatingAnswerID = RatingAnswerID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
