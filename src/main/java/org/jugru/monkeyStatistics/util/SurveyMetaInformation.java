package org.jugru.monkeyStatistics.util;


import java.util.Objects;

public class SurveyMetaInformation implements Comparable<SurveyMetaInformation> {
    private Long id;
    private String name;
    private Boolean conferenceSurvey;
    private Boolean processed;

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

    public Boolean getConferenceSurvey() {
        return conferenceSurvey;
    }

    public void setConferenceSurvey(Boolean conferenceSurvey) {
        this.conferenceSurvey = conferenceSurvey;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Override
    public int compareTo(SurveyMetaInformation o) {
        if (Objects.equals(id, o.id)) {
            return 0;
        } else if (id > o.id) {
            return 1;
        } else {
            return -1;
        }
    }
}
