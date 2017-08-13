package org.jugru.monkeyService.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Choice> choices;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Other other;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Row> rows;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public Other getOther() {
        return other;
    }

    public Set<Row> getRows() {
        return rows;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    public void setRows(Set<Row> rows) {
        this.rows = rows;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.choices);
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
        final Answers other = (Answers) obj;
        if (!Objects.equals(this.choices, other.choices)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Answer{" + "choices=" + choices + ", other=" + other + ", rows=" + rows + '}';
    }

}
