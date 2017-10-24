package org.jugru.monkeyService.model.view;

import java.util.Set;

public class ViewQuestions {
    
    private String name;
    private int position;
    private Set<ViewAnswer> answers;

    public void setPosition(int position) {
        this.position = position;
    }

    public void setAnswers(Set<ViewAnswer> answers) {
        this.answers = answers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<ViewAnswer> getAnswers() {
        return answers;
    }

    public int getPosition() {
        return position;
    }
    

}
