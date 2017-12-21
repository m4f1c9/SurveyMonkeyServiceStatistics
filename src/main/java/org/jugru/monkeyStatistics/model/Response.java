package org.jugru.monkeyStatistics.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Response implements Comparable<Response> {

    @Id
    private Long id;

    @Column(name = "total_time")
    private Integer total_time;
    @Column(name = "ip_address")
    private String ip_address;
    @Column(name = "response_status")
    private String response_status;
    @Column(name = "collection_mode")
    private String collection_mode;

    @OrderColumn
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResponsePage> pages = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal_time() {
        return total_time;
    }

    public void setTotal_time(Integer total_time) {
        this.total_time = total_time;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getResponse_status() {
        return response_status;
    }

    public void setResponse_status(String response_status) {
        this.response_status = response_status;
    }

    public String getCollection_mode() {
        return collection_mode;
    }

    public void setCollection_mode(String collection_mode) {
        this.collection_mode = collection_mode;
    }

    public List<ResponsePage> getPages() {
        return pages;
    }

    public void setPages(List<ResponsePage> pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        return id.equals(response.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public int compareTo(Response o) {
        if (Objects.equals(id, o.id)) {
            return 0;
        } else if (id > o.id) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Response{" + "id=" + id + ", total_time=" + total_time + ", ip_address=" + ip_address + ", response_status=" + response_status + ", collection_mode=" + collection_mode + '}';
    }

    
}
