package org.jugru.monkeyStatistics.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jugru.monkeyService.model.Choice;
import org.jugru.monkeyService.model.ChoiceOrRow;
import org.jugru.monkeyService.model.Row;
import org.jugru.monkeyService.model.chart.ChartOptions;
import org.jugru.monkeyService.model.chart.ChartsPreset;
import org.jugru.monkeyService.model.chart.CrossGroupingChart;
import org.jugru.monkeyService.model.chart.GroupedByChoiceChart;
import org.jugru.monkeyService.model.chart.SingleQuestionChart;
import org.jugru.monkeyService.model.chart.UngroupedCharts;
import org.jugru.monkeyService.model.view.ChartData;
import org.jugru.monkeyService.model.view.Options;
import org.jugru.monkeyService.model.view.ChoiceGroup;
import org.jugru.monkeyStatistics.service.AnswerService;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.jugru.monkeyStatistics.service.QuestionService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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

        int conferenceAnswers = surveyService.countResponsesBySurveyId(singleChart.getSurveyId());

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

            int thisAnswers = questionService.countByQuestionMetaInformationId(questionMetaInfId);
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
        if (сrossGroupingChart.isHideLastChoiceInSecond()) {
            columnsNames.remove(columnsNames.size() - 1); // TODO
            if (chartOptions.isWithCustomChoice()) {
                columnsNames.remove(columnsNames.size() - 1);
            }
            if (chartOptions.isWithNoChoice()) {
                columnsNames.remove(columnsNames.size() - 1);
            }
        }
        chartData.addData(columnsNames);

        Long firstQuestionMetaInfId = сrossGroupingChart.getFirstQuestionMetaInfId();
        List<? extends ChoiceOrRow> firstChoices;
        if (!сrossGroupingChart.isUseRow_idInstedOfChoice_idForFirstQuestion()) {
            firstChoices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(firstQuestionMetaInfId);
        } else {
            firstChoices = questionMetaInformationService.getRowsByQuestionMetaInformationId(firstQuestionMetaInfId);
        }

        Long secondQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInfId();
        List<? extends ChoiceOrRow> secondChoices;
        if (!сrossGroupingChart.isUseRow_idInstedOfChoice_idForSecondQuestion()) {
            secondChoices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(secondQuestionMetaInfId);
        } else {
            secondChoices = questionMetaInformationService.getRowsByQuestionMetaInformationId(secondQuestionMetaInfId);
        }

        int conferenceAnswers = surveyService.countResponsesBySurveyId(сrossGroupingChart.getSurveyID());

        for (int firstChoicesCount = 0; firstChoicesCount < (firstChoices.size() - (сrossGroupingChart.isHideLastChoiceInFirst() ? 1 : 0)); firstChoicesCount++) { // -1!!
            List row = new LinkedList();
            row.add(firstChoices.get(firstChoicesCount).getText());

            Long firstChoiceID = firstChoices.get(firstChoicesCount).getId();
            int firstChoiceCount;
            if (!сrossGroupingChart.isUseRow_idInstedOfChoice_idForSecondQuestion()) {
                firstChoiceCount = answerService.countByChoice_id(firstChoiceID); //люди на конкретном докладчике
            } else {
                firstChoiceCount = answerService.countByRow_id(firstChoiceID);
            }
            for (int secondChoicesCount = 0; secondChoicesCount < (secondChoices.size() - (сrossGroupingChart.isHideLastChoiceInSecond() ? 1 : 0)); secondChoicesCount++) { // -1!!
                ChoiceOrRow choice = secondChoices.get(secondChoicesCount);
                Long secondChoicesID = secondChoices.get(secondChoicesCount).getId();
                int pairCount = answerService.countByTwoChoice_id(firstChoiceID, secondChoicesID); //TODO
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
        Long secondQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInfId();

        List<? extends ChoiceOrRow> choices;
        if (!сrossGroupingChart.isUseRow_idInstedOfChoice_idForSecondQuestion()) {
            choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(secondQuestionMetaInfId);
        } else {
            choices = questionMetaInformationService.getRowsByQuestionMetaInformationId(secondQuestionMetaInfId);
        }

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
                    int conferenceAnswers = surveyService.countResponsesBySurveyId(groupedByChoiceChart.getConferenceQuestionPairs().get(conferenceCount).getSurveyId());
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
                    int conferenceAnswers = surveyService.countResponsesBySurveyId(groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getSurveyId());
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
                int conferenceAnswers = surveyService.countResponsesBySurveyId(groupedByChoiceChart.getConferenceQuestionPairs().get(questionsCount).getSurveyId());
                int thisAnswers = questionService.countByQuestionMetaInformationId(questionID);
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
        int height = (firstChoicesCount) * (secondChoicesCount) * 45;  //TODO добавить обработку отказа от последних ответов

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

    private String createTooltipOrAnnotation(String text, int thisAnswers, int speakerAnswers, int totalAnswers, double percent) {
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(": ");
        sb.append(thisAnswers);
        sb.append(" из ");
        sb.append(totalAnswers);

        sb.append("/");
        sb.append(speakerAnswers);

        sb.append(" (");
        sb.append(percent);
        sb.append("%)");
        return sb.toString();
    }

    private boolean choiceWasAvailableAtConference(ChoiceGroup choiceGroup, int conferenceCount) {
        return Objects.nonNull(choiceGroup.getID().get(conferenceCount));
    }

    public static String removeTags(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        Matcher m = REMOVE_TAGS.matcher(string);
        return m.replaceAll("");
    }

  

  


}
