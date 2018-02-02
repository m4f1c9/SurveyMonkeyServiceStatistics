function saveU() {
    let editArea = $(this).closest('.edit-area');
    let answer = collectUData(editArea);


    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: "/MonkeyStatistics/api/chart",
        method: "PUT",
        dataType: "json",
        async: false,
        data: JSON.stringify(answer),
        success: function (inputData) {
            drawChartById(editArea.find('.chart'), answer.id);
        },

        error: function (inputData) {
        }
    });


}

function collectUData(editArea) {
    let answer = {};
    answer.id = editArea.find('.chart-id').val();
    answer.chartName = editArea.find('.chart-name').val();
    answer.type = "UngroupedCharts";
    answer.charts = [];
    answer.chartOptions = {};

    answer.chartOptions.useGradient = editArea.find('.gradient').is(':checked');
    if (editArea.find('.tooltip').is(':checked')) {
        answer.chartOptions.tooltip = 'FULL';
    }
    else {
        answer.chartOptions.tooltip = 'SHORT';
    }

    if (editArea.find('.annotation').is(':checked')) {
        answer.chartOptions.annotation = 'FULL';
    }
    else {
        answer.chartOptions.annotation = 'SHORT';
    }

    editArea.find('.ungrouped-question').children('.single-question-div').each(function (index) {
        let t = $(this);
        let data = {};

        data.questionMetaInfId = t.children('.question').find('option:selected').val();


        data.questionOptions = {};
        data.questionOptions.withCustomChoice = t.find('.question-checkboxes').find('.custom-choice').is(':checked');
        data.questionOptions.withNoChoice = t.find('.question-checkboxes').find('.no-choice').is(':checked');
        answer.charts[index] = data;
    });
    return answer;
}

function addUngpoupedQuestions(div, chartsData) {
    chartsData.charts.forEach(function (item, i, arr) {
        let singleQuestions = $('<div  class="single-question-div"></div>');
        singleQuestions.append($('<h3>' + (i + 1) + ' вопрос</h3>'));


        singleQuestions.append(createDeleteButton());

        let surveys = $('.surveys-select').clone();
        surveys.removeClass('surveys-select');
        surveys.addClass('surveys-select-chart');
        surveys.find('option[value=' + item.surveyId + ']').attr('selected', 'selected');

        singleQuestions.append($('<h3>Опрос</h3>'));
        singleQuestions.append(surveys);
        let question = createQuestionsSelect(item);
        addOnChangeBehaviorToSurveysSelectU(surveys, question);
        addOnChangeBehaviorToQuestionsSelectU(question);
        let questionOptions = item.questionOptions
        singleQuestions.append($('<h3>Вопрос</h3>'));
        singleQuestions.append(question);
        singleQuestions.append(createQuestionsCheckboxes(questionOptions));
        div.append(singleQuestions);
    });
}

function createDeleteButton() {
    let delChart = $('<button class="delete-gr">Удалить этот вопрос</button>');
    delChart.on('click', getGr);
    return delChart;
}


function createQuestionsSelect(item, surveys) {
    let question = $('<select style="width: 500px" class="question"></select>');
    let id;
    let questionMetaInfId;
    if(item !=undefined ){
        questionMetaInfId = item.questionMetaInfId;
    }
    if (item != undefined) {
        id = item.surveyId;
    }
    else {
        id = surveys.find('option:selected').val();
    }
    getQuestionsDataAndAppendItToQuestionsSelect(id, question, questionMetaInfId);
    return question;
}


function addOnChangeBehaviorToSurveysSelectU(surveys, question) {
    surveys.on('change', function () {
        let id = $(this).find('option:selected').val();
        getQuestionsDataAndAppendItToQuestionsSelect(id, question);
    });
}



function addOnChangeBehaviorToQuestionsSelectU(question) {
    question.on('change', function () {
        let chartName = $(this).closest('.edit-area').find('.chart-name').val();
        if (chartName === '' || chartName == null) {
            $(this).closest('.edit-area').find('.chart-name').val($(this).find('option:selected').text());
        }
        let surveyId =  $(this).closest('.single-question-div').find('.surveys-select-chart').find('option:selected').val();
        let questionsData = sessionStorage.getItem('questionsBySurveyId' + surveyId);
        if(questionsData != null){
            questionsData = JSON.parse(questionsData);
            let questionId = $(this).find('option:selected').val();
            questionsData.forEach(function (item, i, arr) {
                if(item.id == questionId){
                    if(item.withCustomChoice){
                        question.closest('.single-question-div').find('.custom-choice').attr('disabled', false);
                    }
                    else{
                        question.closest('.single-question-div').find('.custom-choice').get(0).checked = false;
                        question.closest('.single-question-div').find('.custom-choice').attr('disabled', true);
                    }
                    if(item.withNoChoice){
                        question.closest('.single-question-div').find('.no-choice').attr('disabled', false);
                    }
                    else{
                        question.closest('.single-question-div').find('.no-choice').get(0).checked = false;
                        question.closest('.single-question-div').find('.no-choice').attr('disabled', true);
                    }
                }
            })
        }

    });
}
function disableButtonsU() {

}


function createUEditArea(id, div, chartsData) {
    div.append($(' <input class="chart-id" hidden type="text" value="' + id + '">'));
    div.append($('<h3>Имя графика</h3>'));
    div.append($(' <input style="width: 600px" class="chart-name" type="text" value="' + chartsData.chartName + '">'));
    div.append($('<h3>Вопросы</h3>'));
    let questions = $('<div class="ungrouped-question"></div>');
    div.append(questions);
    addUngpoupedQuestions(questions, chartsData);
    div.append(createChartCheckboxes(chartsData.chartOptions));
    let buttons = createCommonQuestions();
    buttons.find('.save').on('click', saveU);
    buttons.append('<button class="add-question">Добавить вопрос</button>')
    div.append(buttons);

    let chartDiv = $('<div class="chart"></div>');
    div.append($('<h3>Предпросмотр</h3>'));
    div.append(chartDiv);

    setTimeout(drawChartById, defaultTimeOut, chartDiv, id);

    buttons.append($('<button class="reDrawCG">Перерисовать</button>'))
    buttons.find('.reDrawCG').on('click', reDrawU);
    buttons.find('.add-question').on('click', addUQuestion);
}

function getGr() {
    $(this).closest('.single-question-div').remove();
}

function createCustomQuestionOptions() {
    let questionOptions = {};
    questionOptions.withCustomChoice = false;
    questionOptions.withNoChoice = false;
    return questionOptions;
}

function addUQuestion() {
    let questions = $(this).closest('.edit-area').find('.ungrouped-question');
    let singleQuestions = $('<div class="single-question-div"></div>');
    singleQuestions.append($('<h3>' + (questions.children().length + 1) + ' вопрос</h3>'));

    singleQuestions.append(createDeleteButton());


    let surveys = $('.surveys-select').clone();
    surveys.removeClass('surveys-select');
    surveys.addClass('surveys-select-chart');

    singleQuestions.append($('<h3>Опрос</h3>'));
    singleQuestions.append(surveys);
    let question = createQuestionsSelect(null, surveys);
    addOnChangeBehaviorToSurveysSelectU(surveys, question);
    addOnChangeBehaviorToQuestionsSelectU(question);

    let questionOptions = createCustomQuestionOptions();
    singleQuestions.append($('<h3>Вопрос</h3>'));
    singleQuestions.append(question);
    singleQuestions.append(createQuestionsCheckboxes(questionOptions));
    questions.append(singleQuestions);


}


function reDrawU() {
    let editArea = $(this).closest('.edit-area');
    let data = collectUData(editArea);
    drawChartByData(editArea.find('.chart'), data);
}