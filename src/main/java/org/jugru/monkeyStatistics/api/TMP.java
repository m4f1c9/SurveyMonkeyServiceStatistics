package org.jugru.monkeyStatistics.api;

import java.util.List;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyStatistics.tempData.Conferences;
import org.jugru.monkeyStatistics.util.ChartDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TMP {

    @Autowired
    ChartDataBuilder chartDataBuilder;

    @RequestMapping("/HJSA")
    public List<ChartData> holuJSA() {
        return chartDataBuilder.standartSingleChoiceChartGroupedByAnswer(Conferences.holyJS());
    }
    
    @RequestMapping("/HJSC")
    public List<ChartData> holuJSC() {
        return chartDataBuilder.standartSingleChoiceChartGroupedByConfirence(Conferences.holyJS());
    }

    
}
