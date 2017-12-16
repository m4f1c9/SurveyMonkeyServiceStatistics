function createCGEditArea(id, div, chartsData) {

    div.append($(' <input class="chart-id" hidden type="text" value="' + id + '">'));
    let firstQuestionDiv = $('<div class="first-question-div"></div>');
    let secondQuestionDiv = $('<div class="second-question-div"></div>');

    let firstQuestion = $('<select class="first-question-select"></select>');
    let secondQuestion = $('<select class="second-question-select"></select>');


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
    let buttons = createCommonQuestions();
    buttons.find('.save').on('click', saveCG);

    div.append(buttons);

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


    let chartDiv = $('<div class="chart"></div>');
    div.append($('<h3>Предпросмотр</h3>'));
    div.append(chartDiv);
    drawChartById(chartDiv, id);

    buttons.append($('<button class="reDrawCG">Перерисовать</button>'))
   buttons.find('.reDrawCG').on('click', reDrawCG);

}

function reDrawCG(){
    let editArea = $(this).closest('.edit-area');
    let data = collectCGData(editArea);
    drawChartByData(editArea.find('.chart'), data);
}


function saveCG() {
    let editArea = $(this).closest('.edit-area');

    let answer = collectCGData(editArea);

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



function collectCGData(editArea) {



    let answer = {};
    answer.id = editArea.find('.chart-id').val();
    answer.chartName = editArea.find('.chart-name').val();
    answer.firstQuestionMetaInformationId = editArea.find('.first-question-select').find('option:selected').val();
    answer.secondQuestionMetaInformationId = editArea.find('.second-question-select').find('option:selected').val();
    answer.hideLastChoiceInFirstQuestion = false; //TODO
    answer.hideLastChoiceInSecondQuestion = false; //TODO
    answer.type = "CrossGroupingChart";

    answer.firstQuestionOptions = {};
    answer.secondQuestionOptions = {};
    answer.chartOptions = {};

    answer.firstQuestionOptions.withCustomChoice = editArea.find('.first-question-div').find('.custom-choice').is(':checked');
    answer.firstQuestionOptions.withNoChoice = editArea.find('.first-question-div').find('.no-choice').is(':checked');

    answer.secondQuestionOptions.withCustomChoice = editArea.find('.second-question-div').find('.custom-choice').is(':checked');
    answer.secondQuestionOptions.withNoChoice = editArea.find('.second-question-div').find('.no-choice').is(':checked');


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

    return answer;


}