package org.jugru.monkeyStatistics.model.chart;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

@Entity
public class UngroupedCharts extends Chart {

    @OrderColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SingleQuestionChart> charts = new ArrayList<>();



    public List<SingleQuestionChart> getCharts() {
        return charts;
    }

    public void setCharts(List<SingleQuestionChart> charts) {
        this.charts = charts;
    }

    public UngroupedCharts(String chartName, List<SingleQuestionChart> charts, ChartOptions chartOptions) {
        super.setChartName(chartName);
        this.charts = charts;
       setChartOptions(chartOptions);
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

    @Override
    public String toString() {
        return "UngroupedCharts{" +
                "charts=" + charts +
                "} " + super.toString();
    }
}
