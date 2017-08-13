package org.jugru.monkeyService.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Row {

    @Id
    private long id;
    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "text")
    private String text;
    @Column(name = "position")
    private Integer position;

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getVisible() {
        return visible;
    }

    public String getText() {
        return text;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Row other = (Row) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Row{" + "id=" + id + ", visible=" + visible + ", text=" + text + ", position=" + position + '}';
    }

}
