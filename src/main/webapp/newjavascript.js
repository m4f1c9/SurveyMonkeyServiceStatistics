google.load("visualization", "1", {packages: ["corechart"]});
google.setOnLoadCallback(drawChart);
function drawChart() {



    function drawChart() {
        var jsonData = $.ajax({
            url: "http://localhost:8080/MonkeyStatistics/123",
            dataType: "json",
            async: false
        }).responseText;

        // Create our data table out of JSON data loaded from server.
        var data = new google.visualization.DataTable(jsonData);

        var options = {
            title: 'Добыча нефти',
            hAxis: {title: 'Год'},
            vAxis: {title: 'Тыс. тонн'}
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }

}

