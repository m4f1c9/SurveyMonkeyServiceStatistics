package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class QuestionsGroup {

    private String name;
    private boolean withCustomAnswer;
    private boolean withNoAnswer;
    private List<AnswersGroup> answersGroups = new LinkedList<>();
    private List<Long> ID = new LinkedList<>();

    public boolean isWithCustomAnswer() {
        return withCustomAnswer;
    }

    public void setWithCustomAnswer(boolean withCustomAnswer) {
        this.withCustomAnswer = withCustomAnswer;
    }

    public boolean isWithNoAnswer() {
        return withNoAnswer;
    }

    public void setWithNoAnswer(boolean withNoAnswer) {
        this.withNoAnswer = withNoAnswer;
    }

    
    
    public List<Long> getID() {
        return ID;
    }

    public void setID(List<Long> ID) {
        this.ID = ID;
    }

    public void AddAnswerGroup(AnswersGroup viewAnswer) {
        answersGroups.add(viewAnswer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnswersGroup> getAnswersGroups() {
        return answersGroups;
    }

    public void setAnswersGroups(List<AnswersGroup> AnswersGroups) {
        this.answersGroups = AnswersGroups;
    }

}
