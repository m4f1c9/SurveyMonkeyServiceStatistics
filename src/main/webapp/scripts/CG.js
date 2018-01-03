function createCGEditArea(id, div, chartsData) {

    div.append($(' <input class="chart-id" hidden type="text" value="' + id + '">'));
    let firstQuestionDiv = $('<div class="first-question-div"></div>');
    let secondQuestionDiv = $('<div class="second-question-div"></div>');

    let firstQuestion = $('<select style="width: 500px" class="first-question-select"></select>');
    let secondQuestion = $('<select style="width: 500px" class="second-question-select"></select>');


    let surveys = $('.surveys-select').clone();
    surveys.removeClass('surveys-select');
    surveys.addClass('surveys-select-chart');
    surveys.find('option[value=' + chartsData.surveyId + ']').attr('selected', 'selected');

    surveys.on('change', function () {
        $.ajax({
            url: "/MonkeyStatistics/api/questionsBySurveyId?id=" + $(this).find('option:selected').val(),
            dataType: "json",
            async:false, //TODO
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

        let chartName =  $(this).closest('.edit-area').find('.chart-name').val();
        if(chartName === '' || chartName == null) {
            $(this).closest('.edit-area').find('.chart-name').val($(this).find('option:selected').text());
        }
    });

    div.append($('<h3>Имя графика</h3>'));
    div.append($(' <input style="width: 600px" class="chart-name" type="text" value="' + chartsData.chartName + '">'));
    div.append($('<h3>Опрос</h3>'));
    div.append(surveys);
    div.append(firstQuestionDiv);
    firstQuestionDiv.append($('<h3>Первый вопрос</h3>'));
    let firstQuestionName = $('<input style="width: 600px" class="first-question-name" type="text" value="">');
    if( chartsData.firstQuestionName != null )firstQuestionName.val(chartsData.firstQuestionName);
    firstQuestionDiv.append($('<h3>Имя вопроса</h3>'));
    firstQuestionDiv.append(firstQuestionName);
    firstQuestionDiv.append($('<h3>Выбор вопроса</h3>'));
    firstQuestionDiv.append(firstQuestion);
    firstQuestionDiv.append(createQuestionsCheckboxes(chartsData.firstQuestionOptions));

    firstQuestionDiv.find('.custom-choice').attr("disabled", true);
    firstQuestionDiv.find('.no-choice').attr("disabled", true);

    div.append(secondQuestionDiv);
    secondQuestionDiv.append($('<h3>Второй вопрос</h3>'));
    let secondQuestionName = $('<input style="width: 600px" class="second-question-name" type="text" value="">');
    if( chartsData.secondQuestionName != null )secondQuestionName.val(chartsData.secondQuestionName);
    secondQuestionDiv.append($('<h3>Имя вопроса</h3>'));
    secondQuestionDiv.append(secondQuestionName);
    secondQuestionDiv.append($('<h3>Выбор вопроса</h3>'));
    secondQuestionDiv.append(secondQuestion);
    secondQuestionDiv.append(createQuestionsCheckboxes(chartsData.secondQuestionOptions));
    div.append(createChartCheckboxes(chartsData.chartOptions));
    let buttons = createCommonQuestions();
    buttons.find('.save').on('click', saveCG);

    div.append(buttons);



    $.ajax({
        url: "/MonkeyStatistics/api/questionsBySurveyId?id=" + surveys.find('option:selected').val(),
        dataType: "json",
        async:false, //TODO
        success: function (questionsData) {
            firstQuestion.empty();
            secondQuestion.empty();
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


    firstQuestion.on('change', function () {
        let name =  $(this).closest('div').find('input').val();
        if(name === '' || name == null) {
            $(this).closest('div').find('input').val($(this).find('option:selected').text());
        }
    });
    secondQuestion.on('change', function () {
        let name =  $(this).closest('div').find('input').val();
        if(name === '' || name == null) {
            $(this).closest('div').find('input').val($(this).find('option:selected').text());
        }
    });

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
            drawChartById(editArea.find('.chart'), answer.id);

        },

        error: function (inputData) {
        }
    });


}



function collectCGData(editArea) {



    let answer = {};
    answer.id = editArea.find('.chart-id').val();
    answer.chartName = editArea.find('.chart-name').val();
    answer.firstQuestionName = editArea.find('.first-question-name').val();
    answer.secondQuestionName = editArea.find('.second-question-name').val();
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