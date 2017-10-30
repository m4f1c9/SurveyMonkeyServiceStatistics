package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ViewQuestion {

    private String name;
    private List<ViewAnswer> answersList = new LinkedList<>();

    public void AddAnswer(ViewAnswer viewAnswer){
        answersList.add(viewAnswer);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ViewAnswer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<ViewAnswer> answersList) {
        this.answersList = answersList;
    }

}
