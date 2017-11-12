package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.List;

public class AnswersGroup {

    private String text;
    private List<Long> ID = new ArrayList<>();

    public void addID(Long id) {
        ID.add(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> getID() {
        return ID;
    }

    public void setID(List<Long> ID) {
        this.ID = ID;
    }

}
