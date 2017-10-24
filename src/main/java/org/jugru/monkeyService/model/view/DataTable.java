package org.jugru.monkeyService.model.view;

import java.util.LinkedList;
import java.util.List;

public class DataTable {

    private List<Column> cols = new LinkedList<>(); // list of columns
    private List<Row> rows = new LinkedList<>(); // list of rows

    /**
     * Первый вызов добавляет общую подпись ко всем колонкам, последующие
     * индивидуально к колонкам начания я первой.
     *
     * @param type "string" или "number"
     * @param id используется для редактирования таблицы, может быть null
     * @param label текст подписи
     */
    public void addColumn(String type, String id, String label) {
        cols.add(new DataTable.Column(type, id, label));
    }

    /**
     * Подпись и данные к рядом
     *
     * @param cells первый объект - подпись (String) последующие -
     * значения(Integer или Double) в порядке, соответствующем порядку
     * добавления колонок
     */
    public void addRow(List<?> cells) {
        DataTable.Row row = new Row();
        cells.forEach((t) -> {
            row.c.add(new Row.Cell(t));
        });
    }

    private static class Column {

        public Column(String type, String id, String label) {
            this.type = type;
            this.id = id;
            this.label = label;
        }

        private String type; // type of column
        private String id; // id of column
        private String label; // label of column

    }

    private static class Row {

        private List<Cell> c = new LinkedList<>(); // list of cells

        private static class Cell {

            public Cell(Object v) {
                this.v = v;
            }

            private Object v; // value of cell

        }
    }

}
