package org.jugru.monkeyStatistics.model.util;

import java.util.Set;
import org.jugru.monkeyStatistics.model.Survey;

public class ListOfSurveys {

    private int per_page;
    private int total;
    private int page;
    private Set<Survey> data;

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Set<Survey> getData() {
        return data;
    }

    public void setData(Set<Survey> data) {
        this.data = data;
    }

    public Set<Survey> getSurveys() {
        return data;
    }

    @Override
    public String toString() {
        return "ListOfSurveys{" + "per_page=" + per_page + ", total=" + total + ", page=" + page + ", data=" + data + '}';
    }

}
