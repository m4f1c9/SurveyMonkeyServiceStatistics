function editpage() {
    google.charts.load('current', {'packages': ['corechart']});
    showPresets();
    showSurveys();
    $('.preset-edit').on('click', editPreset);
    $('.preset-add').on('click', createPreset);
    $('.preset-delete').on('click', deletePreset);
    $('.add-chart').on('click', addChart);
}


function addChart() {
    let type = $(this).closest('.main-buttons').find('.new-chart option:selected').val();
    let id = $(this).closest('body').find('.presets').find('.presets-select').find('option:selected').val();
    let workArea = $(this).closest('body').find('.work-area');
    $.ajax({
        url: "/MonkeyStatistics/api/chart",
        data: "type=" + type + "&id=" + id,
        method: "POST",
        success: function (data) {
            let newDiv = $('<div class=edit-area></div>');
            workArea.append(newDiv);
            createEditArea(data.id, newDiv);

        }
    });
}


function deletePreset() {


    let id = $(this).closest('body').find('.presets').find('.presets-select').find('option:selected').val();
    let presets = $(this).closest('body').find('.presets').find('.presets-select');
    let workArea = $(this).closest('body').find('.work-area');
    $.ajax({
        url: "/MonkeyStatistics/api//preset?id=" + id,
        method: "DELETE",
        success: function (surveysData) {
            presets.find('option[value=' + id + ']').remove();
            workArea.empty();
        }
    });
    $('.add-chart').attr("disabled", true);

}

function createPreset() {
    let text = $(this).closest('.main-buttons').find('.preset-name').val();
    let presets = $(this).closest('body').find('.presets').find('.presets-select');
    $.ajax({
        url: "/MonkeyStatistics/api/preset",
        data: "name=" + text,
        method: "POST",
        success: function (surveysData) {

            presets.append('<option value="' + surveysData.id + '">' + surveysData.name + '</option>');
            presets.find('option[value=' + surveysData.id + ']').attr('selected', 'selected');

            let presetId = surveysData.id;
            getPresetDataAndDrawIt(presetId);
        }
    });
    $('.add-chart').attr("disabled", false);
}


function showPresets() {
    $.ajax({
        url: "/MonkeyStatistics/api/presets",
        success: function (presetsData) {
            let presets = $('.presets-select');
            presets.empty();
            for (var i = 0; i < presetsData.length; i++) {
                let t = presetsData[i];
                presets.append('<option value="' + t.id + '">' + t.name + '</option>');
            }
        }
    });
}

function showSurveys() {
    $.ajax({
        url: "/MonkeyStatistics/api/preset",
        method: "GET",
        dataType: "json",
        success: function (surveysData) {
            let surveys = $('.surveys-select');
            surveys.empty();
            for (var i = 0; i < surveysData.length; i++) {
                var t = surveysData[i];
                surveys.append('<option value="' + t.id + '">' + t.name + '</option>');
            }
        }
    });
}

function editPreset() {
    let presetId = $('.presets-select option:selected').val();
    getPresetDataAndDrawIt(presetId);
    $('.add-chart').attr("disabled", false);
}


function drawChartById(div, id) {
    $.ajax({
        url: "/MonkeyStatistics/api/draw?id=" + id,
        method: "GET",
        success: function (chartData) {
            div.empty();
            chartData.forEach(function (item, i, arr) {
                let chartDiv = $('<div></div>');
                div.append(chartDiv);
                var data = google.visualization.arrayToDataTable(item.data)
                var options = item.options;
                var chart = new google.visualization.BarChart(chartDiv.get(0));
                chart.draw(data, options);
            });
        }
    });
}

function createEditArea(id, div) {
    $.ajax({
        url: "/MonkeyStatistics/api/chart?id=" + id,
        method: "GET",
        dataType: "json",
        success: function (chartsData) {
            div.empty();
            if (chartsData.type === "CrossGroupingChart") {
                createCGEditArea(id, div, chartsData);
            } else if (chartsData.type === "UngroupedCharts") {
                createUEditArea(id, div, chartsData);
            } else if (chartsData.type === "GroupedByChoiceChart") {
                createGCEditArea(id, div, chartsData);
            }
        }
    });
}


function createQuestionsCheckboxes(questionOptions) {
    let div = $('<div class="question-checkboxes"></div>');
    let cb1 = $(' <input type="checkbox" class="custom-choice">Включить свой выбор<Br> ');
    let cb2 = $(' <input type="checkbox" class="no-choice">Включить отсутсвие ответа<Br> ');
    if (questionOptions.withCustomChoice) {
        cb1.prop("checked", true);
    }
    if (questionOptions.withNoChoice) {
        cb2.prop("checked", true);
    }
    div.append(cb1);
    div.append(cb2);
    return div;
}


function createChartCheckboxes(chartOptions) {
    let div = $('<div class="chart-checkboxes"></div>');
    let cb1 = $(' <input type="checkbox" class="tooltip">Полные тултипы<Br> ');
    let cb2 = $(' <input type="checkbox" class="annotation">Полные подписи<Br> ');
    let cb3 = $(' <input type="checkbox" class="gradient">Использовать градиент<Br> ');
    if (chartOptions.tooltip == 'FULL') {
        cb1.prop("checked", true);
    }
    if (chartOptions.annotation == 'FULL') {
        cb2.prop("checked", true);
    }
    if (chartOptions.useGradient) {
        cb3.prop("checked", true);
    }


    div.append('<h3>Общие вопросы</h3>');
    div.append(cb1);
    div.append(cb2);
    div.append(cb3);
    return div;
}

function createCommonQuestions() {
    let div = $('<div class="common-question"></div>');
    let cb1 = $('<button class="delete-chart">Удалить</button>');
    let cb2 = $('<button class="save">Сохранить</button> ');
    let cb3 = $('<button class="cancel">Отменить изменения</button> ');
    div.append('<h3>Кнопки</h3>');
    div.append(cb1);
    div.append(cb2);
    div.append(cb3);

    cb1.on('click', deleteChart);
    cb3.on('click', cancelChartChanges);
    return div;
}

function cancelChartChanges() {
    let id = $(this).closest('.edit-area').find('.chart-id').val();
    let editArea = $(this).closest('.edit-area');

    createEditArea(id, editArea);
}

function deleteChart() {
    let id = $(this).closest('.edit-area').find('.chart-id').val();
    let editArea = $(this).closest('.edit-area');

    $.ajax({
        url: "/MonkeyStatistics/api/chart",
        data: "id=" + id,
        method: "DELETE",
        success: function (data) {
            editArea.remove();

        }
    });
}


function drawChartByData(div, data) {
    $.ajax({
        method: "POST",
        contentType: 'application/json',
        url: "/MonkeyStatistics/api/preview",
        dataType: "json",
        data: JSON.stringify(data),
        success: function (inputData) {
            div.empty()

            inputData.forEach(function (item, i, arr) {
                var newDiv = document.createElement('div');
                div[0].appendChild(newDiv);
                var data = google.visualization.arrayToDataTable(item.data)
                var options = item.options;
                var chart = new google.visualization.BarChart(newDiv);
                chart.draw(data, options);
            });


        }
    });
}


function drawPresets() {
    let presetId = $("#presets :selected").val();
    $.ajax({
        url: "/MonkeyStatistics/api/charts?id=" + presetId,
        method: "GET",
        success: function (chartsData) {
            let div = $('#chart');
            div.empty();
            for (let i = 0; i < chartsData.length; i++) {
                let newDiv = $('<div></div>');
                div.append(newDiv);
                let id = chartsData[i].id;
                drawChartById(newDiv, id);
            }
        }
    });
}


function show() {

    $.ajax({
        url: "/MonkeyStatistics/api/presets",
        success: function (presetsData) {
            let presets = document.getElementById('presets');
            for (var i = 0; i < presetsData.length; i++) {
                let t = presetsData[i];
                presets.options[i] = new Option(t.name, t.id);
            }
        }
    });
}


function getQuestionsDataAndAppendItToQuestionsSelect(surveyId, questions, questionId) {
    let questionsData = sessionStorage.getItem('questionsBySurveyId' + surveyId);
    if (questionsData != null) {
        appendQuestionsToQuestionsSelect(questions, JSON.parse(questionsData), questionId);
    }
    else {
        $.ajax({
            url: "/MonkeyStatistics/api/questionsBySurveyId",
            dataType: "json",
            data: "id=" + surveyId,
            method: "POST",
            success: function (questionsData) {
                sessionStorage.setItem('questionsBySurveyId' + surveyId, JSON.stringify(questionsData));
                appendQuestionsToQuestionsSelect(questions, questionsData, questionId);
            }
        });
    }
}

function getPresetDataAndDrawIt(presetId) {
    $.ajax({
        url: "/MonkeyStatistics/api/charts?id=" + presetId,
        method: "GET",
        dataType: "json",
        success: function (chartsData) {
            let workArea = $('.work-area');
            workArea.empty();
            for (var i = 0; i < chartsData.length; i++) {
                let newDiv = $('<div class=edit-area></div>');
                workArea.append(newDiv);
                createEditArea(chartsData[i].id, newDiv);
            }
        }
    });
}

function appendQuestionsToQuestionsSelect(questions, questionsData, questionId) {
    questions.empty();
    for (var i = 0; i < questionsData.length; i++) {
        var t = questionsData[i];
        questions.append('<option value="' + t.id + '">' + t.name + '</option>');
    }
    if (questionId != undefined) {
        questions.find('option[value=' + questionId + ']').attr('selected', 'selected');
    }

}

function getAnswersDataAndAppendItToAnswersSelect(questionId, answers, answerId) {
    console.log("questionId " + questionId + " answers " + answers + " answerId " + answerId);
    let answersData = sessionStorage.getItem('answers' + questionId);
    if (answersData != null) {
        appendAnswersToAnswersSelect(answers, JSON.parse(answersData), answerId);
    }
    else {
        $.ajax({
            url: "/MonkeyStatistics/api/answers?id=" + questionId,
            dataType: "json",
            success: function (answersData) {
                sessionStorage.setItem('answers' + questionId, JSON.stringify(answersData));
                appendAnswersToAnswersSelect(answers, answersData, answerId);
            }
        });
    }
}

function appendAnswersToAnswersSelect(answers, answersData, answerId) {
    answers.empty();
    answers.append('<option value="null">' + 'Вариант отсутствует' + '</option>');
    for (var i = 0; i < answersData.length; i++) {
        var t = answersData[i];
        answers.append('<option value="' + t.id + '">' + t.name + '</option>');
    }
    if (answerId != null) {
        answers.find('option[value=' + answerId + ']').attr('selected', 'selected');
    }
}
