package org.jugru.monkeyStatistics.api;

import java.util.ArrayList;
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
//
//    @RequestMapping("/HJSA")
//    public List<ChartData> holuJSA() {
//        return chartDataBuilder.standartSingleChoiceChartGroupedByAnswer(Conferences.holyJS());
//    }
//
//    @RequestMapping("/HJSC")
//    public List<ChartData> holuJSC() {
//        return chartDataBuilder.standartSingleChoiceChartGroupedByConfirence(Conferences.holyJS());
//    }
//
//    @RequestMapping("/mobi2")
//    public List<ChartData> mobius() {
//        return chartDataBuilder.singleConferenceSpeakers(Conferences.mobius());
//    }
//
//    @RequestMapping("/JPA")
//    public List<ChartData> JPointA() {
//        return chartDataBuilder.standartSingleChoiceChartGroupedByAnswer(Conferences.JPoint());
//    }
//
//    @RequestMapping("/JPС")
//    public List<ChartData> JPointС() {
//        return chartDataBuilder.standartSingleChoiceChartGroupedByConfirence(Conferences.JPoint());
//    }

    @RequestMapping("/test")
    public List<ChartData> test() {
        return chartDataBuilder.createChartDataFromChartsPreset(Conferences.test());
    }

    @RequestMapping("/mobius2")
    public List<ChartData> mobius2() {
        return chartDataBuilder.createChartDataFromChartsPreset(Conferences.mobius2());
    }

}
