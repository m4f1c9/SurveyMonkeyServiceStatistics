package org.jugru.monkeyService.model.chart;

import java.util.ArrayList;
import java.util.List;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
import org.springframework.context.ApplicationContextAware;

public class UngroupedCharts implements Chart {

    private String chartName;
    private List<SingleQuestionChart> charts;
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
