package org.jugru.monkeyService.model.view;

public class SpeakersRatingPair {

    private Long speakersAnswerID;
    private Long RatingAnswerID;
    private String text;

    public SpeakersRatingPair(Long speakersAnswerID, Long RatingAnswerID, String text) {
        this.speakersAnswerID = speakersAnswerID;
        this.RatingAnswerID = RatingAnswerID;
        this.text = text;
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
