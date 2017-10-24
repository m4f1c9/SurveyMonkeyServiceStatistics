package org.jugru.monkeyStatistics.util;

import java.util.LinkedList;
import java.util.List;
import org.jugru.monkeyService.model.view.DataTable;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyService.model.view.Conference;
import org.jugru.monkeyService.model.view.Options;
import org.jugru.monkeyService.model.view.ViewQuestions;
import org.jugru.monkeyStatistics.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChartDataBuilder {

    @Autowired
    private AnswerService answerService;

    List<ChartData> horizontalDefaultConfirenceData(Conference conforence) {
        List<ChartData> list = new LinkedList<>();
        for (ViewQuestions questions : conforence.getQuestions()) {
            Options options = new Options(null, "horizontal", conforence.getName(), questions.getName());
            DataTable dataTable = new DataTable();

            dataTable.addColumn("String", null, questions.getName());
        }

        return list;
    }
}
