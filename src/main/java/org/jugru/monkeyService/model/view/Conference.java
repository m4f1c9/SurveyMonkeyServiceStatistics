package org.jugru.monkeyService.model.view;

import java.util.Set;

public class Conference {

    private String name;
    private Set<ViewQuestions> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ViewQuestions> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<ViewQuestions> questions) {
        this.questions = questions;
    }

}
