package org.jugru.monkeyStatistics.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Other {

    @Id
    private Long id;

    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "is_answer_choice")
    private Boolean is_answer_choice;
    @Column(name = "apply_all_rows")
    private Boolean apply_all_rows;
    @Column(name = "text")
    private String text;
    @Column(name = "position")
    private Integer position;
    @Column(name = "num_chars")
    private Integer num_chars;
    @Column(name = "error_text")
    private String error_text;
    @Column(name = "num_lines")
    private Integer num_lines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getIs_answer_choice() {
        return is_answer_choice;
    }

    public void setIs_answer_choice(Boolean is_answer_choice) {
        this.is_answer_choice = is_answer_choice;
    }

    public Boolean getApply_all_rows() {
        return apply_all_rows;
    }

    public void setApply_all_rows(Boolean apply_all_rows) {
        this.apply_all_rows = apply_all_rows;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getNum_chars() {
        return num_chars;
    }

    public void setNum_chars(Integer num_chars) {
        this.num_chars = num_chars;
    }

    public String getError_text() {
        return error_text;
    }

    public void setError_text(String error_text) {
        this.error_text = error_text;
    }

    public Integer getNum_lines() {
        return num_lines;
    }

    public void setNum_lines(Integer num_lines) {
        this.num_lines = num_lines;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Other other = (Other) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Other{" + "id=" + id + ", visible=" + visible + ", is_answer_choice=" + is_answer_choice + ", apply_all_rows=" + apply_all_rows + ", text=" + text + ", position=" + position + ", num_chars=" + num_chars + ", error_text=" + error_text + ", num_lines=" + num_lines + '}';
    }

    
}
