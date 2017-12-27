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
    $('.add-chart').attr("disabled", true);

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
    $('.add-chart').attr("disabled", false);
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

    createEditArea(id,editArea);
}

function deleteChart() {
    let id = $(this).closest('.edit-area').find('.chart-id').val();
    let editArea = $(this).closest('.edit-area');

    $.ajax({
        url: "/MonkeyStatistics/api/delete/chart",
        data: "id=" + id,
        method: "POST",
        success: function (data) {
            editArea.remove();

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

