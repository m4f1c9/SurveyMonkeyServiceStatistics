package org.jugru.monkeyService.model.view;

public class Options {

    private Integer height;
    private String bars;
    private String title;

    public String theme = "material";
    public int fontSize = 25;
    public ChartArea chartArea = new ChartArea();
    public Legend legend = new Legend();
    public TextStyle titleTextStyle = new TextStyle(30);
    
    public Options(Integer height, String bars, String title) {
        this.height = height;
        this.bars = bars;
        this.title = title;
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
}
