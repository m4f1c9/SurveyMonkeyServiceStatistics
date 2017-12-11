package org.jugru.monkeyService.model.chart;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
import org.springframework.context.ApplicationContextAware;

@Entity
public class UngroupedCharts extends Chart {

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SingleQuestionChart> charts = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ChartOptions chartOptions;

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    @Transient
    Class clazz = this.getClass();

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public List<SingleQuestionChart> getCharts() {
        return charts;
    }

    public void setCharts(List<SingleQuestionChart> charts) {
        this.charts = charts;
    }

    public UngroupedCharts(String chartName, List<SingleQuestionChart> charts, ChartOptions chartOptions) {
        super.setChartName(chartName);
        this.charts = charts;
        this.chartOptions = chartOptions;
    }

    public UngroupedCharts() {
    }

    @Override
    public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder) {
        return chartDataBuilder.createChartDataFromUngroupedCharts(this);
    }

    @Override
    public void prepareForSending(SurveyService surveyService) {
       charts.forEach((t) -> {
           t.setSurveyId(surveyService.findSurveyIdByQuestionMetaInformationId(t.getQuestionMetaInfId()));
       });
    }

    
}
