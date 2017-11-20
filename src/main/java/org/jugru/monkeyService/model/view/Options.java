package org.jugru.monkeyService.model.view;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Options {

    private Integer height;
    private String bars;
    private String title;

    public String theme = "material";
//    public int fontSize = 25;
    public ChartArea chartArea = new ChartArea();
//    public Legend legend = new Legend();
//    public TextStyle titleTextStyle = new TextStyle(30);
    public List<String> colors;
    public Annotations annotations = new Annotations();
   //  public HAxis hAxis = new HAxis();

    public Options(Integer height, String bars, String title) {
        this(height, bars, title, false);
    }

    public Options(Integer height, String bars, String title, boolean withCustomColorsOfLegend) {
        this.height = height;
        this.bars = bars;
        this.title = title;
        if (withCustomColorsOfLegend) {
            this.colors = new LinkedList<>(Arrays.asList("#ffe0cc", "#ffc299", "#ffa366", "#ff8533", "#ff6600", "#cc5200", "#993d00", "#331400"));
        }

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

    public String getBars() {
        return bars;
    }

    public void setBars(String bars) {
        this.bars = bars;

    }

    public class ChartArea {

        public String width = "70%";
        public String height = "80%";
        public String left = "15%";
        public String top = "15%";

    }

    public class Legend {

        public TextStyle textStyle = new TextStyle(20);
    }

    public class TextStyle {

        public int fontSize;

        public TextStyle(int fontSize) {
            this.fontSize = fontSize;
        }

    }

    public class Annotations {

        public boolean alwaysOutside = false;
        //public TextStyle textStyle = new TextStyle(10);
        public String style = "point";
    }

    public class HAxis {

        public String textPosition = "none";
        //public TextStyle textStyle = new TextStyle(30);
       
    }
}
