package org.jugru.monkeyStatistics.model.chart;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class ChartOptions {


    @Column
    private Tooltip tooltip;
    @Column
    private Annotation annotation;
    @Column
    private boolean useGradient;

    public ChartOptions() {
    }



    public boolean isUseGradient() {
        return useGradient;
    }

    public void setUseGradient(boolean useGradient) {
        this.useGradient = useGradient;
    }

    public ChartOptions(Tooltip tooltip, Annotation annotation) {
        this.tooltip = tooltip;
        this.annotation = annotation;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    static public enum Tooltip {
        FULL, SHORT, NO
    };

    static public enum Annotation {
        FULL, SHORT, NO
    };
}
