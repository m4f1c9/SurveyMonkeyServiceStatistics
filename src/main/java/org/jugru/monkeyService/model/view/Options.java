package org.jugru.monkeyService.model.view;

public class Options {

    private Chart chart;
    private Integer height;
    private String bars;

    /**
     *
     * @param height в пикселях
     * @param bars horizontal или vertical. Если null: vertical
     * @param title
     * @param subtitle
     */
    public Options(Integer height, String bars, String title, String subtitle) {
        this.height = height;
        this.bars = bars;
        this.chart = new Chart(title, subtitle);
    }

    private static class Chart {

        String title;
        String subtitle;

        public Chart(String title, String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }
        
        

    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
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
