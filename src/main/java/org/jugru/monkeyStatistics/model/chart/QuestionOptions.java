package org.jugru.monkeyStatistics.model.chart;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class QuestionOptions {



    @Column
    private boolean withCustomChoice;
    @Column
    private boolean withNoChoice;


    public QuestionOptions() {
    }




    public boolean isWithCustomChoice() {
        return withCustomChoice;
    }

    public void setWithCustomChoice(boolean withCustomChoice) {
        this.withCustomChoice = withCustomChoice;
    }

    public boolean isWithNoChoice() {
        return withNoChoice;
    }

    public void setWithNoChoice(boolean withNoChoice) {
        this.withNoChoice = withNoChoice;
    }

}
