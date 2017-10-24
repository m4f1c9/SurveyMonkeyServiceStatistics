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

    }
}
