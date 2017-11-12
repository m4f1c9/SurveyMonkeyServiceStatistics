package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.List;

public class ConferencesGroup {

    private String name;
    private List<Conference> conferences = new ArrayList<>();
    private List<QuestionsGroup> questionsGroups = new ArrayList<>();

    public void addConference(Conference conference) {
        conferences.add(conference);
    }

    public void addQuestionGroup(QuestionsGroup viewQuestions) {
        questionsGroups.add(viewQuestions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    public List<QuestionsGroup> getQuestionsGroups() {
        return questionsGroups;
    }

    public void setQuestionsGroups(List<QuestionsGroup> questionsGroups) {
        this.questionsGroups = questionsGroups;
    }

}
