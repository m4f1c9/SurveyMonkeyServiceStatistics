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
import org.jugru.monkeyService.model.chart.ChartData;
import org.jugru.monkeyService.model.chart.Options;
import org.jugru.monkeyService.model.chart.ChoiceGroup;
import org.jugru.monkeyService.model.chart.QuestionDetails;
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
                    (i == 0) ? ungroupedCharts.getChartName() : ""));  //добавляет заголовок первому графику в группе
        }

        return chartData;
    }

    private ChartData createChartDataFromSingleChart(SingleQuestionChart singleChart, ChartOptions chartOptions, String title) {
        ChartData chartData = new ChartData();

        Options options = createDefaultOptions(singleChart, chartOptions, title);
        chartData.setOptions(options);

        List columnsNames = createColumnWithNamesFromSingleChart(singleChart, chartOptions);
        chartData.addData(columnsNames);

        Long questionMetaInfId = singleChart.getQuestionMetaInfId();
        List row = new LinkedList();
        row.add(singleChart.getName());

        Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(questionMetaInfId);
        int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);

        List<? extends ChoiceOrRow> choices
                = questionMetaInformationService.getChoiceOrRowsByQuestionMetaInformationId(questionMetaInfId,
                        singleChart.getQuestionOptions().isUseRow_idInstedOfChoice_id());

        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
            ChoiceOrRow choice = choices.get(choiceCount);
            int thisAnswers = answerService.countById(choice.getId(), singleChart.getQuestionOptions().isUseRow_idInstedOfChoice_id());
            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);
            addMetaDataToRow(thisAnswers, conferenceAnswers, percent, chartOptions, choice.getText(), row);
        }
        if (singleChart.getQuestionOptions().isWithCustomChoice()) {
            Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(questionMetaInfId);
            int thisAnswers = answerService.countByOther_id(other_id);
            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);
            addMetaDataToRow(thisAnswers, conferenceAnswers, percent, chartOptions, CUSTOM_CHOICE, row);
        }
        if (singleChart.getQuestionOptions().isWithNoChoice()) {
            int thisAnswers = questionService.countByQuestionMetaInformationId(questionMetaInfId);
            thisAnswers = conferenceAnswers - thisAnswers;
            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);
            addMetaDataToRow(thisAnswers, conferenceAnswers, percent, chartOptions, NO_CHOICE, row);
        }
        chartData.addData(row);
        return chartData;
    }

    public ChartData createChartDataFromCrossGroupingChart(CrossGroupingChart сrossGroupingChart) {
        ChartOptions chartOptions = сrossGroupingChart.getChartOptions();
        ChartData chartData = new ChartData();
        Options options = createDefaultOptions(сrossGroupingChart);
        chartData.setOptions(options);

        List columnWithNames = createColumnWithNamesFromCrossGroupingChart(сrossGroupingChart);

        chartData.addData(columnWithNames);

        Long firstQuestionMetaInfId = сrossGroupingChart.getFirstQuestionMetaInformationId();
        Long secondQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInformationId();

        List<? extends ChoiceOrRow> firstChoices = questionMetaInformationService.
                getChoiceOrRowsByQuestionMetaInformationId(firstQuestionMetaInfId,
                        сrossGroupingChart.getFirstQuestionOptions().isUseRow_idInstedOfChoice_id());

        List<? extends ChoiceOrRow> secondChoices = questionMetaInformationService.
                getChoiceOrRowsByQuestionMetaInformationId(secondQuestionMetaInfId,
                        сrossGroupingChart.getSecondQuestionOptions().isUseRow_idInstedOfChoice_id());

        Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(firstQuestionMetaInfId);
        int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);

        for (int firstChoicesCount = 0; firstChoicesCount < (firstChoices.size() - (сrossGroupingChart.isHideLastChoiceInFirstQuestion() ? 1 : 0)); firstChoicesCount++) { // -1!!
            List row = new LinkedList();
            row.add(firstChoices.get(firstChoicesCount).getText());

            Long firstChoiceID = firstChoices.get(firstChoicesCount).getId();
            int firstChoiceCount = answerService.countById(firstChoiceID, сrossGroupingChart.getSecondQuestionOptions().isUseRow_idInstedOfChoice_id());

            for (int secondChoicesCount = 0; secondChoicesCount < (secondChoices.size() - (сrossGroupingChart.isHideLastChoiceInSecondQuestion() ? 1 : 0)); secondChoicesCount++) { // -1!!

                ChoiceOrRow choice = secondChoices.get(secondChoicesCount);
                Long secondChoiceID = secondChoices.get(secondChoicesCount).getId();
                int pairCount = answerService.countByTwoId(firstChoiceID,
                        secondChoiceID,
                        сrossGroupingChart.getFirstQuestionOptions().isUseRow_idInstedOfChoice_id(),
                        сrossGroupingChart.getSecondQuestionOptions().isUseRow_idInstedOfChoice_id());
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
                row.add(percent);
                addMetaDataToRow(pairCount, firstChoiceCount, countPercentAndFormat(pairCount, firstChoiceCount), chartOptions, choice.getText(), row);
            }

            if (сrossGroupingChart.getSecondQuestionOptions().isWithCustomChoice()) {
                Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(secondQuestionMetaInfId);
                int pairCount = answerService.countByIdAndOther_id(firstChoiceID,
                        other_id,
                        сrossGroupingChart.getFirstQuestionOptions().isUseRow_idInstedOfChoice_id());
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
                row.add(percent);
                addMetaDataToRow(pairCount, firstChoiceCount, countPercentAndFormat(pairCount, firstChoiceCount), chartOptions, CUSTOM_CHOICE, row);
            }

            if (сrossGroupingChart.getSecondQuestionOptions().isWithNoChoice()) {
                int pairCount = answerService.
                        countByQuestion_idAndChoice_id(
                                secondQuestionMetaInfId,
                                firstChoiceID,
                                сrossGroupingChart.getFirstQuestionOptions().isUseRow_idInstedOfChoice_id());
                pairCount = firstChoiceCount - pairCount;
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
                row.add(percent);
                addMetaDataToRow(pairCount, firstChoiceCount, countPercentAndFormat(pairCount, firstChoiceCount), chartOptions, NO_CHOICE, row);
            }

            chartData.addData(row);
        }

        return chartData;
    }

    public ChartData createChartDataFromGroupedByChoiceChart(GroupedByChoiceChart groupedByChoiceChart) {
        ChartData chartData = new ChartData();

        Options options = createDefaultOptions(groupedByChoiceChart);
        chartData.setOptions(options);

        List columnsNames = createColumnWithNamesFromGroupedByChoiceChart(groupedByChoiceChart);
        chartData.addData(columnsNames);

        for (int choiceCount = 0; choiceCount < groupedByChoiceChart.getChoiceGroups().size(); choiceCount++) {  // отходим ChoiceGroupList
            ChoiceGroup choiceGroup = groupedByChoiceChart.getChoiceGroups().get(choiceCount);
            List row = new LinkedList();
            row.add(choiceGroup.getText());
            for (int conferenceCount = 0; conferenceCount < choiceGroup.getChoicesId().size(); conferenceCount++) {  // обходим конкретные ответы 
                Long choice_id = choiceGroup.getChoicesId().get(conferenceCount);
                if (Objects.nonNull(choice_id)) {
                    QuestionDetails questionDetails = groupedByChoiceChart.getQuestionDetails().get(conferenceCount);
                    String conferencesName = questionDetails.getName();
                    Long question_id = questionDetails.getQuestionId();
                    Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(question_id);
                    int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);
                    int thisAnswers = answerService.countById(choiceGroup.getChoicesId().get(conferenceCount), questionDetails.getQuestionOptions().isUseRow_idInstedOfChoice_id());
                    double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), conferencesName, row);
                } else {
                    addNoDataToRow(groupedByChoiceChart.getChartOptions(), row);
                }
            }
            chartData.addData(row);
        }

        //инфа о своих ответах 
        if (groupedByChoiceChart.getQuestionOptions().isWithCustomChoice()) {
            List row = new LinkedList();
            row.add(CUSTOM_CHOICE);
            for (int conferenceCount = 0; conferenceCount < groupedByChoiceChart.getQuestionDetails().size(); conferenceCount++) {  // обходим конкретные ответы 
                QuestionDetails questionDetails = groupedByChoiceChart.getQuestionDetails().get(conferenceCount);
                Long question_id = questionDetails.getQuestionId();
                Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(question_id);
                if (Objects.nonNull(other_id)) {
                    String conferencesName = questionDetails.getName();
                    Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(question_id);
                    int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);
                    int thisAnswers = answerService.countByOther_id(other_id);
                    double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), conferencesName, row);
                } else {
                    addNoDataToRow(groupedByChoiceChart.getChartOptions(), row);
                }
            }
            chartData.addData(row);
        }

        if (groupedByChoiceChart.getQuestionOptions().isWithNoChoice()) {
            List row = new LinkedList();
            row.add(NO_CHOICE);

            for (int conferenceCount = 0; conferenceCount < groupedByChoiceChart.getQuestionDetails().size(); conferenceCount++) {  // обходим конкретные ответы 
                QuestionDetails questionDetails = groupedByChoiceChart.getQuestionDetails().get(conferenceCount);
                Long question_id = questionDetails.getQuestionId();

                String conferencesName = questionDetails.getName();
                Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(question_id);
                int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);
                int thisAnswers = questionService.countByQuestionMetaInformationId(question_id);
                thisAnswers = conferenceAnswers - thisAnswers;

                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);

                if (percent > 0.0) {
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), conferencesName, row);
                } else {
                    addNoDataToRow(groupedByChoiceChart.getChartOptions(), row);
                }

            }

            chartData.addData(row);
        }

        return chartData;

    }

    private void addNoDataToRow(ChartOptions chartOptions, List row) {
        row.add(0); //TODO
        if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {
            row.add("");
        }
        if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
            row.add("");
        }
    }

    private void addMetaDataToRow(int thisAnswers, int conferenceAnswers, double percent, ChartOptions chartOptions, String text, List row) { //TODO имя
        if ((thisAnswers > 0) && (chartOptions.getAnnotation() == ChartOptions.Annotation.SHORT)) {
            row.add(createTooltipOrAnnotation(thisAnswers, conferenceAnswers, percent));
        } else if ((thisAnswers > 0) && (chartOptions.getAnnotation() == ChartOptions.Annotation.FULL)) {
            row.add(createTooltipOrAnnotation(text, thisAnswers, conferenceAnswers, percent));
        } else if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
            row.add(null);
        }

        if (chartOptions.getTooltip() == ChartOptions.Tooltip.SHORT) {
            row.add(createTooltipOrAnnotation(thisAnswers, conferenceAnswers, percent));
        } else if (chartOptions.getTooltip() == ChartOptions.Tooltip.FULL) {
            row.add(createTooltipOrAnnotation(text, thisAnswers, conferenceAnswers, percent));
        }

    }

    private List createColumnWithNamesFromCrossGroupingChart(CrossGroupingChart сrossGroupingChart) {
        List columnWithNames = new LinkedList<>();
        columnWithNames.add("");    //не нужен, но не может быть null, поэтому ""
        Long secondQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInformationId();

        List<? extends ChoiceOrRow> choices = questionMetaInformationService.
                getChoiceOrRowsByQuestionMetaInformationId(secondQuestionMetaInfId,
                        сrossGroupingChart.getSecondQuestionOptions().isUseRow_idInstedOfChoice_id());

        ChartOptions chartOptions = сrossGroupingChart.getChartOptions();
        for (int choiceCount = 0; choiceCount < choices.size() - (сrossGroupingChart.isHideLastChoiceInSecondQuestion() ? 1 : 0); choiceCount++) {
            addDataToColumnWithNames(choices.get(choiceCount).getText(), chartOptions, columnWithNames);
        }
        if (сrossGroupingChart.getSecondQuestionOptions().isWithCustomChoice()) {
            addDataToColumnWithNames(CUSTOM_CHOICE, chartOptions, columnWithNames);
        }

        if (сrossGroupingChart.getSecondQuestionOptions().isWithNoChoice()) {
            addDataToColumnWithNames(NO_CHOICE, chartOptions, columnWithNames);
        }

        return columnWithNames;
    }

    private List createColumnWithNamesFromSingleChart(SingleQuestionChart singleChart, ChartOptions chartOptions) {
        List columnWithNames = new LinkedList<>();
        columnWithNames.add("");    //не нужен, но не может быть null, поэтому ""

        Long questionMetaInformationId = singleChart.getQuestionMetaInfId();

        List<? extends ChoiceOrRow> choices
                = questionMetaInformationService.getChoiceOrRowsByQuestionMetaInformationId(questionMetaInformationId,
                        singleChart.getQuestionOptions().isUseRow_idInstedOfChoice_id());

        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
            addDataToColumnWithNames(choices.get(choiceCount).getText(), chartOptions, columnWithNames);
        }

        if (singleChart.getQuestionOptions().isWithCustomChoice()) {
            addDataToColumnWithNames(CUSTOM_CHOICE, chartOptions, columnWithNames);
        }

        if (singleChart.getQuestionOptions().isWithNoChoice()) {
            addDataToColumnWithNames(NO_CHOICE, chartOptions, columnWithNames);
        }
        return columnWithNames;
    }

    private List createColumnWithNamesFromGroupedByChoiceChart(GroupedByChoiceChart groupedByChoiceChart) {
        List columnWithNames = new LinkedList<>();
        ChartOptions chartOptions = groupedByChoiceChart.getChartOptions();
        List<QuestionDetails> questionDetails = groupedByChoiceChart.getQuestionDetails();
        columnWithNames.add("");    //не нужен, но не может быть null, поэтому ""

        for (int confirenceCount = 0; confirenceCount < questionDetails.size(); confirenceCount++) {
            addDataToColumnWithNames(questionDetails.get(confirenceCount).getName(),
                    chartOptions,
                    columnWithNames);
        }

        return columnWithNames;
    }

    private void addDataToColumnWithNames(String text, ChartOptions chartOptions, List columnWithNames) {
        columnWithNames.add(text);

        if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
            columnWithNames.add(Role.getAnnotationRole());
        }
        if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {
            columnWithNames.add(Role.getTooltipRole());
        }
    }

    private Options createDefaultOptions(SingleQuestionChart singleChart, ChartOptions chartOptions, String title) {
        int choicesCount;
        if (!singleChart.getQuestionOptions().isUseRow_idInstedOfChoice_id()) {
            Long questionMetaInfId = singleChart.getQuestionMetaInfId();
            List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(questionMetaInfId);
            choicesCount = choices.size();
        } else {
            choicesCount = questionMetaInformationService.getRowsByQuestionMetaInformationId(singleChart.getQuestionMetaInfId()).size();
        }
        int height = choicesCount * 50;  //TODO убрать константу
        if (singleChart.getQuestionOptions().isWithCustomChoice()) {
            height += 50;
        }
        if (singleChart.getQuestionOptions().isWithNoChoice()) {
            height += 50;
        }

        Options options = new Options(height,
                "horizontal",
                title, chartOptions.isUseGradient()); // TODO
        return options;
    }

    private Options createDefaultOptions(CrossGroupingChart сrossGroupingChart) {
        int firstChoicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(сrossGroupingChart.getFirstQuestionMetaInformationId()).size();
        int secondChoicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(сrossGroupingChart.getSecondQuestionMetaInformationId()).size();
        int height = (firstChoicesCount) * (secondChoicesCount) * 55;  //TODO добавить обработку отказа от последних ответов

        String title = сrossGroupingChart.getChartName();

        Options options = new Options(height,
                "horizontal",
                title, true); // TODO
        return options;
    }

    private Options createDefaultOptions(GroupedByChoiceChart groupedByChoiceChart) {
        int answers = groupedByChoiceChart.getChoiceGroups().size();
        if (groupedByChoiceChart.getQuestionOptions().isWithCustomChoice()) {
            answers++;
        }
        if (groupedByChoiceChart.getQuestionOptions().isWithNoChoice()) {
            answers++;
        }
        int questions = groupedByChoiceChart.getQuestionDetails().size();
        int height = answers * questions * 45 + 50; // 200 на заголовок
        Options options = new Options(height,
                "horizontal",
                groupedByChoiceChart.getChartName()); //TODO подумать про высоту
        return options;
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

    public static String removeTags(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        Matcher m = REMOVE_TAGS.matcher(string);
        return m.replaceAll("");
    }

}
