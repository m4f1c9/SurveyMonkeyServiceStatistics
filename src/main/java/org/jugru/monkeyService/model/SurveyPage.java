package org.jugru.monkeyService.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SurveyPage {

    @Id
    private long id;
    @Column(name = "position")
    private Integer position;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;

    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Questions> questions;

    public long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Questions> questions) {
        this.questions = questions;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        return "SurveyPage{" + "Id=" + id + ", position=" + position + ", description=" + description + ", title=" + title + '}';
    }

}
