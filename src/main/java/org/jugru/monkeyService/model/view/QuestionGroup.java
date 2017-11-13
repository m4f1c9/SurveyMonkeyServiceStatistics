package org.jugru.monkeyService.model.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class QuestionGroup {

    private String name;
    private boolean withCustomAnswer;
    private boolean withNoAnswer;
    private List<ChoiceGroup> choiceGroups = new LinkedList<>();
    private List<ConferenceQuestionPair> conferenceQuestionPairs = new ArrayList<>();


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

    public List<ConferenceQuestionPair> getConferenceQuestionPairs() {
        return conferenceQuestionPairs;
    }

    public void setConferenceQuestionPairs(List<ConferenceQuestionPair> ConferenceQuestionPairs) {
        this.conferenceQuestionPairs = ConferenceQuestionPairs;
    }

    
    public void AddConferenceQuestionPair(ConferenceQuestionPair conferenceQuestionPair) {
        conferenceQuestionPairs.add(conferenceQuestionPair);
    }


    public void AddChoiceGroup(ChoiceGroup choiceGroup) {
        choiceGroups.add(choiceGroup);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChoiceGroup> getChoiceGroups() {
        return choiceGroups;
    }

    public void setChoiceGroups(List<ChoiceGroup> ChoiceGroups) {
        this.choiceGroups = ChoiceGroups;
    }

}
