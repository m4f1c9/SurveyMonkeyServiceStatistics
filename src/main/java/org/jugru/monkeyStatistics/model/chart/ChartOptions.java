package org.jugru.monkeyStatistics.model.chart;

import javax.persistence.*;

@Embeddable
public class ChartOptions {


    @Column
    private Tooltip tooltip;
    @Column
    private Annotation annotation;
    @Column
    private boolean useGradient;

    public ChartOptions(ChartOptions chartOptions) {
        this.tooltip = chartOptions.tooltip;
        this.annotation = chartOptions.annotation;
        this.useGradient = false;
    }

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

    @Override
    public String toString() {
        return "ChartOptions{" +
                "tooltip=" + tooltip +
                ", annotation=" + annotation +
                ", useGradient=" + useGradient +
                '}';
    }
}
