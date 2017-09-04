package org.jugru.monkeyService.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "choice_id")
    private Long choice_id;
    @Column(name = "row_id")
    private Long row_id;
    @Column(name = "text", length = 3000)
    private String text;
    @Column(name = "other_id")
    private Long other_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(Long choice_id) {
        this.choice_id = choice_id;
    }

    public Long getRow_id() {
        return row_id;
    }

    public void setRow_id(Long row_id) {
        this.row_id = row_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getOther_id() {
        return other_id;
    }

    public void setOther_id(Long other_id) {
        this.other_id = other_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.choice_id);
        hash = 59 * hash + Objects.hashCode(this.row_id);
        hash = 59 * hash + Objects.hashCode(this.text);
        hash = 59 * hash + Objects.hashCode(this.other_id);
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
        final Answer other = (Answer) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.choice_id, other.choice_id)) {
            return false;
        }
        if (!Objects.equals(this.row_id, other.row_id)) {
            return false;
        }
        if (!Objects.equals(this.other_id, other.other_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Answer{" + "id=" + id + ", choice_id=" + choice_id + ", row_id=" + row_id + ", text=" + text + ", other_id=" + other_id + '}';
    }

}
