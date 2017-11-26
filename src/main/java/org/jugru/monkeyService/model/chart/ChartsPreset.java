
package org.jugru.monkeyService.model.chart;

import java.util.ArrayList;
import java.util.List;


public class ChartsPreset {
    private String name;
    private List<Chart> charts = new ArrayList<>();

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
    
    public void AddChart(Chart chart) {
        charts.add(chart);
    }
    
}
