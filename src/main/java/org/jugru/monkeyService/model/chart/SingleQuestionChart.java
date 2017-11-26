package org.jugru.monkeyService.model.chart;

public class SingleQuestionChart {

    private String name;
    private Long questionMetaInfId;
    private Long surveyId;
    private boolean useRow_idInstedOfChoice_id;
    private boolean withGradientColors;

    public boolean isWithGradientColors() {
        return withGradientColors;
    }

    public void setWithGradientColors(boolean withGradientColors) {
        this.withGradientColors = withGradientColors;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuestionMetaInfId() {
        return questionMetaInfId;
    }

    public void setQuestionMetaInfId(Long questionMetaInfId) {
        this.questionMetaInfId = questionMetaInfId;
    }

    public boolean isUseRow_idInstedOfChoice_id() {
        return useRow_idInstedOfChoice_id;
    }

    public void setUseRow_idInstedOfChoice_id(boolean useRow_idInstedOfChoice_id) {
        this.useRow_idInstedOfChoice_id = useRow_idInstedOfChoice_id;
    }

    public SingleQuestionChart(String name, Long surveyId, Long questionMetaInfId, boolean withGradientColors) {
        this.name = name;
        this.questionMetaInfId = questionMetaInfId;
        this.surveyId = surveyId;
        this.withGradientColors = withGradientColors;
    }

    public SingleQuestionChart(String name, Long surveyId, Long questionMetaInfId) {
        this.name = name;
        this.questionMetaInfId = questionMetaInfId;
        this.surveyId = surveyId;
    }

    @Override
    public String toString() {
        return "SingleChart{" + "name=" + name + ", questionMetaInfId=" + questionMetaInfId + ", surveyId=" + surveyId + ", useRow_idInstedOfChoice_id=" + useRow_idInstedOfChoice_id + '}';
    }

}
