package org.jugru.monkeyStatistics.model.chart;

import java.util.ArrayList;
import java.util.List;

public class ChartData {

    private Long id;

    private List<List> data = new ArrayList<>();

    private Options options;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addData(List list) {
        data.add(list);
    }

    public List<List> getData() {
        return data;
    }

    public void setData(List<List> data) {
        this.data = data;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

}
