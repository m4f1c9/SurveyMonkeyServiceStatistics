package org.jugru.monkeyService.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Embeddable
public class AnswerMetaInformation {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Choice> choices = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Other other;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Row> rows = new ArrayList<>();

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Row> getRows() {
        return rows;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    public void setRows(List<Row> rows) {
        this.rows.clear();
        this.rows.addAll(rows);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.choices);
        hash = 23 * hash + Objects.hashCode(this.other);
        hash = 23 * hash + Objects.hashCode(this.rows);
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
        final AnswerMetaInformation other = (AnswerMetaInformation) obj;
        if (!Objects.equals(this.choices, other.choices)) {
            return false;
        }
        if (!Objects.equals(this.other, other.other)) {
            return false;
        }
        if (!Objects.equals(this.rows, other.rows)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Answers{" + "choices=" + choices + ", other=" + other + ", rows=" + rows + '}';
    }

}
