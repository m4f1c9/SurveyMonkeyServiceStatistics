package org.jugru.monkeyService.model;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Questions {

    @Id
    private long id;

//TODO вресенно пока все не заработает (не уверен в правильности маппинга)
//    @ElementCollection
    @Transient
    Set<Map<String, String>> headings;

    @Column(name = "position")
    private Integer position;

    @Column(name = "family")
    private String family;
    @Column(name = "sub_type")
    private String subtype;

    @Column(name = "with_details")
    private Boolean visible;

    @OneToOne(cascade = CascadeType.ALL)
    Answers answers;

    public long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public String getFamily() {
        return family;
    }

    public String getSubtype() {
        return subtype;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setSubtype(String subType) {
        this.subtype = subType;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Set<Map<String, String>> getHeadings() {
        return headings;
    }

    public void setHeadings(Set<Map<String, String>> headings) {
        this.headings = headings;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
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
        final Questions other = (Questions) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", headings=" + headings + ", position=" + position + ", family=" + family + ", subtype=" + subtype + ", visible=" + visible + ", answers=" + answers + '}';
    }

}
