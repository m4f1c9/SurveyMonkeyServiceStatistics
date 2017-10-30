package org.jugru.monkeyStatistics.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyService.model.view.Conference;
import org.jugru.monkeyService.model.view.ConferenceGroup;
import org.jugru.monkeyService.model.view.Options;
import org.jugru.monkeyService.model.view.ViewAnswer;
import org.jugru.monkeyService.model.view.ViewQuestion;
import org.jugru.monkeyStatistics.service.AnswerService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Не трогай без крайней необходимости
 *
 */
@Component
public class ChartDataBuilder {

    @Autowired
    AnswerService answerService;

    @Autowired
    SurveyService surveyService;

    public List<ChartData> standartChart(ConferenceGroup conferenceGroup) {
        List<ChartData> chartDataList = new LinkedList<>();

        List columns = new LinkedList<>();                      // Единые названия для всех таблиц
        columns.add("");                             //TODO вынести отдельно
        conferenceGroup.getConferenceList().forEach((t) -> {
            columns.add(t.getName());
        });

        for (int i = 0; i < conferenceGroup.getQuestionsList().size(); i++) { // обходим все ViewQuestion каждый будет отдельной таблицей

            ChartData chartData = new ChartData();
            Options options = new Options((conferenceGroup.getQuestionsList().get(i).getAnswersList().size() + 1) * 100, "horizontal", conferenceGroup.getQuestionsList().get(i).getName(), conferenceGroup.getName()); //подумать про высоту
            chartData.setOptions(options);

            chartData.getData().add(columns);

            ViewQuestion viewQuestion = conferenceGroup.getQuestionsList().get(i);

            List<Double> otherTMP = new LinkedList<>();  // нужен для подсчета других ответов
            for (int f = 0; f < conferenceGroup.getConferenceList().size(); f++) {
                otherTMP.add(100.0);
            }

            for (int j = 0; j < viewQuestion.getAnswersList().size(); j++) {  // отходим ViewAnswer
                ViewAnswer viewAnswer = viewQuestion.getAnswersList().get(j);

                List row = new LinkedList();
                row.add(viewAnswer.getText());

                for (int k = 0; k < viewAnswer.getIDList().size(); k++) {  // обходим конкретные ответы 
                    if (Objects.nonNull(viewAnswer.getIDList().get(k))) {

                        int conferenceAnswers = surveyService.countAnswers(conferenceGroup.getConferenceList().get(k).getId());
                        long thisAnswers = answerService.countByChoice_id(viewAnswer.getIDList().get(k));
                        Double percent = ((double) thisAnswers / (double) conferenceAnswers) * 100.00;

                        otherTMP.set(k, otherTMP.get(k) - percent);
                        row.add(percent);
                    } else {
                        row.add(null);
                    }
                }
                chartData.getData().add(row);
            }

            List other = new LinkedList();
            other.add("Свой ответ / Отсутствие ответа");
            other.addAll(otherTMP);
            chartData.getData().add(other);

            chartDataList.add(chartData);
        }

        return chartDataList;
    }
}
