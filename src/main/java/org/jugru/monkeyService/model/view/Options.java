package org.jugru.monkeyService.model.view;

public class Options {

    private Integer height;
    private String bars;
    private String title;


    
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
    
    

}
