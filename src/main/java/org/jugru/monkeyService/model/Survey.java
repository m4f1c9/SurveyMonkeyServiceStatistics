package org.jugru.monkeyService.model;

import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Survey implements Comparable<Survey> {

    @Id
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "with_details")
    private boolean withDetails;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<SurveyPage> pages;

    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Response> responseList = new TreeSet<Response>();

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isWithDetails() {
        return withDetails;
    }

    public String getStatus() {
        return status;
    }

    public Set<SurveyPage> getPages() {
        return pages;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setWithDetails(boolean withDetails) {
        this.withDetails = withDetails;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPages(Set<SurveyPage> pages) {
        this.pages = pages;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Survey other = (Survey) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Survey{" + "id=" + id + ", title=" + title + ", nickname=" + nickname + ", withDetails=" + withDetails + ", status=" + status + '}';
    }

    @Override
    public int compareTo(Survey o) {
        if (id == o.id) {
            return 0;
        } else if (id > o.id) {
            return 1;
        } else {
            return -1;
        }
    }

}
