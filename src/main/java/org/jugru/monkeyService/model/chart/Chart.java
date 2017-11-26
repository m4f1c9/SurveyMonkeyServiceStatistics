package org.jugru.monkeyService.model.chart;

import java.util.List;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;

public interface Chart {
    public List<ChartData> createChartData(ChartDataBuilder chartDataBuilder);
   
}
