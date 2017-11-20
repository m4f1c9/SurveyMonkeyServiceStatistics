package org.jugru.monkeyStatistics.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Objects.*;
import org.jugru.monkeyService.model.Choice;
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

    public List<ChartData> singleConferenceSpeakers(SingleConferenceStat singleConferenceStat) {
        List<ChartData> chartDataList = new LinkedList<>();
        for (int pairsCount = 0; pairsCount < singleConferenceStat.getPairs().size(); pairsCount++) {
            SpeakersRatingPair pair = singleConferenceStat.getPairs().get(pairsCount);
            ChartData chartData = createChartDataFromPair(pair);
            chartDataList.add(chartData);
        }

        for (int keynotesCount = 0; keynotesCount < singleConferenceStat.getKeynotes().size(); keynotesCount++) {
            Keynote keynote = singleConferenceStat.getKeynotes().get(keynotesCount);
            ChartData chartData = createChartDataFromKeynote(keynote);
            chartDataList.add(chartData);
        }

        return chartDataList;
    }

    public List<ChartData> standartSingleChoiceChartGroupedByAnswer(ConferenceGroup conferenceGroup) {
        List<ChartData> chartDataList = new LinkedList<>();

        for (int questionGroupCount = 0; questionGroupCount < conferenceGroup.getQuestionGroups().size(); questionGroupCount++) { // обходим все QuestionGroup каждый будет отдельной таблицей
            QuestionGroup questionGroup = conferenceGroup.getQuestionGroups().get(questionGroupCount);
            ChartData chartData = createChartDataGroupedByAnswer(questionGroup);
            chartDataList.add(chartData);
        }

        return chartDataList;
    }

    public List<ChartData> standartSingleChoiceChartGroupedByConfirence(ConferenceGroup conferenceGroup) {
        List<ChartData> chartDataList = new LinkedList<>();

        for (int questionGroupCount = 0; questionGroupCount < conferenceGroup.getQuestionGroups().size(); questionGroupCount++) { // обходим все QuestionGroup каждый будет отдельной таблицей
            QuestionGroup questionGroup = conferenceGroup.getQuestionGroups().get(questionGroupCount);
            ChartData chartData = createChartDataGroupedByConfirence(questionGroup);
            chartDataList.add(chartData);

        }

        return chartDataList;
    }

    private ChartData createChartDataFromPair(SpeakersRatingPair pair) {
        ChartData chartData = new ChartData();
        Options options = createOptions(pair);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesFromPair(pair);
        columnsNames.remove(columnsNames.size() - 1); // TODO
        columnsNames.remove(columnsNames.size() - 1);
        chartData.addData(columnsNames);

        Long speakersAnswerID = pair.getSpeakersAnswerID();
        List<Choice> speakers = questionMetaInformationService.getChoicesByQuestionMetaInformationId(speakersAnswerID);

        Long ratingAnswerID = pair.getRatingAnswerID();
        List<Choice> rating = questionMetaInformationService.getChoicesByQuestionMetaInformationId(ratingAnswerID);

        int conferenceAnswers = surveyService.countAnswers(pair.getSurveyID());

        for (int speakersCount = 0; speakersCount < speakers.size() - 1; speakersCount++) {
            List row = new LinkedList();
            row.add(speakers.get(speakersCount).getText());

            Long speakersChoiceID = speakers.get(speakersCount).getId();
            int speakerChoiceCount = answerService.countByChoice_id(speakersChoiceID); //люди на конкретном докладчике

            for (int ratingCount = 0; ratingCount < rating.size() - 1; ratingCount++) {
                Long ratingChoiceID = rating.get(ratingCount).getId();
                int pairCount = answerService.countByTwoChoice_id(speakersChoiceID, ratingChoiceID);
                double percent = countPercentAndFormat(pairCount, conferenceAnswers);

                row.add(percent); //TODO
                if (pairCount > 0) {
                    row.add(createTooltip(rating.get(ratingCount).getText(), pairCount, conferenceAnswers, speakerChoiceCount, percent));
                } else {
                    row.add(null);
                }

            }
            chartData.addData(row);
        }

        return chartData;
    }

    private ChartData createChartDataFromKeynote(Keynote keynote) {
        ChartData chartData = new ChartData();
        Options options = createOptions(keynote);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesFromKeynote(keynote);
        chartData.addData(columnsNames);

        Long keynoteQuestionMetaInfID = keynote.getKeynoteQuestionMetaInfID();
        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(keynoteQuestionMetaInfID);

        List row = new LinkedList();
        row.add(keynote.getText());

        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {

            Choice choice = choices.get(choiceCount);

            String conferencesName = choice.getText();
            int conferenceAnswers = surveyService.countAnswers(keynote.getSurveyID());
            int thisAnswers = answerService.countByChoice_id(choice.getId());
            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);
            if (thisAnswers > 0) {
                row.add(createTooltip(conferencesName, thisAnswers, conferenceAnswers, percent));
            }
            else{
                row.add(null);
            }

        }

        chartData.addData(row);

        return chartData;

    }

    private ChartData createChartDataGroupedByConfirence(QuestionGroup questionGroup) {

        ChartData chartData = new ChartData();

        Options options = createOptions(questionGroup);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesGroupedByConfirence(questionGroup);
        chartData.addData(columnsNames);

        for (int confirenceCount = 0; confirenceCount < questionGroup.getConferenceQuestionPairs().size(); confirenceCount++) {

            chartData.addData(createRowWithRegularChoicesGroupedByConference(questionGroup, confirenceCount));

        }

        return chartData;

    }

    private ChartData createChartDataGroupedByAnswer(QuestionGroup questionGroup) {
        ChartData chartData = new ChartData();

        Options options = createOptions(questionGroup);
        chartData.setOptions(options);

        List columnsNames = createColumnsNamesGroupedByAnswer(questionGroup);
        chartData.addData(columnsNames);

        for (int answersCount = 0; answersCount < questionGroup.getChoiceGroups().size(); answersCount++) {  // отходим ChoiceGroupList
            List row = createRowWithRegularChoicesGroupedByAnswer(questionGroup, answersCount);
            chartData.addData(row);
        }

        //инфа о своих ответах 
        if (questionGroup.isWithCustomAnswer()) {
            chartData.addData(createRowWithCustomChoicesGroupedByAnswer(questionGroup));
        }

        if (questionGroup.isWithNoAnswer()) {
            chartData.addData(createRowWithNoChoicesGroupedByAnswer(questionGroup));
        }

        return chartData;

    }

    /**
     * Добавляет Value в таблицы
     */
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
               row.add(createTooltip(conferencesName, thisAnswers, conferenceAnswers, percent));

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
                row.add(createTooltip(answer, thisAnswers, conferenceAnswers, percent));
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
                row.add(createTooltip(CUSTOM_CHOICE, thisAnswers, conferenceAnswers, percent));
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
            row.add(createTooltip(NO_CHOICE, thisAnswers, conferenceAnswers, percent));
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
                row.add(createTooltip(conferencesName, thisAnswers, conferenceAnswers, percent));
            } else {
                row.add(0);
                row.add("");
            }

        }
        return row;
    }

    private List createRowWithNoChoicesGroupedByAnswer(QuestionGroup questionsGroup) {

        List row = new LinkedList();
        row.add(NO_CHOICE);

        for (int questionsCount = 0; questionsCount < questionsGroup.getConferenceQuestionPairs().size(); questionsCount++) {  // обходим конкретные ответы 

            String conferencesName = questionsGroup.getConferenceQuestionPairs().get(questionsCount).getName();
            long questionID = questionsGroup.getConferenceQuestionPairs().get(questionsCount).getQuestionId();

            int conferenceAnswers = surveyService.countAnswers(questionsGroup.getConferenceQuestionPairs().get(questionsCount).getSurveyId());

            int thisAnswers = questionService.countById(questionID);

            thisAnswers = conferenceAnswers - thisAnswers;

            double percent = countPercentAndFormat(thisAnswers, conferenceAnswers);
            row.add(percent);
            row.add(createTooltip(conferencesName, thisAnswers, conferenceAnswers, percent));

        }
        return row;
    }

    private Options createOptions(QuestionGroup questionGroup) {
        int answers = questionGroup.getChoiceGroups().size();
        if (questionGroup.isWithCustomAnswer()) {
            answers++;
        }
        if (questionGroup.isWithNoAnswer()) {
            answers++;
        }
        int questions = (int) questionGroup.getConferenceQuestionPairs().size();
        int height = answers * questions * 40 + 200;
        Options options = new Options(height,
                "horizontal",
                questionGroup.getName()); //TODO подумать про высоту
        return options;
    }

    private Options createOptions(Keynote keynote) {
        int choicesCount = questionMetaInformationService.getChoicesByQuestionMetaInformationId(keynote.getKeynoteQuestionMetaInfID()).size();
        int height = choicesCount * 50;  //TODO убрать константу
        Options options = new Options(height,
                "horizontal",
                "Кейноуты", true); // TODO
        return options;
    }

    private Options createOptions(SpeakersRatingPair pair) {

        int height = 1000;  //TODO убрать константу
        Options options = new Options(height,
                "horizontal",
                pair.getText(), true);
        return options;
    }

    private List createColumnsNamesFromPair(SpeakersRatingPair pair) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""
        Long RatingAnswerID = pair.getRatingAnswerID();
        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(RatingAnswerID);

        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
            columns.add(choices.get(choiceCount).getText());
            columns.add(Role.getAnnotationTextRole());
        }

        return columns;
    }

    private List createColumnsNamesFromKeynote(Keynote keynote) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""

        Long keynoteQuestionMetaInfID = keynote.getKeynoteQuestionMetaInfID();
        List<Choice> choices = questionMetaInformationService.getChoicesByQuestionMetaInformationId(keynoteQuestionMetaInfID);

        for (int choiceCount = 0; choiceCount < choices.size(); choiceCount++) {
            columns.add(choices.get(choiceCount).getText());
            columns.add(Role.getAnnotationTextRole());
        }

        return columns;
    }

    private List createColumnsNamesGroupedByAnswer(QuestionGroup questionGroup) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""

        for (int confirenceCount = 0; confirenceCount < questionGroup.getConferenceQuestionPairs().size(); confirenceCount++) {

            columns.add(questionGroup.getConferenceQuestionPairs().get(confirenceCount).getName());
            columns.add(Role.getTooltipRole());

        }

        return columns;
    }

    private List createColumnsNamesGroupedByConfirence(QuestionGroup questionsGroup) {
        List columns = new LinkedList<>();
        columns.add("");    //не нужен, но не может быть null, поэтому ""
        questionsGroup.getChoiceGroups().forEach((t) -> {
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

    private double countPercentAndFormat(int thisAnswers, int totalAnswers) {
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

    private String createTooltip(String text, int thisAnswers, int speakerAnswers, int totalAnswers, double percent) {
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

}
