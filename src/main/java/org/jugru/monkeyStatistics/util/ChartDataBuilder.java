package org.jugru.monkeyStatistics.util;

import org.jugru.monkeyStatistics.model.Choice;
import org.jugru.monkeyStatistics.model.ChoiceOrRow;
import org.jugru.monkeyStatistics.model.chart.*;
import org.jugru.monkeyStatistics.service.AnswerService;
import org.jugru.monkeyStatistics.service.QuestionMetaInformationService;
import org.jugru.monkeyStatistics.service.QuestionService;
import org.jugru.monkeyStatistics.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ChartDataBuilder {


    private Logger logger = LoggerFactory.getLogger(ChartDataBuilder.class);

    @Autowired
    AnswerService answerService;

    @Autowired
    SurveyService surveyService;

    @Autowired
    QuestionMetaInformationService questionMetaInformationService;

    @Autowired
    QuestionService questionService;


    private static int MINIMUM_HAXIS_UNGROUPED = 79; // На самом деле 100 (магия)
    private static int MINIMUM_HAXIS_GROUPED = 79; // также
    private static int MINIMUM_HAXIS = 23; // 24
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

        List<SingleQuestionChart> charts = ungroupedCharts.getCharts();
        for (int i = 0; i < charts.size(); i++) {
            chartData.add(createChartDataFromSingleChart(charts.get(i),
                    ungroupedCharts.getChartOptions(),
                    (i == 0) ? ungroupedCharts.getChartName() : ""));  //добавляет заголовок первому графику в группе
        }


        for (ChartData d : chartData) {
            d.getOptions().gethAxis().setMaxValue(MINIMUM_HAXIS_UNGROUPED);
        }

        return chartData;
    }

    private ChartData createChartDataFromSingleChart(SingleQuestionChart singleChart, ChartOptions chartOptions, String title) {
        Long questionMetaInfId = singleChart.getQuestionMetaInfId();
        questionMetaInformationService.isSupportedElseThrowException(questionMetaInfId);
        ChartData chartData = new ChartData();


        Options options = createDefaultOptions(singleChart, chartOptions, title);
        chartData.setOptions(options);


        List columnsNames = createColumnWithNamesFromSingleChart(singleChart, chartOptions);
        chartData.addData(columnsNames);


        boolean isUseRow_idInsteadOfChoice_id = questionMetaInformationService.isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(questionMetaInfId);
        List row = new LinkedList();
        Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(questionMetaInfId);
        String surveyName = surveyService.getSurveyNameBySurveyId(surveyId);
        row.add(editRowName(surveyName));


        int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);

        List<? extends ChoiceOrRow> choices
                = questionMetaInformationService.getChoiceOrRowsByQuestionMetaInformationId(questionMetaInfId,
                isUseRow_idInsteadOfChoice_id);

        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
            ChoiceOrRow choice = choices.get(choiceCount);
            int thisAnswers = answerService.countById(choice.getId(), isUseRow_idInsteadOfChoice_id);
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


    private ChartData createChartDataFromSingleChart(CrossGroupingChart сrossGroupingChart) {
        SingleQuestionChart chart = new SingleQuestionChart();
        chart.setQuestionMetaInfId(сrossGroupingChart.getFirstQuestionMetaInformationId());
        chart.setQuestionOptions(сrossGroupingChart.getFirstQuestionOptions());
        ChartData data = createChartDataFromSingleChart(chart, new ChartOptions(сrossGroupingChart.getChartOptions()), сrossGroupingChart.getFirstQuestionName() + " / " + сrossGroupingChart.getChartName());
        data.getOptions().gethAxis().setMaxValue(MINIMUM_HAXIS_UNGROUPED);
        return data;

    }

    public List<ChartData> createFullChartDataFromCrossGroupingChart(CrossGroupingChart сrossGroupingChart) {


        List<ChartData> chartData = new ArrayList<>();

        chartData.add(createChartDataFromSingleChart(сrossGroupingChart));
        chartData.add(createChartDataFromCrossGroupingChart(сrossGroupingChart));
        return chartData;
    }

    public ChartData createChartDataFromCrossGroupingChart(CrossGroupingChart сrossGroupingChart) {
        Long firstQuestionMetaInfId = сrossGroupingChart.getFirstQuestionMetaInformationId();
        Long secondQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInformationId();
        questionMetaInformationService.isSupportedElseThrowException(firstQuestionMetaInfId);
        questionMetaInformationService.isSupportedElseThrowException(secondQuestionMetaInfId);

        ChartOptions chartOptions = сrossGroupingChart.getChartOptions();
        ChartData chartData = new ChartData();
        Options options = createDefaultOptions(сrossGroupingChart);
        chartData.setOptions(options);

        List columnWithNames = createColumnWithNamesFromCrossGroupingChart(сrossGroupingChart);

        chartData.addData(columnWithNames);


        boolean isUseRow_idInsteadOfChoice_idForFirstQuestion = questionMetaInformationService.isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(firstQuestionMetaInfId);
        boolean isUseRow_idInsteadOfChoice_idForSecondQuestion = questionMetaInformationService.isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(secondQuestionMetaInfId);

        List<? extends ChoiceOrRow> firstChoices = questionMetaInformationService.
                getChoiceOrRowsByQuestionMetaInformationId(firstQuestionMetaInfId,
                        isUseRow_idInsteadOfChoice_idForFirstQuestion);

        List<? extends ChoiceOrRow> secondChoices = questionMetaInformationService.
                getChoiceOrRowsByQuestionMetaInformationId(secondQuestionMetaInfId,
                        isUseRow_idInsteadOfChoice_idForSecondQuestion);

        Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(firstQuestionMetaInfId);
        int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);

        for (int firstChoicesCount = 0; firstChoicesCount < (firstChoices.size() - (сrossGroupingChart.isHideLastChoiceInFirstQuestion() ? 1 : 0)); firstChoicesCount++) { // -1!!
            List row = new LinkedList();
            row.add(editRowName(removeTags(firstChoices.get(firstChoicesCount).getText())));

            Long firstChoiceID = firstChoices.get(firstChoicesCount).getId();
            int firstChoiceCount = answerService.countById(firstChoiceID, isUseRow_idInsteadOfChoice_idForSecondQuestion);

            for (int secondChoicesCount = 0; secondChoicesCount < (secondChoices.size() - (сrossGroupingChart.isHideLastChoiceInSecondQuestion() ? 1 : 0)); secondChoicesCount++) { // -1!!

                ChoiceOrRow choice = secondChoices.get(secondChoicesCount);
                Long secondChoiceID = secondChoices.get(secondChoicesCount).getId();
                int pairCount = answerService.countByTwoId(firstChoiceID,
                        secondChoiceID,
                        isUseRow_idInsteadOfChoice_idForFirstQuestion,
                        isUseRow_idInsteadOfChoice_idForSecondQuestion);
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
                row.add(percent);
                addMetaDataToRow(pairCount, firstChoiceCount, countPercentAndFormat(pairCount, firstChoiceCount), chartOptions, choice.getText(), row);
            }

            if (сrossGroupingChart.getSecondQuestionOptions().isWithCustomChoice()) {
                Long other_id = questionMetaInformationService.getOther_idByQuestionMetaInformationId(secondQuestionMetaInfId);
                int pairCount = answerService.countByIdAndOther_id(firstChoiceID,
                        other_id,
                        isUseRow_idInsteadOfChoice_idForFirstQuestion);
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
                row.add(percent);
                addMetaDataToRow(pairCount, firstChoiceCount, countPercentAndFormat(pairCount, firstChoiceCount), chartOptions, CUSTOM_CHOICE, row);
            }

            if (сrossGroupingChart.getSecondQuestionOptions().isWithNoChoice()) {
                int pairCount = answerService.
                        countByQuestion_idAndChoice_id(
                                secondQuestionMetaInfId,
                                firstChoiceID,
                                isUseRow_idInsteadOfChoice_idForFirstQuestion);
                pairCount = firstChoiceCount - pairCount;
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);
                row.add(percent);
                addMetaDataToRow(pairCount, firstChoiceCount, countPercentAndFormat(pairCount, firstChoiceCount), chartOptions, NO_CHOICE, row);
            }

            chartData.addData(row);
        }

        chartData.getOptions().gethAxis().setMaxValue(MINIMUM_HAXIS);

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
            row.add(editRowName(choiceGroup.getText()));

            for (int conferenceCount = 0; conferenceCount < choiceGroup.getChoicesId().size(); conferenceCount++) {  // обходим конкретные ответы 
                Long choice_id = choiceGroup.getChoicesId().get(conferenceCount);
                if (Objects.nonNull(choice_id)) {

                    QuestionDetails questionDetails = groupedByChoiceChart.getQuestionDetails().get(conferenceCount);


                    Long questionMetaInfId = questionDetails.getQuestionId();
                    questionMetaInformationService.isSupportedElseThrowException(questionMetaInfId);
                    boolean isUseRow_idInsteadOfChoice_idForSecondQuestion = questionMetaInformationService.isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(questionMetaInfId);


                    Long questionId = questionDetails.getQuestionId();
                    Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(questionId);
                    String surveyName = surveyService.getSurveyNameBySurveyId(surveyId);

                    int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);

                    int thisAnswers = answerService.countById(choiceGroup.getChoicesId().get(conferenceCount), isUseRow_idInsteadOfChoice_idForSecondQuestion);
                    double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), surveyName, row);
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
                    Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(question_id);
                    int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);
                    int thisAnswers = answerService.countByOther_id(other_id);
                    double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), CUSTOM_CHOICE, row);
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

                Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(question_id);
                int conferenceAnswers = surveyService.countResponsesBySurveyId(surveyId);
                int thisAnswers = questionService.countByQuestionMetaInformationId(question_id);
                thisAnswers = conferenceAnswers - thisAnswers;

                double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);

                if (percent > 0.0) {
                    row.add(percent);
                    addMetaDataToRow(thisAnswers, conferenceAnswers, percent, groupedByChoiceChart.getChartOptions(), NO_CHOICE, row);
                } else {
                    addNoDataToRow(groupedByChoiceChart.getChartOptions(), row);
                }

            }

            chartData.addData(row);
        }

        chartData.getOptions().gethAxis().setMaxValue(MINIMUM_HAXIS_GROUPED);

        return chartData;

    }

    private void addNoDataToRow(ChartOptions chartOptions, List row) {
        row.add(0); //TODO
        if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
            row.add("");
            row.add("");
        }
        if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {
            row.add("");
        }

    }

    private void addMetaDataToRow(int thisAnswers, int conferenceAnswers, double percent, ChartOptions chartOptions, String text, List row) { //TODO имя
        if (/*(thisAnswers > 0) && */(chartOptions.getAnnotation() == ChartOptions.Annotation.SHORT)) {
            row.add(createTooltipOrAnnotation(thisAnswers, conferenceAnswers, percent));

        } else if (/*(thisAnswers > 0) && */(chartOptions.getAnnotation() == ChartOptions.Annotation.FULL)) {
            row.add(createTooltipOrAnnotation(text, thisAnswers, conferenceAnswers, percent));

        } else if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) { //TODO наверно не достижимо
            row.add(null);

        }

        if (chartOptions.getTooltip() == ChartOptions.Tooltip.SHORT) {
            row.add(createTooltipOrAnnotation(thisAnswers, conferenceAnswers, percent));
            row.add(createTooltipOrAnnotation(thisAnswers, conferenceAnswers, percent));
        } else if (chartOptions.getTooltip() == ChartOptions.Tooltip.FULL) {
            row.add(createTooltipOrAnnotation(text, thisAnswers, conferenceAnswers, percent));
            row.add(createTooltipOrAnnotation(text, thisAnswers, conferenceAnswers, percent));
        }

    }

    private List createColumnWithNamesFromCrossGroupingChart(CrossGroupingChart сrossGroupingChart) {
        List columnWithNames = new LinkedList<>();
        columnWithNames.add("");    //не нужен, но не может быть null, поэтому ""
        Long secondQuestionMetaInfId = сrossGroupingChart.getSecondQuestionMetaInformationId();
        boolean isUseRow_idInsteadOfChoice_idForSecondQuestion = questionMetaInformationService.isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(secondQuestionMetaInfId);


        List<? extends ChoiceOrRow> choices = questionMetaInformationService.
                getChoiceOrRowsByQuestionMetaInformationId(secondQuestionMetaInfId,
                        isUseRow_idInsteadOfChoice_idForSecondQuestion);

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
        boolean isUseRow_idInsteadOfChoice_id = questionMetaInformationService.isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(questionMetaInformationId);

        List<? extends ChoiceOrRow> choices
                = questionMetaInformationService.getChoiceOrRowsByQuestionMetaInformationId(questionMetaInformationId,
                isUseRow_idInsteadOfChoice_id);

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

        for (int conferenceCount = 0; conferenceCount < questionDetails.size(); conferenceCount++) {
            Long questionId = questionDetails.get(conferenceCount).getQuestionId();
            Long surveyId = surveyService.findSurveyIdByQuestionMetaInformationId(questionId);
            String surveyName = surveyService.getSurveyNameBySurveyId(surveyId);

            addDataToColumnWithNames(surveyName,
                    chartOptions,
                    columnWithNames);
        }

        return columnWithNames;
    }

    private void addDataToColumnWithNames(String text, ChartOptions chartOptions, List columnWithNames) {
        columnWithNames.add(removeTags(text));

        if (chartOptions.getAnnotation() != ChartOptions.Annotation.NO) {
            columnWithNames.add(Role.getAnnotationRole());
            columnWithNames.add(Role.getAnnotationTextRole());
        }
        if (chartOptions.getTooltip() != ChartOptions.Tooltip.NO) {
            columnWithNames.add(Role.getTooltipRole());
        }
    }

    private Options createDefaultOptions(SingleQuestionChart singleChart, ChartOptions chartOptions, String title) {
        Long questionMetaInfId = singleChart.getQuestionMetaInfId();
        boolean isUseRow_idInsteadOfChoice_id = questionMetaInformationService.isUseRow_idInsteadOfChoice_idByQuestionMetaInformationId(questionMetaInfId);

        // задаем высоту графика
        int choicesCount;
        if (!isUseRow_idInsteadOfChoice_id) {
            List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(questionMetaInfId);
            choicesCount = choices.size();
        } else {
            choicesCount = questionMetaInformationService.getRowsByQuestionMetaInformationId(questionMetaInfId).size();
        }
        //
        if (singleChart.getQuestionOptions().isWithCustomChoice()) {
            choicesCount++;
        }
        if (singleChart.getQuestionOptions().isWithNoChoice()) {
            choicesCount++;
        }

        Options options = Options.create(chartOptions,
                title,
                choicesCount); // TODO
        return options;
    }

    private Options createDefaultOptions(CrossGroupingChart crossGroupingChart) {
        int firstChoicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(crossGroupingChart.getFirstQuestionMetaInformationId()).size(); //TODO добавить выбор между choice и Row
        int secondChoicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(crossGroupingChart.getSecondQuestionMetaInformationId()).size();

        if (crossGroupingChart.getFirstQuestionOptions().isWithCustomChoice()) {
            firstChoicesCount++;
        }
        if (crossGroupingChart.getFirstQuestionOptions().isWithNoChoice()) {
            firstChoicesCount++;
        }

        if (crossGroupingChart.getSecondQuestionOptions().isWithCustomChoice()) {
            secondChoicesCount++;
        }
        if (crossGroupingChart.getSecondQuestionOptions().isWithNoChoice()) {
            secondChoicesCount++;
        }

        if (crossGroupingChart.isHideLastChoiceInFirstQuestion()) {
            firstChoicesCount--;
        }

        if (crossGroupingChart.isHideLastChoiceInSecondQuestion()) {
            secondChoicesCount--;
        }


        Options options = Options.create(crossGroupingChart, firstChoicesCount, secondChoicesCount);
        return options;
    }

    private Options createDefaultOptions(GroupedByChoiceChart groupedByChoiceChart) {
        int choices = groupedByChoiceChart.getChoiceGroups().size();  //TODO добавить выбор между choice и Row
        if (groupedByChoiceChart.getQuestionOptions().isWithCustomChoice()) {
            choices++;
        }
        if (groupedByChoiceChart.getQuestionOptions().isWithNoChoice()) {
            choices++;
        }
        int questions = groupedByChoiceChart.getQuestionDetails().size();


        Options options = Options.create(groupedByChoiceChart, choices, questions); //TODO подумать про высоту
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

    private String editRowName(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        StringBuilder builder = new StringBuilder(string);

        for (int i = 1; i < builder.length(); i++)
            if (builder.charAt(i) == '/' || builder.charAt(i) == '—') {
                builder.insert(i +1, '\n');
            }


        return builder.toString();
    }

}
