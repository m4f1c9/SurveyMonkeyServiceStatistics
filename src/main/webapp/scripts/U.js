function saveU() {
    let editArea = $(this).closest('.edit-area');
   let answer = collectUData(editArea);


    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: "/MonkeyStatistics/api/saveChart",
        dataType: "json",
        async: false,
        data: JSON.stringify(answer),
        success: function (inputData) {
            alert('Ок');
            drawChartById(editArea.find('.chart'), answer.id);
        },

        error: function (inputData) {
            alert('Что-то сломалось');
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
        data.name = t.find('.single-chart-name').val();
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
        let singleQuestions = $('<div class="single-question-div"></div>');
        singleQuestions.append($('<h3>' + (i + 1) + ' вопрос</h3>'));

        let surveys = $('.surveys-select').clone();
        surveys.removeClass('surveys-select');
        surveys.addClass('surveys-select-chart');
        surveys.find('option[value=' + item.surveyId + ']').attr('selected', 'selected');
        singleQuestions.append($('<h3>Опрос</h3>'));
        singleQuestions.append(surveys);

        singleQuestions.append($('<h3>Имя конференции</h3>'));
        singleQuestions.append($(' <input class="single-chart-name" type="text" value="' + item.name + '">'));


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

        surveys.on('change', function () {
            $.ajax({
                url: "/MonkeyStatistics/api/questionsBySurveyId?id=" + $(this).find('option:selected').val(),
                dataType: "json",
                success: function (questionsData) {
                    question.empty();
                    for (var i = 0; i < questionsData.length; i++) {
                        var t = questionsData[i];
                        question.append('<option value="' + t.id + '">' + t.name + '</option>');
                    }

                }
            });
        });


        singleQuestions.append($('<h3>Вопрос</h3>'));
        singleQuestions.append(question);
        singleQuestions.append(createQuestionsCheckboxes(item.questionOptions));

        div.append(singleQuestions);
    });
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
    let buttons = createCommonQuestions();
    buttons.find('.save').on('click', saveU);
    div.append(buttons);

    let chartDiv = $('<div class="chart"></div>');
    div.append($('<h3>Предпросмотр</h3>'));
    div.append(chartDiv);
    drawChart(chartDiv, id);

    buttons.append($('<button class="reDrawCG">Перерисовать</button>'))
    buttons.find('.reDrawCG').on('click', reDrawU);
}




function reDrawU(){
    let editArea = $(this).closest('.edit-area');
    let data = collectUData(editArea);
    drawChartByData(editArea.find('.chart'), data);
}