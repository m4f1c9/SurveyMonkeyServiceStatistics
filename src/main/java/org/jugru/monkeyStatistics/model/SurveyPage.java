package org.jugru.monkeyStatistics.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class SurveyPage {

    @Id
    private Long id;

    @Column(name = "position")
    private Integer position;
    @Column(name = "description", length=2047)
    private String description;
    @Column(name = "title")
    private String title;

    @OrderColumn
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionMetaInformation> questions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionMetaInformation> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionMetaInformation> questions) {
        this.questions = questions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final SurveyPage other = (SurveyPage) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SurveyPage{" + "id=" + id + ", position=" + position + ", description=" + description + ", title=" + title + '}';
    }

}
