package org.jugru.monkeyService.model.chart;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private boolean withCustomChoice;
    @Column
    private boolean withNoChoice;
    @Column
    private boolean useRow_idInstedOfChoice_id;

    public QuestionOptions() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionOptions(boolean withCustomChoice, boolean withNoChoice, boolean useRow_idInstedOfChoice_id) {
        this.withCustomChoice = withCustomChoice;
        this.withNoChoice = withNoChoice;
        this.useRow_idInstedOfChoice_id = useRow_idInstedOfChoice_id;
    }

    public boolean isUseRow_idInstedOfChoice_id() {
        return useRow_idInstedOfChoice_id;
    }

    public void setUseRow_idInstedOfChoice_id(boolean useRow_idInstedOfChoice_id) {
        this.useRow_idInstedOfChoice_id = useRow_idInstedOfChoice_id;
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
