package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.List;

public class ViewAnswer {

    private String text;
    private List<Long> IDList = new ArrayList<>();

    public void addID(long id) {
        IDList.add(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> getIDList() {
        return IDList;
    }

    public void setIDList(List<Long> IDList) {
        this.IDList = IDList;
    }

}
