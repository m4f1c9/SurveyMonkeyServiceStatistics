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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
import org.springframework.context.ApplicationContextAware;

@Entity
public class UngroupedCharts extends Chart {

    @Column
    private String chartName;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SingleQuestionChart> charts = new ArrayList<>();
    @OneToOne
    private ChartOptions chartOptions;

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public List<SingleQuestionChart> getCharts() {
        return charts;
    }

    public void setCharts(List<SingleQuestionChart> charts) {
        this.charts = charts;
    }

    public UngroupedCharts(String chartName, List<SingleQuestionChart> charts, ChartOptions chartOptions) {
        this.chartName = chartName;
        this.charts = charts;
        this.chartOptions = chartOptions;
    }

    public UngroupedCharts() {
    }

    @Override
    public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder) {
        return chartDataBuilder.createChartDataFromUngroupedCharts(this);
    }

}
