package org.jugru.monkeyStatistics.model.chart;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class ChartsPreset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OrderColumn
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chart> charts = new ArrayList<>();

    public ChartsPreset() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }

    public ChartsPreset(String name) {
        this.name = name;
    }


    public void addChart(Chart chart) {
        charts.add(chart);
    }

}
