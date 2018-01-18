function surveys() {
    $('.survey-button').on('click', showSurveys);
    $('.update-button').on('click', updateSurveys);
}

function showSurveys() {
    let type = $('.survey-select option:selected').val();
    let URL;
    if (type === "new") {
        URL = "/MonkeyStatistics/api/surveys/new";
    }
    else if (type === "all") {
        URL = "/MonkeyStatistics/api/surveys/all";
    }

    let workArea = $('.survey-table');
    $.ajax({
        url: URL,
        method: "POST",
        success: function (data) {
            data.reverse();
            let table = $('<table class="table"></table>');
            let header = $('<tr></tr>');
            header.append($('<td>Название опроса</td>'));
            header.append($('<td colspan="2">Опрос по конференции</td>'));
            table.append(header);
            for (let i = 0; i < data.length; i++) {
                let t = data[i];
                let tr = $('<tr></tr>');
                tr.append($('<td class="survey-id" hidden>' + t.id + '</td>'));
                tr.append($('<td>' + t.name + '</td>'));
                let radioButtonsName = "isConferenceSurvey" + i;
                let radioButton1 = $('<td></td>');
                let yesRadio = $('<INPUT TYPE="radio" NAME="' + radioButtonsName + '" VALUE="yes">');
                radioButton1.append(yesRadio);
                radioButton1.append('Да');
                let noRadio = $('<INPUT TYPE="radio" NAME="' + radioButtonsName + '" VALUE="no">');
                let radioButton2 = $('<td></td>');
                radioButton2.append(noRadio);
                radioButton2.append('Нет');
                if (t.conferenceSurvey) {
                    yesRadio.prop('checked', true);
                }
                else {
                    noRadio.prop('checked', true);
                }
                tr.append(radioButton1);
                tr.append(radioButton2);
                let button = $('<button>Применить</button>');
                button.on('click', sendSelectInfo);
                tr.append($('<td></td>').append(button));
                if(t.processed){
                    if(t.conferenceSurvey){
                        tr.addClass("table-primary");
                    }
                    else{
                        tr.addClass("table-dark");
                    }
                }
                table.append(tr);
            }
            workArea.empty();
            workArea.append(table);
        }
    });
}

function sendSelectInfo() {
    let radioButtonValue =  $(this).closest('tr').find("input:checked").val();
    let id = $(this).closest('tr').find('.survey-id').html();
    let isConferenceSurvey =  radioButtonValue === 'yes';
    $.ajax({
        context: this,
        url: "/MonkeyStatistics/api/surveys",
        data: "id=" + id + '&isConferenceSurvey=' + isConferenceSurvey,
        method: "POST",
        success: function () {
            if(isConferenceSurvey){
                $(this).closest('tr').removeClass("table-dark").addClass("table-primary");
            }
            else{
                $(this).closest('tr').removeClass("table-primary").addClass("table-dark");
            }
        }
    });
}

function updateSurveys() {
    $.ajax({
        context: this,
        url: "/MonkeyStatistics/api/update",
        method: "POST",
        success: function () {
        }
    });
}