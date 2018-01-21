package org.jugru.monkeyStatistics.model.chart;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

import javax.persistence.*;
import java.util.List;




@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CrossGroupingChart.class, name = "CrossGroupingChart"),
        @JsonSubTypes.Type(value = UngroupedCharts.class, name = "UngroupedCharts"),
        @JsonSubTypes.Type(value = GroupedByChoiceChart.class, name = "GroupedByChoiceChart"),

})
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Chart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 1024)
    private String chartName;

    @Embedded
    private ChartOptions chartOptions;

    public ChartOptions getChartOptions() {
        return chartOptions;
    }

    public void setChartOptions(ChartOptions chartOptions) {
        this.chartOptions = chartOptions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    abstract public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder);

    abstract public void prepareForSending(SurveyService surveyService);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
     //   if (o == null || (getClass() != o.getClass())) return false; // TODO проверить и удалить
        if (o == null || !(o instanceof Chart))return false;
        Chart chart = (Chart) o;

        return id != null ? id.equals(chart.id) : false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", chartName='" + chartName + '\'' +
                ", chartOptions=" + chartOptions +
                '}';
    }

    @PrePersist
    public void preInsert() {
        if(this.chartOptions ==null)
            this.chartOptions = new ChartOptions();
        if (this.chartOptions.getTooltip() == null)
            this.chartOptions.setTooltip(ChartOptions.Tooltip.FULL);
        if (this.chartOptions.getAnnotation() == null)
            this.chartOptions.setAnnotation(ChartOptions.Annotation.SHORT);
    }
}
