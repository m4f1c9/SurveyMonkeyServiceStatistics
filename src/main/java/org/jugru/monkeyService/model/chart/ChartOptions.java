package org.jugru.monkeyService.model.chart;

public class ChartOptions {

    private Tooltip tooltip;
    private Annotation annotation;
    private boolean withCustomChoice;
    private boolean withNoChoice;
    private boolean showTitle;
    private boolean useGradient;

    public boolean isUseGradient() {
        return useGradient;
    }

    public void setUseGradient(boolean useGradient) {
        this.useGradient = useGradient;
    }
    
    
    
    public boolean isShowTitle() {
        return showTitle;
    }

    public void setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
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

    public ChartOptions(Tooltip tooltip, Annotation annotation, boolean withCustomChoice, boolean withNoChoice) {
        this.tooltip = tooltip;
        this.annotation = annotation;
        this.withCustomChoice = withCustomChoice;
        this.withNoChoice = withNoChoice;
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
