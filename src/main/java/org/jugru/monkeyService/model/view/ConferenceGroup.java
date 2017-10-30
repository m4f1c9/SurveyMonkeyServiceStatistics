package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.List;

public class ConferenceGroup {

    private String name;
    private List<Conference> conferenceList = new ArrayList<>();
    private List<ViewQuestion> questionsList = new ArrayList<>();

    public void addConference(Conference conference) {
        conferenceList.add(conference);
    }

    public void addQuestion(ViewQuestion viewQuestions) {
        questionsList.add(viewQuestions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Conference> getConferenceList() {
        return conferenceList;
    }

    public void setConferenceList(List<Conference> conferenceList) {
        this.conferenceList = conferenceList;
    }

    public List<ViewQuestion> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<ViewQuestion> questionsList) {
        this.questionsList = questionsList;
    }

}
