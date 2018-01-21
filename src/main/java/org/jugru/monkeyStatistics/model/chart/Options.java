package org.jugru.monkeyStatistics.model.chart;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Options {

    public final static int TITLE_HEIGHT = 40;
    public final static int HAXIS_HEIGHT = 20;
    public final static int SPACE_BETWEEN_GROUPS_OF_BARS = 35;
    public final static int BAR_HEIGHT = 30;

    private Integer height;
    private String title;


    public ChartArea chartArea;
    public Legend legend = new Legend();
    public Annotations annotations = new Annotations();
    public HAxis hAxis = new HAxis();
    public VAxis vAxis = new VAxis();
    public TextStyle titleTextStyle = new TextStyle(20);
    public Bar bar;
    public String theme = "material";

    public List<String> colors;

    /**
     * для несгруппированного графика
     */
    public static Options create(ChartOptions chartOptions, String title, int choices) {
        Options options = new Options(title);
        if (chartOptions.isUseGradient()) {
            options.addGradient(choices);
        }
        options.bar = options.new Bar();
        options.chartArea = options.new ChartArea();
        options.bar.groupWidth = BAR_HEIGHT * choices;
        options.chartArea.height = choices * BAR_HEIGHT + SPACE_BETWEEN_GROUPS_OF_BARS;
        options.height = options.chartArea.height + TITLE_HEIGHT + HAXIS_HEIGHT;
        if ("".equals(title)) {
            options.height -= TITLE_HEIGHT;
            options.chartArea.top = 0;
        }
        options.hAxis.setMaxValue(0);
        return options;
    }


    public static Options create(GroupedByChoiceChart groupedByChoiceChart, int choices, int questions) {
        Options options = new Options(groupedByChoiceChart.getChartName());
        if (groupedByChoiceChart.getChartOptions().isUseGradient()) {
            options.addGradient(choices);
        }
        options.bar = options.new Bar();
        options.chartArea = options.new ChartArea();
        options.bar.groupWidth = BAR_HEIGHT * questions;
        options.chartArea.height = choices * questions * BAR_HEIGHT + SPACE_BETWEEN_GROUPS_OF_BARS * choices;

        options.height = options.chartArea.height + TITLE_HEIGHT + HAXIS_HEIGHT;
        return options;
    }

    public static Options create(CrossGroupingChart сrossGroupingChart, int firstChoices, int secondChoices) {
        Options options = new Options(сrossGroupingChart.getSecondQuestionName());
        if (сrossGroupingChart.getChartOptions().isUseGradient()) {
            options.addGradient(secondChoices);
        }
        options.bar = options.new Bar();
        options.chartArea = options.new ChartArea();
        options.bar.groupWidth = BAR_HEIGHT * secondChoices;
        options.chartArea.height = firstChoices * secondChoices * BAR_HEIGHT + SPACE_BETWEEN_GROUPS_OF_BARS * firstChoices;

        options.height = options.chartArea.height + TITLE_HEIGHT + HAXIS_HEIGHT;
        return options;
    }


    public Options(String title) {
        this.title = title;
    }


    private void addGradient(int choicesCount) {
        if (choicesCount <= 8) {
            this.colors = new LinkedList<>(Arrays.asList("#C94B4B", "#BB8543", "#A2AD3B", "#5AA034", "#2E9241",
                    "#27856D", "#225E77", "#1C296A", "#32175C", "#4A124F"));
        } else {
            this.colors = new LinkedList<>(Arrays.asList("#C94B4B", "#C06E46", "#B88F41", "#B0AF3D", "#85A838", "#5AA034", "#339830", "#2C904A",
                    "#298764", "#257F7C", "#225E77", "#1E3D6F", "#1B1F67", "#2C185F", "#3D1557", "#4A124F"));
        }
    }


    public HAxis gethAxis() {
        return hAxis;
    }

    public void sethAxis(HAxis hAxis) {
        this.hAxis = hAxis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    public class ChartArea {

        public String width = "70%";
        public int height = 0;
        public String left = "15%";
        public int top = TITLE_HEIGHT;

    }

    public class Legend {

        public TextStyle textStyle = new TextStyle(15);
    }

    public class TextStyle {

        public int fontSize;
        public String color = "black";

        public TextStyle() {

        }

        public TextStyle(int fontSize) {
            this.fontSize = fontSize;
        }

    }

    public class Annotations {

        public boolean alwaysOutside = false;
        public TextStyle textStyle = new TextStyle(17);
        public String style = "point";
    }

    public class HAxis {

        //  public String textPosition = "none";
        public TextStyle textStyle = new TextStyle(14);
        public Integer maxValue;

        public TextStyle getTextStyle() {
            return textStyle;
        }

        public void setTextStyle(TextStyle textStyle) {
            this.textStyle = textStyle;
        }

        public Integer getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(Integer maxValue) {
            this.maxValue = maxValue;
        }
    }

    public class VAxis {

        //  public String viewWindowMode = "maximized";
        public TextStyle textStyle = new TextStyle(14);

    }


    public class Bar {

        //  public String viewWindowMode = "maximized";
        public int groupWidth;

    }

}
