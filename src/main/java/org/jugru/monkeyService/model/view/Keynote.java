package org.jugru.monkeyService.model.view;

public class Keynote {

    private Long keynoteAnswerID;
    private String text;

    public Keynote(Long keynoteAnswerID, String text) {
        this.keynoteAnswerID = keynoteAnswerID;
        this.text = text;
    }

    public Long getKeynoteAnswerID() {
        return keynoteAnswerID;
    }

    public void setKeynoteAnswerID(Long keynoteAnswerID) {
        this.keynoteAnswerID = keynoteAnswerID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
