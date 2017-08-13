package org.jugru.monkeyService.model.util;

import java.util.Set;
import org.jugru.monkeyService.model.Response;

public class ListOfResponses {

    private int per_page;
    private int total;
    private int page;
    private Set<Response> data;

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setData(Set<Response> data) {
        this.data = data;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public Set<Response> getData() {
        return data;
    }

}
