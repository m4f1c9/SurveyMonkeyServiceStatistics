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
        url: "/MonkeyStatistics/api/create/chart",
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
        url: "/MonkeyStatistics/api/delete/preset?id=" + id,

        method: "POST",
        success: function (surveysData) {
            presets.find('option[value=' + id + ']').remove();
            workArea.empty();
        }
    });

}

function createPreset() {
    let text = $(this).closest('.main-buttons').find('.preset-name').val();
    let presets = $(this).closest('body').find('.presets').find('.presets-select');
    $.ajax({
        url: "/MonkeyStatistics/api/create/preset",
        data: "name=" + text,
        method: "POST",
        success: function (surveysData) {

            presets.append('<option value="' + surveysData.id + '">' + surveysData.name + '</option>');
            presets.find('option[value=' + surveysData.id + ']').attr('selected', 'selected');

            let presetId = surveysData.id;
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
    });



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


function drawChart(div, id) {
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
    let cb1 = $(' <input type="checkbox" class="tooltip" checked>Полные тултипы<Br> ');
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
    div.append('<h3>Кнопки</h3>');
    div.append(cb1);
    div.append(cb2);

    cb1.on('click', deleteChart);

    return div;
}


function deleteChart() {
    let id = $(this).closest('.edit-area').find('.chart-id').val();
    let workArea = $(this).closest('.edit-area');

    $.ajax({
        url: "/MonkeyStatistics/api/delete/chart",
        data: "id=" + id,
        method: "POST",
        success: function (data) {
            workArea.remove();

        }
    });
}


function drawChartById(div, id) {
    $.ajax({
        url: "/MonkeyStatistics/api/draw/chart?id=" + id,
        success: function (chartData) {
            div.empty()
            chartData.forEach(function (item, i, arr) {
                let newDiv = $('<div></div>');
                div.append(newDiv);
                var data = google.visualization.arrayToDataTable(item.data)
                var options = item.options;
                var chart = new google.visualization.BarChart(newDiv.get(0));
                chart.draw(data, options);
            });

        }
    });
}

function drawChartByData(div, data) {
    $.ajax({
        type: "POST",
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


/*

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


function drawChartById() {
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