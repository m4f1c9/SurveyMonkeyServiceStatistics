package org.jugru.monkeyStatistics.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Survey implements Comparable<Survey> {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "with_details")
    private boolean withDetails;
    @Column(name = "status")
    private String status;

    @OrderColumn
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<SurveyPage> pages = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Response> responses = new HashSet<>();

    // TODO разобратся с  FetchType.LAZY, т.к. мапа пустая то  нужна сессия при добавлении
    public void addNewResponses(Collection<Response> responses) {
        this.responses.addAll(responses);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isWithDetails() {
        return withDetails;
    }

    public void setWithDetails(boolean withDetails) {
        this.withDetails = withDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SurveyPage> getPages() {
        return pages;
    }

    public void setPages(List<SurveyPage> pages) {
        this.pages = pages;
    }

    public Set<Response> getResponses() {
        return responses;
    }

    public void setResponses(Set<Response> responses) {
        this.responses = responses;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Survey other = (Survey) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Survey o) {
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
        return "Survey{" + "id=" + id + ", title=" + title + ", nickname=" + nickname + ", withDetails=" + withDetails + ", status=" + status + '}';
    }

}
