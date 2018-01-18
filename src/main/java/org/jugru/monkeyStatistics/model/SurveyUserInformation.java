package org.jugru.monkeyStatistics.model;

import javax.persistence.Embeddable;

import static java.util.Objects.isNull;

@Embeddable
public class SurveyUserInformation {
    private String status;
    private Boolean conferenceSurvey;
    private Boolean processed;
    private Boolean withDetails;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getConferenceSurvey() {
        if (isNull(this.conferenceSurvey)){
            this.conferenceSurvey = false;
        }
        return conferenceSurvey;
    }

    public void setConferenceSurvey(Boolean conferenceSurvey) {
        this.conferenceSurvey = conferenceSurvey;
    }

    public Boolean getProcessed() {
        if (isNull(this.processed)){
            this.processed = false;
        }
        return processed;
    }

    public Boolean getWithDetails() {
        if (isNull(this.withDetails)){
            this.withDetails = false;
        }
        return withDetails;
    }

    public void setWithDetails(Boolean withDetails) {
        this.withDetails = withDetails;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
}
