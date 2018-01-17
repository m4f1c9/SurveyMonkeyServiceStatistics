package org.jugru.monkeyStatistics.model;

import javax.persistence.Embeddable;

@Embeddable
public class SurveyUserInformation {
    private String status;
    private Boolean conferenceSurvey;
    private Boolean processed;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
