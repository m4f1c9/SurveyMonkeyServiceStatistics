package org.jugru.monkeyStatistics.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Objects.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.html.HTML;
import org.jugru.monkeyService.model.Choice;
import org.jugru.monkeyService.model.Row;
import org.jugru.monkeyService.model.chart.ChartOptions;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyService.model.chart.CrossGroupingChart;
import org.jugru.monkeyService.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyService.model.chart.SingleQuestionChart;
import org.jugru.monkeyService.model.chart.UngroupedCharts;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyService.model.view.ConferenceQuestionPair;
import org.jugru.monkeyService.model.view.ConferenceGroup;
import org.jugru.monkeyService.model.view.Options;
import org.jugru.monkeyService.model.view.ChoiceGroup;
import org.jugru.monkeyService.model.view.Keynote;
import org.jugru.monkeyService.model.view.QuestionGroup;
import org.jugru.monkeyService.model.view.SingleConferenceStat;
import org.jugru.monkeyService.model.view.SpeakersRatingPair;
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
    private static final Pattern REMOVE_TAGS = Pattern.compile("<.+?>");

    public List<ChartData> createChartDataFromChartsPreset(ChartsPreset chartsPreset) {
        List<ChartData> list = new ArrayList<>();
        chartsPreset.getCharts().forEach((t) -> {
            list.addAll(t.createChartData(this));
        });
        return list;
    }

    public List<ChartData> createChartDataFromUngroupedCharts(UngroupedCharts ungroupedCharts) {
        List<ChartData> chartData = new ArrayList<>();

        List<SingleQuestionChart> sharts = ungroupedCharts.getCharts();
        for (int i = 0; i < sharts.size(); i++) {
            chartData.add(createChartDataFromSingleChart(sharts.get(i),
                    ungroupedCharts.getChartOptions(),
                    ((i == 0) & ungroupedCharts.getChartOptions().isShowTitle()) ? ungroupedCharts.getChartName() : ""));  //добавляет заголовок первому графику в группе
        }

        return chartData;
    }

    private ChartData createChartDataFromSingleChart(SingleQuestionChart singleChart, ChartOptions chartOptions, String title) {
        ChartData chartData = new ChartData();

        Options options = createDefaultOptions(singleChart, chartOptions, title);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesFromSingleChart(singleChart, chartOptions);
        chartData.addData(columnsNames);

        Long questionMetaInfId = singleChart.getQuestionMetaInfId();
        List row = new LinkedList();
        row.add(singleChart.getName());

        int conferenceAnswers = surveyService.countAnswers(singleChart.getSurveyId());

        if (!singleChart.isUseRow_idInstedOfChoice_id()) {
            List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(questionMetaInfId);
            for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {

                Choice choice = choices.get(choiceCount);
                int thisAnswers = answerService.countByChoice_id(choice.getId());
                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                row.add(percent);

                addMetaDataToRow(thisAnswers, conferenceAnswers, percent, chartOptions, choice.getText(), row);

            }
        } else {
            List<Row> choices = questionMetaInformationService.getRowsByQuestionMetaInformationId(questionMetaInfId);
            for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {

                Row choice = choices.get(choiceCount);

                int thisAnswers = answerService.countByRow_id(choice.getId());

                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                row.add(percent);

                addMetaDataToRow(thisAnswers, conferenceAnswers, percent, chartOptions, choice.getText(), row);

            }

        }

        if (chartOptions.isWithCustomChoice()) {
            Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(questionMetaInfId);
            int thisAnswers = answerService.countByOther_id(other_id);
            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);

            addMetaDataToRow(thisAnswers, conferenceAnswers, percent, chartOptions, CUSTOM_CHOICE, row);

        }
        if (chartOptions.isWithNoChoice()) {

            int thisAnswers = questionService.countById(questionMetaInfId);
            thisAnswers = conferenceAnswers - thisAnswers;

            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);

            addMetaDataToRow(thisAnswers, conferenceAnswers, percent, chartOptions, NO_CHOICE, row);

        }
        chartData.addData(row);
        return chartData;
    }

    private void addMetaDataToRow(int thisAnswers, int conferenceAnswers, double percent, ChartOptions chartOptions, String text, List row) { //TODO имя
        if ((thisAnswers > 0) && (chartOptions.getAnnotation() == ChartOptions.Annotation.SHORT)) {
            row.add(createTooltipOrAnnotation(thisAnswers, conferenceAnswers, percent));
        } else if ((thisAnswers > 0) && (chartOptions.getAnnotation() == ChartOptions.Annotation.FULL)) {
            row.add(createTooltipOrAnnotation(text, thisAnswers, conferenceAnswers, percent));
        } else if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
            row.add(null);
        }

        if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {  //TODO типы тултипов
            row.add(createTooltipOrAnnotation(text, thisAnswers, conferenceAnswers, percent));
        }
    }
    

    public ChartData createChartDataFromCrossGroupingChart(CrossGroupingChart сrossGroupingChart) {
        ChartOptions chartOptions = сrossGroupingChart.getChartOptions();
        ChartData chartData = new ChartData();
        Options options = createDefaultOptions(сrossGroupingChart);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesFromCrossGroupingChart(сrossGroupingChart);
        columnsNames.remove(columnsNames.size() - 1); // TODO
        if (chartOptions.isWithCustomChoice()) {
            columnsNames.remove(columnsNames.size() - 1);
        }
        if (chartOptions.isWithNoChoice()) {
            columnsNames.remove(columnsNames.size() - 1);
        }
        chartData.addData(columnsNames);

        Long firstQuestionMetaInfId = сrossGroupingChart.getFirstQuestionMetaInfId();
        List<Choice> firstChoices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(firstQuestionMetaInfId);

        Long secondQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInfId();
        List<Choice> secondChoices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(secondQuestionMetaInfId);

        int conferenceAnswers = surveyService.countAnswers(сrossGroupingChart.getSurveyID());

        for (int firstChoicesCount = 0; firstChoicesCount < firstChoices.size() - 1; firstChoicesCount++) { // -1!!
            List row = new LinkedList();
            row.add(firstChoices.get(firstChoicesCount).getText());

            Long firstChoiceID = firstChoices.get(firstChoicesCount).getId();
            int firstChoiceCount = answerService.countByChoice_id(firstChoiceID); //люди на конкретном докладчике

            for (int secondChoicesCount = 0; secondChoicesCount < secondChoices.size() - 1; secondChoicesCount++) { // -1!!
                Choice choice = secondChoices.get(secondChoicesCount);
                Long secondChoicesID = secondChoices.get(secondChoicesCount).getId();
                int pairCount = answerService.countByTwoChoice_id(firstChoiceID, secondChoicesID);
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
                row.add(percent);

                //    addMetaDataToRow(pairCount, firstChoiceCount, percent, chartOptions, choice.getText(), row); // TODO выбрать какие проценты показывать
                addMetaDataToRow(pairCount, firstChoiceCount, countPercentAndFormat(pairCount, firstChoiceCount), chartOptions, choice.getText(), row);

            }
            chartData.addData(row);
        }

        return chartData;
    }

    private List createColumnsNamesFromCrossGroupingChart(CrossGroupingChart сrossGroupingChart) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""
        Long ыусщтвQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInfId();
        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(ыусщтвQuestionMetaInfId);
        ChartOptions chartOptions = сrossGroupingChart.getChartOptions();
        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
            columns.add(choices.get(choiceCount).getText());

            if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
                columns.add(Role.getAnnotationTextRole());
            }
            if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {
                columns.add(Role.getTooltipRole());
            }
        }

        return columns;
    }

    public ChartData createChartDataFromGroupedByChoiceChart(GroupedByChoiceChart groupedByChoiceChart) {
        ChartData chartData = new ChartData();

        Options options = createDefaultOptions(groupedByChoiceChart);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesFromGroupedByChoiceChart(groupedByChoiceChart);
        chartData.addData(columnsNames);

        for (int answersCount = 0; answersCount < groupedByChoiceChart.getChoiceGroups().size(); answersCount++) {  // отходим ChoiceGroupList
            ChoiceGroup choiceGroup = groupedByChoiceChart.getChoiceGroups().get(answersCount);
            List row = new LinkedList();
            row.add(choiceGroup.getText());
            for (int conferenceCount = 0; conferenceCount < choiceGroup.getID().size(); conferenceCount++) {  // обходим конкретные ответы 
                if (choiceWasAvailableAtConference(choiceGroup, conferenceCount)) {
                    String conferencesName = groupedByChoiceChart.getConferenceQuestionPairs().get(conferenceCount).getName();
                    int conferenceAnswers = surveyService.countAnswers(groupedByChoiceChart.getConferenceQuestionPairs().get(conferenceCount).getSurveyId());
                    int thisAnswers = answerService.countByChoice_id(choiceGroup.getID().get(conferenceCount));
                    double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), conferencesName, row);
                } else {
                    row.add(0); //TODO
                    if (groupedByChoiceChart.getChartOptions().getTooltip() != ChartOptions.Tooltip.NO) {
                        row.add("");
                    }
                    if (groupedByChoiceChart.getChartOptions().getAnnotation() != ChartOptions.Annotation.NO) {
                        row.add("");
                    }
                }
            }
            chartData.addData(row);
        }

        //инфа о своих ответах 
        if (groupedByChoiceChart.getChartOptions().isWithCustomChoice()) {
            List row = new LinkedList();
            row.add(CUSTOM_CHOICE);
            for (int questionsCount = 0; questionsCount < groupedByChoiceChart.getConferenceQuestionPairs().size(); questionsCount++) {  // обходим конкретные ответы 
                Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getQuestionId());
                if (Objects.nonNull(other_id)) {
                    String conferencesName = groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getName();
                    int conferenceAnswers = surveyService.countAnswers(groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getSurveyId());
                    int thisAnswers = answerService.countByOther_id(other_id);
                    double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), conferencesName, row);
                } else {
                    row.add(0); //TODO
                    if (groupedByChoiceChart.getChartOptions().getTooltip() != ChartOptions.Tooltip.NO) {
                        row.add("");
                    }
                    if (groupedByChoiceChart.getChartOptions().getAnnotation() != ChartOptions.Annotation.NO) {
                        row.add("");
                    }
                }
            }
            chartData.addData(row);
        }

        if (groupedByChoiceChart.getChartOptions().isWithNoChoice()) {
            List row = new LinkedList();
            row.add(NO_CHOICE);

            for (int questionsCount = 0; questionsCount < groupedByChoiceChart.getConferenceQuestionPairs().size(); questionsCount++) {  // обходим конкретные ответы 

                String conferencesName = groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getName();
                long questionID = groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getQuestionId();
                int conferenceAnswers = surveyService.countAnswers(groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getSurveyId());
                int thisAnswers = questionService.countById(questionID);
                thisAnswers = conferenceAnswers - thisAnswers;

                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);

                if (percent > 0.0) {
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), conferencesName, row);
                } else {
                    row.add(0); //TODO
                    if (groupedByChoiceChart.getChartOptions().getTooltip() != ChartOptions.Tooltip.NO) {
                        row.add("");
                    }
                    if (groupedByChoiceChart.getChartOptions().getAnnotation() != ChartOptions.Annotation.NO) {
                        row.add("");
                    }
                }

            }

            chartData.addData(row);
        }

        return chartData;

    }

//    public List<ChartData> singleConferenceSpeakers(SingleConferenceStat singleConferenceStat) {
//        List<ChartData> chartDataList = new LinkedList<>();
//        for (int pairsCount = 0; pairsCount < singleConferenceStat.getPairs().size(); pairsCount++) {
//            SpeakersRatingPair pair = singleConferenceStat.getPairs().get(pairsCount);
//            ChartData chartData = createChartDataFromPair(pair);
//            chartDataList.add(chartData);
//        }
//
//        for (int keynotesCount = 0; keynotesCount < singleConferenceStat.getKeynotes().size(); keynotesCount++) {
//            Keynote keynote = singleConferenceStat.getKeynotes().get(keynotesCount);
//            ChartData chartData = createChartDataFromKeynote(keynote);
//            chartDataList.add(chartData);
//        }
//
//        return chartDataList;
//    }

//    public List<ChartData> standartSingleChoiceChartGroupedByAnswer(ConferenceGroup conferenceGroup) {
//        List<ChartData> chartDataList = new LinkedList<>();
//
//        for (int questionGroupCount = 0; questionGroupCount < conferenceGroup.getQuestionGroups().size(); questionGroupCount++) { // обходим все QuestionGroup каждый будет отдельной таблицей
//            QuestionGroup questionGroup = conferenceGroup.getQuestionGroups().get(questionGroupCount);
//            ChartData chartData = createChartDataGroupedByAnswer(questionGroup);
//            chartDataList.add(chartData);
//        }
//
//        return chartDataList;
//    }
//
//    public List<ChartData> standartSingleChoiceChartGroupedByConfirence(ConferenceGroup conferenceGroup) {
//        List<ChartData> chartDataList = new LinkedList<>();
//
//        for (int questionGroupCount = 0; questionGroupCount < conferenceGroup.getQuestionGroups().size(); questionGroupCount++) { // обходим все QuestionGroup каждый будет отдельной таблицей
//            QuestionGroup questionGroup = conferenceGroup.getQuestionGroups().get(questionGroupCount);
//            ChartData chartData = createChartDataGroupedByConfirence(questionGroup);
//            chartDataList.add(chartData);
//
//        }
//
//        return chartDataList;
//    }

//    private ChartData createChartDataFromPair(SpeakersRatingPair pair) {
//        ChartData chartData = new ChartData();
//        Options options = createOptions(pair);
//        chartData.setOptions(options);
//
//        List columnsNames = createColumnsNamesFromPair(pair);
//        columnsNames.remove(columnsNames.size() - 1); // TODO
//        columnsNames.remove(columnsNames.size() - 1);
//        chartData.addData(columnsNames);
//
//        Long speakersAnswerID = pair.getSpeakersAnswerID();
//        List<Choice> speakers = questionMetaInformationService.getChoicesByQuestionMetaInformationId(speakersAnswerID);
//
//        Long ratingAnswerID = pair.getRatingAnswerID();
//        List<Choice> rating = questionMetaInformationService.getChoicesByQuestionMetaInformationId(ratingAnswerID);
//
//        int conferenceAnswers = surveyService.countAnswers(pair.getSurveyID());
//
//        for (int speakersCount = 0; speakersCount < speakers.size() - 1; speakersCount++) {
//            List row = new LinkedList();
//            row.add(speakers.get(speakersCount).getText());
//
//            Long speakersChoiceID = speakers.get(speakersCount).getId();
//            int speakerChoiceCount = answerService.countByChoice_id(speakersChoiceID); //люди на конкретном докладчике
//
//            for (int ratingCount = 0; ratingCount < rating.size() - 1; ratingCount++) {
//                Long ratingChoiceID = rating.get(ratingCount).getId();
//                int pairCount = answerService.countByTwoChoice_id(speakersChoiceID, ratingChoiceID);
//                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
//
//                row.add(percent); //TODO
//                if (pairCount > 0) {
//                    row.add(createTooltipOrAnnotation(rating.get(ratingCount).getText(), pairCount, conferenceAnswers, speakerChoiceCount, percent));
//                } else {
//                    row.add(null);
//                }
//
//            }
//            chartData.addData(row);
//        }
//
//        return chartData;
//    }
//
//    private ChartData createChartDataFromKeynote(Keynote keynote) {
//        ChartData chartData = new ChartData();
//        Options options = createOptions(keynote);
//        chartData.setOptions(options);
//
//        List columnsNames = createColumnsNamesFromKeynote(keynote);
//        chartData.addData(columnsNames);
//
//        Long keynoteQuestionMetaInfID = keynote.getKeynoteQuestionMetaInfID();
//        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(keynoteQuestionMetaInfID);
//
//        List row = new LinkedList();
//        row.add(keynote.getText());
//
//        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
//
//            Choice choice = choices.get(choiceCount);
//
//            String conferencesName = choice.getText();
//            int conferenceAnswers = surveyService.countAnswers(keynote.getSurveyID());
//            int thisAnswers = answerService.countByChoice_id(choice.getId());
//            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
//            row.add(percent);
//            if (thisAnswers > 0) {
//                row.add(createTooltipOrAnnotation(conferencesName, thisAnswers, conferenceAnswers, percent));
//            } else {
//                row.add(null);
//            }
//
//        }
//
//        chartData.addData(row);
//
//        return chartData;
//
//    }
//
//    private ChartData createChartDataGroupedByConfirence(QuestionGroup questionGroup) {
//
//        ChartData chartData = new ChartData();
//
//        Options options = createOptions(questionGroup);
//        chartData.setOptions(options);
//
//        List columnsNames = createColumnsNamesGroupedByConfirence(questionGroup);
//        chartData.addData(columnsNames);
//
//        for (int confirenceCount = 0; confirenceCount < questionGroup.getConferenceQuestionPairs().size(); confirenceCount++) {
//
//            chartData.addData(createRowWithRegularChoicesGroupedByConference(questionGroup, confirenceCount));
//
//        }
//
//        return chartData;
//
//    }
//
//    private ChartData createChartDataGroupedByAnswer(QuestionGroup questionGroup) {
//        ChartData chartData = new ChartData();
//
//        Options options = createOptions(questionGroup);
//        chartData.setOptions(options);
//
//        List columnsNames = createColumnsNamesGroupedByAnswer(questionGroup);
//        chartData.addData(columnsNames);
//
//        for (int answersCount = 0; answersCount < questionGroup.getChoiceGroups().size(); answersCount++) {  // отходим ChoiceGroupList
//            List row = createRowWithRegularChoicesGroupedByAnswer(questionGroup, answersCount);
//            chartData.addData(row);
//        }
//
//        //инфа о своих ответах 
//        if (questionGroup.isWithCustomAnswer()) {
//            chartData.addData(createRowWithCustomChoicesGroupedByAnswer(questionGroup));
//        }
//
//        if (questionGroup.isWithNoAnswer()) {
//            chartData.addData(createRowWithNoChoicesGroupedByAnswer(questionGroup));
//        }
//
//        return chartData;
//
//    }
//
//    /**
//     * Добавляет Value в таблицы
//     */
    private List createRowWithRegularChoicesGroupedByAnswer(QuestionGroup questionGroup, int answerCount) {
        ChoiceGroup choiceGroup = questionGroup.getChoiceGroups().get(answerCount);

        List row = new LinkedList();
        row.add(choiceGroup.getText());

        for (int conferenceCount = 0; conferenceCount < choiceGroup.getID().size(); conferenceCount++) {  // обходим конкретные ответы 

            if (choiceWasAvailableAtConference(choiceGroup, conferenceCount)) {
                String conferencesName = questionGroup.getConferenceQuestionPairs().get(conferenceCount).getName();
                int conferenceAnswers = surveyService.countAnswers(questionGroup.getConferenceQuestionPairs().get(conferenceCount).getSurveyId());
                int thisAnswers = answerService.countByChoice_id(choiceGroup.getID().get(conferenceCount));
                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                row.add(percent);
                row.add(createTooltipOrAnnotation(conferencesName, thisAnswers, conferenceAnswers, percent));

            } else {
                row.add(0); //TODO
                row.add("");
            }

        }
        return row;
    }

    private List createRowWithRegularChoicesGroupedByConference(QuestionGroup questionGroup, int confirenceCount) {
        List row = new LinkedList();
        row.add(questionGroup.getConferenceQuestionPairs().get(confirenceCount).getName());

        for (int choiceCount = 0; choiceCount < questionGroup.getChoiceGroups().size(); choiceCount++) {
            ChoiceGroup choiceGroup = questionGroup.getChoiceGroups().get(choiceCount);
            if (choiceWasAvailableAtConference(choiceGroup, confirenceCount)) {

                Long choice_id = choiceGroup.getID().get(confirenceCount);
                int thisAnswers = answerService.countByChoice_id(choice_id);
                int conferenceAnswers = surveyService.countAnswers(questionGroup.getConferenceQuestionPairs().get(confirenceCount).getSurveyId());

                String answer = questionGroup.getChoiceGroups().get(choiceCount).getText();

                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                row.add(percent);
                row.add(createTooltipOrAnnotation(answer, thisAnswers, conferenceAnswers, percent));
            } else {
                row.add(null);
                row.add(null);
            }

        }

        if (questionGroup.isWithCustomAnswer()) {

            Long questionMetaInformationId = questionGroup.getConferenceQuestionPairs().get(confirenceCount).getQuestionId();
            if (Objects.nonNull(questionMetaInformationId)) {

                Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(questionMetaInformationId); // при касте NPE

                int conferenceAnswers = surveyService.countAnswers(questionGroup.getConferenceQuestionPairs().get(confirenceCount).getSurveyId());
                int thisAnswers = answerService.countByOther_id(other_id);
                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                row.add(percent);
                row.add(createTooltipOrAnnotation(CUSTOM_CHOICE, thisAnswers, conferenceAnswers, percent));
            } else {
                row.add(null);
                row.add(null);
            }
        }

        if (questionGroup.isWithNoAnswer()) {

            Long questionID = questionGroup.getConferenceQuestionPairs().get(confirenceCount).getQuestionId();
            //   if (Objects.nonNull(questionID)) {
            int conferenceAnswers = surveyService.countAnswers(questionGroup.getConferenceQuestionPairs().get(confirenceCount).getSurveyId());

            int thisAnswers = questionService.countById(questionID);
            thisAnswers = conferenceAnswers - thisAnswers;

            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);
            row.add(createTooltipOrAnnotation(NO_CHOICE, thisAnswers, conferenceAnswers, percent));
//            }
//            else {
//                row.add(0);
//                row.add("");
//            }
        }

        return row;
    }

    private List createRowWithCustomChoicesGroupedByAnswer(QuestionGroup questionsGroup) {

        List row = new LinkedList();
        row.add(CUSTOM_CHOICE);

        for (int questionsCount = 0; questionsCount < questionsGroup.getConferenceQuestionPairs().size(); questionsCount++) {  // обходим конкретные ответы 

            Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(questionsGroup.getConferenceQuestionPairs().get(questionsCount).getQuestionId());
            if (Objects.nonNull(other_id)) {
                String conferencesName = questionsGroup.getConferenceQuestionPairs().get(questionsCount).getName();
                int conferenceAnswers = surveyService.countAnswers(questionsGroup.getConferenceQuestionPairs().get(questionsCount).getSurveyId());
                int thisAnswers = answerService.countByOther_id(other_id);
                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                row.add(percent);
                row.add(createTooltipOrAnnotation(conferencesName, thisAnswers, conferenceAnswers, percent));
            } else {
                row.add(0);
                row.add("");
            }

        }
        return row;
    }
//
//    private List createRowWithNoChoicesGroupedByAnswer(QuestionGroup questionsGroup) {
//
//        List row = new LinkedList();
//        row.add(NO_CHOICE);
//
//        for (int questionsCount = 0; questionsCount < questionsGroup.getConferenceQuestionPairs().size(); questionsCount++) {  // обходим конкретные ответы 
//
//            String conferencesName = questionsGroup.getConferenceQuestionPairs().get(questionsCount).getName();
//            long questionID = questionsGroup.getConferenceQuestionPairs().get(questionsCount).getQuestionId();
//
//            int conferenceAnswers = surveyService.countAnswers(questionsGroup.getConferenceQuestionPairs().get(questionsCount).getSurveyId());
//
//            int thisAnswers = questionService.countById(questionID);
//
//            thisAnswers = conferenceAnswers - thisAnswers;
//
//            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
//            row.add(percent);
//            row.add(createTooltipOrAnnotation(conferencesName, thisAnswers, conferenceAnswers, percent));
//
//        }
//        return row;
//    }
//
//    private Options createOptions(QuestionGroup questionGroup) {
//        int answers = questionGroup.getChoiceGroups().size();
//        if (questionGroup.isWithCustomAnswer()) {
//            answers++;
//        }
//        if (questionGroup.isWithNoAnswer()) {
//            answers++;
//        }
//        int questions = (int) questionGroup.getConferenceQuestionPairs().size();
//        int height = answers * questions * 40 + 200;
//        Options options = new Options(height,
//                "horizontal",
//                questionGroup.getName()); //TODO подумать про высоту
//        return options;
//    }
//
//    private Options createOptions(Keynote keynote) {
//        int choicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(keynote.getKeynoteQuestionMetaInfID()).size();
//        int height = choicesCount * 50;  //TODO убрать константу
//        Options options = new Options(height,
//                "horizontal",
//                "Кейноуты", true); // TODO
//        return options;
//    }
//
//    private Options createDefaultOptions(SingleQuestionChart singleChart, ChartOptions chartOptions) {
//        return createDefaultOptions(singleChart, chartOptions, "");
//    }

    private Options createDefaultOptions(SingleQuestionChart singleChart, ChartOptions chartOptions, String title) {
        int choicesCount;
        if (!singleChart.isUseRow_idInstedOfChoice_id()) {
            choicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(singleChart.getQuestionMetaInfId()).size();
        } else {
            choicesCount = questionMetaInformationService.getRowsByQuestionMetaInformationId(singleChart.getQuestionMetaInfId()).size();
        }
        int height = choicesCount * 50;  //TODO убрать константу
        if (chartOptions.isWithCustomChoice()) {
            height += 50;
        }
        if (chartOptions.isWithNoChoice()) {
            height += 50;
        }

        Options options = new Options(height,
                "horizontal",
                title, chartOptions.isUseGradient()); // TODO
        return options;
    }

    private Options createDefaultOptions(CrossGroupingChart сrossGroupingChart) {
        int firstChoicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(сrossGroupingChart.getFirstQuestionMetaInfId()).size();
        int secondChoicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(сrossGroupingChart.getSecondQuestionMetaInfId()).size();
        int height = (firstChoicesCount - 1) * (secondChoicesCount - 1) * 50;  //TODO убрать константу

        String title = сrossGroupingChart.getChartName();

        Options options = new Options(height,
                "horizontal",
                title, true); // TODO
        return options;
    }

    private Options createDefaultOptions(GroupedByChoiceChart groupedByChoiceChart) {
        ChartOptions chartOptions = groupedByChoiceChart.getChartOptions();
        int answers = groupedByChoiceChart.getChoiceGroups().size();
        if (chartOptions.isWithCustomChoice()) {
            answers++;
        }
        if (chartOptions.isWithNoChoice()) {
            answers++;
        }
        int questions = (int) groupedByChoiceChart.getConferenceQuestionPairs().size();
        int height = answers * questions * 45 + 50; // 200 на заголовок
        Options options = new Options(height,
                "horizontal",
                groupedByChoiceChart.getName()); //TODO подумать про высоту
        return options;
    }
//
//    private Options createOptions(SpeakersRatingPair pair) {
//
//        int height = 1000;  //TODO убрать константу
//        Options options = new Options(height,
//                "horizontal",
//                pair.getText(), true);
//        return options;
//    }
//
//    private List createColumnsNamesFromPair(SpeakersRatingPair pair) {
//        List columns = new LinkedList<>();
//        columns.add("");    //не нужен, но не может быть null, поэтому ""
//        Long RatingAnswerID = pair.getRatingAnswerID();
//        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(RatingAnswerID);
//
//        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
//            columns.add(choices.get(choiceCount).getText());
//            columns.add(Role.getAnnotationTextRole());
//        }
//
//        return columns;
//    }
//
//    private List createColumnsNamesFromKeynote(Keynote keynote) {
//        List columns = new LinkedList<>();
//        columns.add("");    //не нужен, но не может быть null, поэтому ""
//
//        Long keynoteQuestionMetaInfID = keynote.getKeynoteQuestionMetaInfID();
//        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(keynoteQuestionMetaInfID);
//
//        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
//            columns.add(choices.get(choiceCount).getText());
//            columns.add(Role.getAnnotationTextRole());
//        }
//
//        return columns;
//    }

    private List createColumnsNamesFromSingleChart(SingleQuestionChart singleChart, ChartOptions chartOptions) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""

        Long questionMetaInformationId = singleChart.getQuestionMetaInfId();

        if (!singleChart.isUseRow_idInstedOfChoice_id()) {
            List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(questionMetaInformationId);

            for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
                columns.add(removeTags(choices.get(choiceCount).getText()));
                addMetaDataToColumnNames(chartOptions, columns);
            }
        } else {
            List<Row> choices = questionMetaInformationService.getRowsByQuestionMetaInformationId(questionMetaInformationId);

            for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
                columns.add(removeTags(choices.get(choiceCount).getText()));
                addMetaDataToColumnNames(chartOptions, columns);
            }

        }

        if (chartOptions.isWithCustomChoice()) {
            columns.add(CUSTOM_CHOICE);
            addMetaDataToColumnNames(chartOptions, columns);
        }

        if (chartOptions.isWithNoChoice()) {
            columns.add(NO_CHOICE);
            addMetaDataToColumnNames(chartOptions, columns);
        }
        return columns;
    }

    private void addMetaDataToColumnNames(ChartOptions chartOptions, List columns) { //TODO имя
        if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
            columns.add(Role.getAnnotationTextRole());
        }
        if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {
            columns.add(Role.getTooltipRole());
        }
    }
//
//    private List createColumnsNamesGroupedByAnswer(QuestionGroup questionGroup) {
//        List columns = new LinkedList<>();
//        columns.add("");    //не нужен, но не может быть null, поэтому ""
//
//        for (int confirenceCount = 0; confirenceCount < questionGroup.getConferenceQuestionPairs().size(); confirenceCount++) {
//
//            columns.add(questionGroup.getConferenceQuestionPairs().get(confirenceCount).getName());
//            columns.add(Role.getTooltipRole());
//
//        }
//
//        return columns;
//    }

    private List createColumnsNamesFromGroupedByChoiceChart(GroupedByChoiceChart groupedByChoiceChart) {
        List columns = new LinkedList<>();
        ChartOptions chartOptions = groupedByChoiceChart.getChartOptions();
        columns.add("");    //не нужен, но не может быть null, поэтому ""

        for (int confirenceCount = 0; confirenceCount < groupedByChoiceChart.getConferenceQuestionPairs().size(); confirenceCount++) {

            columns.add(groupedByChoiceChart.getConferenceQuestionPairs().get(confirenceCount).getName());
            if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
                columns.add(Role.getAnnotationTextRole());
            }
            if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {
                columns.add(Role.getTooltipRole());
            }

        }

        return columns;
    }
//
//    private List createColumnsNamesGroupedByConfirence(QuestionGroup questionsGroup) {
//        List columns = new LinkedList<>();
//        columns.add("");    //не нужен, но не может быть null, поэтому ""
//        questionsGroup.getChoiceGroups().forEach((t) -> {
//            columns.add(t.getText());
//            columns.add(Role.getTooltipRole());
//        });
//
//        if (questionsGroup.isWithCustomAnswer()) {
//            columns.add(CUSTOM_CHOICE);
//            columns.add(Role.getTooltipRole());
//        }
//
//        if (questionsGroup.isWithNoAnswer()) {
//            columns.add(NO_CHOICE);
//            columns.add(Role.getTooltipRole());
//        }
//
//        return columns;
//    }

    private double countPercentAndFormat(int thisAnswers, int totalAnswers) {
        if (totalAnswers != 0) {
            double percent = (((double) thisAnswers / (double) totalAnswers) * 100.00);
            DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US)); //локаль для правильного разделитеся дроби
            return Double.parseDouble(df.format(percent));
        } else {
            return 0;
        }
    }

    private String createTooltipOrAnnotation(String text, int thisAnswers, int totalAnswers, double percent) {
        StringBuilder sb = new StringBuilder();
        //    sb.append(text);
        sb.append(removeTags(text));

        sb.append(": ");
        sb.append(thisAnswers);
        sb.append(" из ");
        sb.append(totalAnswers);
        sb.append(" (");
        sb.append(percent);
        sb.append("%)");
        return sb.toString();
    }

    private String createTooltipOrAnnotation(int thisAnswers, int totalAnswers, double percent) {
        StringBuilder sb = new StringBuilder();
        sb.append(thisAnswers);
        sb.append(" из ");
        sb.append(totalAnswers);
        sb.append(" (");
        sb.append(percent);
        sb.append("%)");
        return sb.toString();
    }
//
//    private String createTooltipOrAnnotation(String text, int thisAnswers, int speakerAnswers, int totalAnswers, double percent) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(text);
//        sb.append(": ");
//        sb.append(thisAnswers);
//        sb.append(" из ");
//        sb.append(totalAnswers);
//
//        sb.append("/");
//        sb.append(speakerAnswers);
//
//        sb.append(" (");
//        sb.append(percent);
//        sb.append("%)");
//        return sb.toString();
//    }

    private boolean choiceWasAvailableAtConference(ChoiceGroup choiceGroup, int conferenceCount) {
        return Objects.nonNull(choiceGroup.getID().get(conferenceCount));
    }

    private String removeTags(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        Matcher m = REMOVE_TAGS.matcher(string);
        return m.replaceAll("");
    }

}
