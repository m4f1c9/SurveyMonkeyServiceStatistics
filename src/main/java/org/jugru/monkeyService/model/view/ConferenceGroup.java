package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.List;

public class ConferenceGroup {

    private String name;
    private List<QuestionGroup> questionsGroups = new ArrayList<>();



    public void addQuestionGroup(QuestionGroup viewQuestions) {
        questionsGroups.add(viewQuestions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public List<QuestionGroup> getQuestionGroups() {
        return questionsGroups;
    }

    public void setQuestionGroups(List<QuestionGroup> questionsGroups) {
        this.questionsGroups = questionsGroups;
    }

}
