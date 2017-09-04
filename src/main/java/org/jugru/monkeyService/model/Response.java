package org.jugru.monkeyService.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResponsePage> pages = new HashSet<>();

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

    public Set<ResponsePage> getPages() {
        return pages;
    }

    public void setPages(Set<ResponsePage> pages) {
        this.pages = pages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Response other = (Response) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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