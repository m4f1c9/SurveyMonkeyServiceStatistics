package org.jugru.monkeyStatistics.util;

public class Questions {
    private Long id;
    private String name;
    private boolean withCustomChoice;
    private boolean withNoChoice;
    private boolean show;

    public Questions() {
    }

    public Questions(Long id, String name, boolean withCustomChoice, boolean withNoChoice) {
        this.id = id;
        this.name = name;
        this.withCustomChoice = withCustomChoice;
        this.withNoChoice = withNoChoice;
    }

    public Questions(Long id, String name, boolean withCustomChoice, boolean withNoChoice, boolean show) {
        this.id = id;
        this.name = name;
        this.withCustomChoice = withCustomChoice;
        this.withNoChoice = withNoChoice;
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
