
function editpage() {
    google.charts.load('current', {'packages': ['corechart']});
    showPresets();
    showSurveys();
    $('.preset-edit').on('click', editPreset);
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
        url: "/MonkeyStatistics/api/surveys",
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
    $.ajax({
        url: "/MonkeyStatistics/api/charts?id=" + presetId,
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




function drawChart(id, div) {
    $.ajax({
        url: "/MonkeyStatistics/api/draw/chart?id=" + id,
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
        dataType: "json",
        success: function (chartsData) {
            if (chartsData.clazz === "org.jugru.monkeyService.model.chart.CrossGroupingChart") {
                createCGEditArea(id, div, chartsData);
            } else if (chartsData.clazz === "org.jugru.monkeyService.model.chart.UngroupedCharts") {
                createUEditArea(id, div, chartsData);
            } else if (chartsData.clazz === "org.jugru.monkeyService.model.chart.GroupedByChoiceChart") {
                createGCEditArea(id, div, chartsData);
            }
        }
    });
}
function createCGEditArea(id, div, chartsData) {
    div.addClass(chartsData.id.toString());
    div.append($(' <input class="chart-id" hidden type="text" value="' + id + '">'));
    let firstQuestionDiv = $('<div class="first-question"></div>');
    let secondQuestionDiv = $('<div class="second-question"></div>');

    let firstQuestion = $('<select class="first-question"></select>');
    let secondQuestion = $('<select class="second-question"></select>');


    let surveys = $('.surveys-select').clone();
    surveys.removeClass('surveys-select');
    surveys.addClass('surveys-select-chart');
    surveys.find('option[value=' + chartsData.surveyId + ']').attr('selected', 'selected');

    surveys.on('change', function () {
        $.ajax({
            url: "/MonkeyStatistics/api/questionsBySurveyId?id=" + $(this).find('option:selected').val(),
            dataType: "json",
            success: function (questionsData) {
                firstQuestion.empty();
                secondQuestion.empty();
                for (var i = 0; i < questionsData.length; i++) {
                    var t = questionsData[i];
                    firstQuestion.append('<option value="' + t.id + '">' + t.name + '</option>');
                    secondQuestion.append('<option value="' + t.id + '">' + t.name + '</option>');
                }

            }
        });
    });

    div.append($('<h3>Имя графика</h3>'));
    div.append($(' <input class="chart-name" type="text" value="' + chartsData.chartName + '">'));
    div.append($('<h3>Опрос</h3>'));
    div.append(surveys);
    div.append(firstQuestionDiv);
    firstQuestionDiv.append($('<h3>Первый вопрос</h3>'));
    firstQuestionDiv.append(firstQuestion);
    firstQuestionDiv.append(createQuestionsCheckboxes(chartsData.firstQuestionOptions));
    div.append(secondQuestionDiv);
    secondQuestionDiv.append($('<h3>Второй вопрос</h3>'));
    secondQuestionDiv.append(secondQuestion);
    secondQuestionDiv.append(createQuestionsCheckboxes(chartsData.secondQuestionOptions));
    div.append(createChartCheckboxes(chartsData.chartOptions));
    div.append(createCommonQuestions());

    $.ajax({
        url: "/MonkeyStatistics/api/questionsBySurveyId?id=" + chartsData.surveyId,
        dataType: "json",
        success: function (questionsData) {
            for (var i = 0; i < questionsData.length; i++) {
                var t = questionsData[i];
                firstQuestion.append('<option value="' + t.id + '">' + t.name + '</option>');
                secondQuestion.append('<option value="' + t.id + '">' + t.name + '</option>');

            }
            firstQuestion.find('option[value=' + chartsData.firstQuestionMetaInformationId + ']').attr('selected', 'selected');
            secondQuestion.find('option[value=' + chartsData.secondQuestionMetaInformationId + ']').attr('selected', 'selected');
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
    let cb1 = $('<button>Удалить</button>');
    let cb2 = $('<button>Сохранить</button> ');
    div.append('<h3>Кнопки</h3>');
    div.append(cb1);
    div.append(cb2);
    return div;
}




function createUEditArea(id, div, chartsData) {
    div.addClass(chartsData.id.toString());
    div.append($(' <input class="chart-id" hidden type="text" value="' + id + '">'));
    div.append($('<h3>Имя графика</h3>'));
    div.append($(' <input class="chart-name" type="text" value="' + chartsData.chartName + '">'));
    div.append($('<h3>Вопросы</h3>'));
    let questions = $('<div class="ungrouped-question"></div>');
    div.append(questions);
    addUngpoupedQuestions(questions, chartsData);
    div.append(createChartCheckboxes(chartsData.chartOptions));
    div.append(createCommonQuestions());
}


function addUngpoupedQuestions(div, chartsData) {
    chartsData.charts.forEach(function (item, i, arr) {
        let singleQuestions = $('<div class="single-question-div"></div>');
        singleQuestions.append($('<h3>' + (i + 1) + ' вопрос</h3>'));

        let surveys = $('.surveys-select').clone();
        surveys.removeClass('surveys-select');
        surveys.addClass('surveys-select-chart');
        surveys.find('option[value=' + item.surveyId + ']').attr('selected', 'selected');
        singleQuestions.append($('<h3>Опрос</h3>'));
        singleQuestions.append(surveys);

        let question = $('<select class="question"></select>');
        $.ajax({
            url: "/MonkeyStatistics/api/questionsBySurveyId?id=" + item.surveyId,
            dataType: "json",
            success: function (questionsData) {
                for (var i = 0; i < questionsData.length; i++) {
                    var t = questionsData[i];
                    question.append('<option value="' + t.id + '">' + t.name + '</option>');
                }
                question.find('option[value=' + item.questionMetaInfId + ']').attr('selected', 'selected');
            }
        });
        singleQuestions.append($('<h3>Вопрос</h3>'));
        singleQuestions.append(question);
        singleQuestions.append(createQuestionsCheckboxes(item.questionOptions));

        div.append(singleQuestions);
    });
}
function createGCEditArea(id, div, chartsData) {
    div.addClass(chartsData.id.toString());
    div.append($(' <input class="chart-id" hidden type="text" value="' + id + '">'));
    div.append($('<h3>Имя графика</h3>'));
    div.append($(' <input class="chart-name" type="text" value="' + chartsData.chartName + '">'));
    div.append($('<h3>Вопросы</h3>'));
    let table = $('<table></table>');
    let tr1 = $('<tr></tr>');
    let tr2 = $('<tr></tr>');
    let tr3 = $('<tr></tr>');
    tr1.append($('<td></td>'));
    tr2.append($('<td></td>'));
    tr3.append($('<td></td>'));
    let quest = [];
    chartsData.questionDetails.forEach(function (item, i, arr) {
        quest[i] = item.questionId;
        tr1.append($('<td><input class="col-name" type="text" value="' + item.name + '"></td>'));

        let surveys = $('.surveys-select').clone();
        surveys.removeClass('surveys-select');
        surveys.addClass('surveys-select-gbc');
        surveys.addClass(item.surveyId.toString());
        surveys.find('option[value=' + item.surveyId + ']').attr('selected', 'selected');
        tr2.append($('<td></td>').append(surveys));


        let question = $('<select  style="width: 300px" class="question"></select>'); //TODO remove style
        $.ajax({
            url: "/MonkeyStatistics/api/questionsBySurveyId?id=" + item.surveyId,
            dataType: "json",
            success: function (questionsData) {
                for (var i = 0; i < questionsData.length; i++) {
                    var t = questionsData[i];
                    question.append('<option value="' + t.id + '">' + t.name + '</option>');
                }
                question.find('option[value=' + item.questionId + ']').attr('selected', 'selected');
            }
        });
        tr3.append($('<td style="width: 300px"></td>').append(question)); //TODO remove style

        //сохряняем ответы в буфер

        $.ajax({
            url: "/MonkeyStatistics/api/answers?id=" + item.questionId,
            dataType: "json",
            success: function (questionsData) {
                let answers = $('<select  style="width: 300px" class="answers"></select>'); //TODO remove style
                for (var i = 0; i < questionsData.length; i++) {
                    var t = questionsData[i];
                    answers.append('<option value="' + t.id + '">' + t.name + '</option>');
                }

            }
        });

    });
    table.append(tr1);
    table.append(tr2);
    table.append(tr3);

    chartsData.choiceGroups.forEach(function (item, i, arr) {
        let tr = $('<tr></tr>');

        tr.append($('<td><input class="row-name" type="text" value="' + item.text + '"></td>'));

        item.choicesId.forEach(function (ID, i, arr) {
            let answers = $('<select  style="width: 300px" class="answers"></select>'); //TODO remove style
            $.ajax({
                url: "/MonkeyStatistics/api/answers?id=" + quest[i],
                dataType: "json",
                success: function (questionsData) {

                    for (var i = 0; i < questionsData.length; i++) {
                        var t = questionsData[i];
                        answers.append('<option value="' + t.id + '">' + t.name + '</option>');
                    }
                    answers.find('option[value=' + ID + ']').attr('selected', 'selected');
                }
            });

            // tr.append($('<td>' + ID + '</td>'));
            tr.append($('<td></td>').append(answers));
        });

        table.append(tr);
    });



    div.append(table);
    div.append(createQuestionsCheckboxes(chartsData.questionOptions));
    div.append(createChartCheckboxes(chartsData.chartOptions));
    div.append(createCommonQuestions());


}

/*
 function show() {
 showPresets();
 }
 
 function showPresets() {
 $.ajax({
 url: "/MonkeyStatistics/api/presets",
 success: function (presetsData) {
 let presets = document.getElementById('presets');
 for (var i = 0; i < presetsData.length; i++) {
 let t = presetsData[i];
 presets.options[i] = new Option(t.description, t.id);
 }
 }
 });
 
 
 }
 
 function drawPresets() {
 $.ajax({
 url: "/MonkeyStatistics/api/charts?id=" + $("#presets :selected").val(),
 success: function (chartsData) {
 let div = $('#chart');
 div.empty();
 for (let i = 0; i < chartsData.length; i++) {
 let newDiv = $('<div></div>');
 div.append(newDiv);
 $.ajax({
 url: "/MonkeyStatistics/api/draw/chart?id=" + chartsData[i].id,
 success: function (chartData) {
 chartData.forEach(function (item, i, arr) {
 let newDiv2 = $('<div></div>');
 newDiv.append(newDiv2);
 var data = google.visualization.arrayToDataTable(item.data)
 var options = item.options;
 var chart = new google.visualization.BarChart(newDiv2.get(0));
 chart.draw(data, options);
 });
 
 }
 });
 }
 }
 });
 }
 
 function showSurveys() {
 $.ajax({
 url: "/MonkeyStatistics/surveys",
 dataType: "json",
 async: false,
 success: function (surveysData) {
 var surveys = $('.surveys');
 surveys = surveys.get(0);
 for (var i = 0; i < surveysData.length; i++) {
 var t = surveysData[i];
 surveys.options[i] = new Option(t.Title, t.Id);
 }
 }
 });
 }
 
 function onSurveyChoice() {
 let surveys = $('.surveys');
 surveys = surveys.get(0);
 $.ajax({
 url: "/MonkeyStatistics/questions?id=" + surveys.options[surveys.selectedIndex].value,
 dataType: "json",
 async: false,
 success: function (data) {
 questions = $('.question');
 questions.empty();
 for (var i = 0; i < data.length; i++) {
 let t = data[i];
 questions.append('<option value="' + t.Id + '">' + t.Title + '</option>');
 
 }
 }
 }).responseText;
 }
 
 function onCGCButtonClick() {
 let q1 = $('.question1 option:selected').val();
 let q2 = $('.question2 option:selected').val();
 
 data = {
 "firstQuestionOptions": {
 "useRow_idInstedOfChoice_id": false
 },
 "secondQuestionOptions": {
 "useRow_idInstedOfChoice_id": false
 },
 "chartOptions": {
 "tooltip": "FULL",
 "annotation": "SHORT",
 "useGradient": false
 }
 };
 
 data.firstQuestionMetaInformationId = q1;
 data.secondQuestionMetaInformationId = q2;
 data.chartName = $('.question2 option:selected').text();
 data.hideLastChoiceInFirstQuestion = $(".lastQuestion1").is(':checked');
 data.hideLastChoiceInSecondQuestion = $(".lastQuestion2").is(':checked');
 data.firstQuestionOptions.withCustomChoice = $(".custom1").is(':checked');
 data.firstQuestionOptions.withNoChoice = $(".noAnswer1").is(':checked');
 data.secondQuestionOptions.withCustomChoice = $(".custom2").is(':checked');
 data.secondQuestionOptions.withNoChoice = $(".noAnswer2").is(':checked');
 
 $.ajax({
 type: "POST",
 contentType: 'application/json',
 url: "/MonkeyStatistics/api/draw/CGC",
 dataType: "json",
 async: false,
 data: JSON.stringify(data),
 success: function (inputData) {
 let div = document.getElementById('chart');
 div.innerHTML = '';
 var data = google.visualization.arrayToDataTable(inputData.data)
 var options = inputData.options;
 var chart = new google.visualization.BarChart(div);
 chart.draw(data, options);
 }
 });
 }
 
 
 var GlobalData = {
 "id": null,
 "chartName": "",
 "charts": [],
 "chartOptions": {
 "id": null,
 "tooltip": "SHORT",
 "annotation": "SHORT",
 "useGradient": false
 }
 };
 
 function onUCButtonClick() {
 
 let q1 = $('.question1 option:selected').val();
 
 GlobalData.chartName = $('.question1 option:selected').text();
 let chart = {};
 chart.questionMetaInfId = q1;
 chart.name = $('.surveys option:selected').text();
 chart.questionOptions = {};
 chart.questionOptions.withCustomChoice = $(".custom1").is(':checked');
 chart.questionOptions.withNoChoice = $(".noAnswer1").is(':checked');
 
 
 GlobalData.charts.push(chart);
 
 
 
 $.ajax({
 type: "POST",
 contentType: 'application/json',
 url: "/MonkeyStatistics/api/draw/UC",
 dataType: "json",
 async: false,
 data: JSON.stringify(GlobalData),
 success: function (inputData) {
 let div = document.getElementById('chart');
 div.innerHTML = '';
 
 inputData.forEach(function (item, i, arr) {
 var newDiv = document.createElement('div');
 div.appendChild(newDiv);
 var data = google.visualization.arrayToDataTable(item.data)
 var options = item.options;
 var chart = new google.visualization.BarChart(newDiv);
 chart.draw(data, options);
 });
 
 
 
 }
 });
 }
 
 function edit() {
 google.charts.load('current', {'packages': ['corechart']});
 showPresets2();
 $('#presets').on('change', null, onPresetsSelect);
 $(document).ready(showSurveys);
 }
 
 function showPresets2() {
 $.ajax({
 url: "/MonkeyStatistics/api/presets",
 success: function (presetsData) {
 let presets = document.getElementById('presets');
 for (var i = 0; i < presetsData.length; i++) {
 let t = presetsData[i];
 presets.options[i] = new Option(t.description, t.id);
 }
 }
 });
 
 
 }
 
 function onPresetsSelect() {
 $.ajax({
 url: "/MonkeyStatistics/api/charts?id=" + $("#presets :selected").val(),
 success: function (chartsData) {
 questions = $('#question');
 questions.empty();
 for (var i = 0; i < chartsData.length; i++) {
 
 let t = chartsData[i];
 questions.append('<option value="' + t.id + '">' + t.description + '</option>');
 
 }
 }
 });
 }
 
 function editquestion() {
 
 }
 
 
 function drawChart() {
 $.ajax({
 url: "/MonkeyStatistics/api/draw/chart?id=" + $("#question :selected").val(),
 success: function (chartData) {
 $('#chart').empty()
 chartData.forEach(function (item, i, arr) {
 let newDiv = $('<div></div>');
 $('#chart').append(newDiv);
 var data = google.visualization.arrayToDataTable(item.data)
 var options = item.options;
 var chart = new google.visualization.BarChart(newDiv.get(0));
 chart.draw(data, options);
 });
 
 }
 });
 }
 
 */