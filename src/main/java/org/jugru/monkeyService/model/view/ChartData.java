package org.jugru.monkeyService.model.view;

import java.util.LinkedList;
import java.util.List;

public class ChartData {

    private List<List> data = new LinkedList<>();
    private Options options;

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
