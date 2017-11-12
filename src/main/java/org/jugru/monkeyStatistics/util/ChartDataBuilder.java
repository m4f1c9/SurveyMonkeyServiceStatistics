package org.jugru.monkeyStatistics.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyService.model.view.Conference;
import org.jugru.monkeyService.model.view.ConferencesGroup;
import org.jugru.monkeyService.model.view.Options;
import org.jugru.monkeyService.model.view.AnswersGroup;
import org.jugru.monkeyService.model.view.QuestionsGroup;
import org.jugru.monkeyStatistics.service.AnswerService;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.jugru.monkeyStatistics.service.QuestionService;
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

    @Autowired
    QuestionMetaInformationService questionMetaInformationService;

    @Autowired
    QuestionService questionService;

    private final String CUSTOM_CHOICE = "Свой вариант ответа";
    private final String NO_CHOICE = "Нет ответа";

    public List<ChartData> standartSingleChoiceChartGroupedByAnswer(ConferencesGroup conferencesGroup) {
        List<ChartData> chartDataList = new LinkedList<>();

        for (int questionGroupCount = 0; questionGroupCount < conferencesGroup.getQuestionsGroups().size(); questionGroupCount++) { // обходим все QuestionsGroup каждый будет отдельной таблицей
            chartDataList.add(createChartDataGroupedByAnswer(conferencesGroup, questionGroupCount));
        }

        return chartDataList;
    }

    public List<ChartData> standartSingleChoiceChartGroupedByConfirence(ConferencesGroup conferencesGroup) {
        List<ChartData> chartDataList = new LinkedList<>();

        for (int questionGroupCount = 0; questionGroupCount < conferencesGroup.getQuestionsGroups().size(); questionGroupCount++) { // обходим все QuestionsGroup каждый будет отдельной таблицей
            chartDataList.add(createChartDataGroupedByConfirence(conferencesGroup, questionGroupCount));
        }

        return chartDataList;
    }

    private ChartData createChartDataGroupedByConfirence(ConferencesGroup conferencesGroup, int questionCount) {

        QuestionsGroup questionsGroup = conferencesGroup.getQuestionsGroups().get(questionCount);
        ChartData chartData = new ChartData();

        Options options = createOptions(questionsGroup);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesGroupedByConfirence(questionsGroup);
        chartData.addData(columnsNames);

        for (int confirenceCount = 0; confirenceCount < conferencesGroup.getConferences().size(); confirenceCount++) {
            if (isQuestionWasAscedAtConference(questionsGroup, confirenceCount)) {
                chartData.addData(createRowWithRegularChoicesGroupedByConference(conferencesGroup, questionsGroup, confirenceCount));
            }
        }

        return chartData;

    }

    private ChartData createChartDataGroupedByAnswer(ConferencesGroup conferencesGroup, int questionCount) {
        QuestionsGroup questionsGroup = conferencesGroup.getQuestionsGroups().get(questionCount);
        ChartData chartData = new ChartData();

        Options options = createOptions(questionsGroup);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesGroupedByAnswer(conferencesGroup, questionCount);
        chartData.addData(columnsNames);

        for (int answerGroupCount = 0; answerGroupCount < questionsGroup.getAnswersGroups().size(); answerGroupCount++) {  // отходим AnswersGroup
            chartData.addData(createRowWithRegularChoicesGroupedByAnswer(conferencesGroup, questionsGroup, answerGroupCount));
        }

        //инфа о своих ответах 
        if (questionsGroup.isWithCustomAnswer()) {
            chartData.addData(createRowWithCustomChoicesGroupedByAnswer(conferencesGroup, questionsGroup));
        }

        if (questionsGroup.isWithNoAnswer()) {
            chartData.addData(createRowWithNoChoicesGroupedByAnswer(conferencesGroup, questionsGroup));
        }

        return chartData;

    }

    /**
     * Добавляет Value в таблицы
     */
    private List createRowWithRegularChoicesGroupedByAnswer(ConferencesGroup conferencesGroup, QuestionsGroup questionsGroup, int answerGroupCount) {
        AnswersGroup answersGroup = questionsGroup.getAnswersGroups().get(answerGroupCount);

        List row = new LinkedList();
        row.add(answersGroup.getText());

        for (int conferenceCount = 0; conferenceCount < answersGroup.getID().size(); conferenceCount++) {  // обходим конкретные ответы 
            if (isQuestionWasAscedAtConference(questionsGroup, conferenceCount)) {
                if (isAnswerWasAvailableAtConference(answersGroup, conferenceCount)) {
                    String conferencesName = conferencesGroup.getConferences().get(conferenceCount).getName();

                    int conferenceAnswers = surveyService.countAnswers(conferencesGroup.getConferences().get(conferenceCount).getId());
                    int thisAnswers = answerService.countByChoice_id(answersGroup.getID().get(conferenceCount));
                    double percent = countAndFormatPercent(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    row.add(createTooltip(conferencesName, thisAnswers, conferenceAnswers, percent));
                } else {
                    row.add(0); //TODO
                    row.add("");
                }
            }
        }
        return row;
    }

    private List createRowWithRegularChoicesGroupedByConference(ConferencesGroup conferencesGroup, QuestionsGroup questionsGroup, int confirenceCount) {
        List row = new LinkedList();
        row.add(conferencesGroup.getConferences().get(confirenceCount).getName());

        for (int answerCount = 0; answerCount < questionsGroup.getAnswersGroups().size(); answerCount++) {

            Long choice_id = questionsGroup.getAnswersGroups().get(answerCount).getID().get(confirenceCount);

            if (Objects.nonNull(choice_id)) {
                int thisAnswers = answerService.countByChoice_id(choice_id);
                int conferenceAnswers = surveyService.countAnswers(conferencesGroup.getConferences().get(confirenceCount).getId());

                String answer = questionsGroup.getAnswersGroups().get(answerCount).getText();

                double percent = countAndFormatPercent(thisAnswers, conferenceAnswers);
                row.add(percent);
                row.add(createTooltip(answer, thisAnswers, conferenceAnswers, percent));
            } else {
                row.add(null);
                row.add(null);
            }

        }

        if (questionsGroup.isWithCustomAnswer()) {

            Long questionMetaInformationId = questionsGroup.getID().get(confirenceCount);
            if (Objects.nonNull(questionMetaInformationId)) {

                Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(questionMetaInformationId); // при касте NPE

                int conferenceAnswers = surveyService.countAnswers(conferencesGroup.getConferences().get(confirenceCount).getId());
                int thisAnswers = answerService.countByOther_id(other_id);
                double percent = countAndFormatPercent(thisAnswers, conferenceAnswers);
                row.add(percent);
                row.add(createTooltip(CUSTOM_CHOICE, thisAnswers, conferenceAnswers, percent));
            } else {
                row.add(null);
                row.add(null);
            }
        }

        if (questionsGroup.isWithNoAnswer()) {

            Long id = questionsGroup.getID().get(confirenceCount);
            if (Objects.nonNull(id)) {
                int conferenceAnswers = surveyService.countAnswers(conferencesGroup.getConferences().get(confirenceCount).getId());

                int thisAnswers = questionService.countById(id);
                thisAnswers = conferenceAnswers - thisAnswers;

                double percent = countAndFormatPercent(thisAnswers, conferenceAnswers);
                row.add(percent);
                row.add(createTooltip(NO_CHOICE, thisAnswers, conferenceAnswers, percent));
            }//TODO
            else {
                row.add(0);
                row.add("");
            }
        }

        return row;
    }

    private List createRowWithCustomChoicesGroupedByAnswer(ConferencesGroup conferencesGroup, QuestionsGroup questionsGroup) {

        List row = new LinkedList();
        row.add(CUSTOM_CHOICE);

        for (int k = 0; k < questionsGroup.getID().size(); k++) {  // обходим конкретные ответы 
            if (Objects.nonNull(questionsGroup.getID().get(k))) {
                //TODO
                try {
                    long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(questionsGroup.getID().get(k)); // при касте NPE
                    String conferencesName = conferencesGroup.getConferences().get(k).getName();
                    int conferenceAnswers = surveyService.countAnswers(conferencesGroup.getConferences().get(k).getId());
                    int thisAnswers = answerService.countByOther_id(other_id);
                    double percent = countAndFormatPercent(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    row.add(createTooltip(conferencesName, thisAnswers, conferenceAnswers, percent));
                } catch (NullPointerException e) {
                    row.add(null);
                    row.add(null);
                }

            }
            //else {
//                row.add(null);
//                row.add(null);
//            }

        }
        return row;
    }

    private List createRowWithNoChoicesGroupedByAnswer(ConferencesGroup conferencesGroup, QuestionsGroup questionsGroup) {

        List row = new LinkedList();
        row.add(NO_CHOICE);

        for (int questionCount = 0; questionCount < questionsGroup.getID().size(); questionCount++) {  // обходим конкретные ответы 
            if (Objects.nonNull(questionsGroup.getID().get(questionCount))) {
                //TODO
                try {
                    String conferencesName = conferencesGroup.getConferences().get(questionCount).getName();
                    long id = questionsGroup.getID().get(questionCount);

                    int conferenceAnswers = surveyService.countAnswers(conferencesGroup.getConferences().get(questionCount).getId());

                    int thisAnswers = questionService.countById(id);

                    thisAnswers = conferenceAnswers - thisAnswers;

                    double percent = countAndFormatPercent(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    row.add(createTooltip(conferencesName, thisAnswers, conferenceAnswers, percent));

                } catch (NullPointerException e) {
                    row.add(null);
                    row.add(null);
                }
            } else {
//                row.add(null);
//                row.add(null);
            }

        }
        return row;
    }

    private Options createOptions(QuestionsGroup questionsGroup) {
        int answers = questionsGroup.getAnswersGroups().size();
        if (questionsGroup.isWithCustomAnswer()) {
            answers++;
        }
        if (questionsGroup.isWithNoAnswer()) {
            answers++;
        }
        int questions = (int) questionsGroup.getID().stream().filter(Objects::nonNull).count();
        int height = answers * questions * 50;
        Options options = new Options(height,
                "horizontal",
                questionsGroup.getName()); //TODO подумать про высоту
        return options;
    }

    /**
     * Единые названия для всех таблиц
     */
    private List createColumnsNamesGroupedByAnswer(ConferencesGroup conferencesGroup, int questionCount) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""

        for (int confirenceCount = 0; confirenceCount < conferencesGroup.getConferences().size(); confirenceCount++) {
            if (isQuestionWasAscedAtConference(conferencesGroup.getQuestionsGroups().get(questionCount), confirenceCount)) {
//      if (Objects.nonNull(conferencesGroup.getQuestionsGroups().get(questionCount).getID().get(confirenceCount))) {
                columns.add(conferencesGroup.getConferences().get(confirenceCount).getName());
                columns.add(Role.getTooltipRole());
            }
        }

        return columns;
    }

    private List createColumnsNamesGroupedByConfirence(QuestionsGroup questionsGroup) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""
        questionsGroup.getAnswersGroups().forEach((t) -> {
            columns.add(t.getText());
            columns.add(Role.getTooltipRole());
        });

        if (questionsGroup.isWithCustomAnswer()) {
            columns.add(CUSTOM_CHOICE);
            columns.add(Role.getTooltipRole());
        }

        if (questionsGroup.isWithNoAnswer()) {
            columns.add(NO_CHOICE);
            columns.add(Role.getTooltipRole());
        }

        return columns;
    }

    private double countAndFormatPercent(int thisAnswers, int totalAnswers) {
        if (totalAnswers != 0) {
            double percent = (((double) thisAnswers / (double) totalAnswers) * 100.00);
            DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US)); //локаль для правильного разделитеся дроби
            return Double.parseDouble(df.format(percent));
        } else {
            return 0;
        }
    }

    private String createTooltip(String text, int thisAnswers, int totalAnswers, double percent) {
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(": ");
        sb.append(thisAnswers);
        sb.append(" из ");
        sb.append(totalAnswers);
        sb.append(" (");
        sb.append(percent);
        sb.append("%)");
        return sb.toString();
    }

    private boolean isQuestionWasAscedAtConference(QuestionsGroup questionsGroup, int confirenceCount) {
        return Objects.nonNull(questionsGroup.getID().get(confirenceCount));
    }

    private boolean isAnswerWasAvailableAtConference(AnswersGroup answersGroup, int conferenceCount) {
        return Objects.nonNull(answersGroup.getID().get(conferenceCount));
    }
}
