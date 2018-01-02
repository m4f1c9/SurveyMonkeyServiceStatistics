package org.jugru.monkeyStatistics.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class QuestionMetaInformation {

    @Id
    private Long id;

    @Column(name = "position")
    private Integer position;
    @Column(name = "family")
    private String family;
    @Column(name = "sub_type")
    private String subtype;
    @Column
    private Boolean visible;

    @Embedded
    @Column
    private AnswerMetaInformation answers;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column
    private Set<Heading> headings = new HashSet<>();

    @Deprecated //TODO удалить
    public String getHeadingAsString() {
        StringBuilder sb = new StringBuilder();
        headings.forEach(sb::append);
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Heading> getHeadings() {
        return headings;
    }

    public void setHeadings(Set<Heading> headings) {
        this.headings = headings;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public AnswerMetaInformation getAnswers() {
        return answers;
    }

    public void setAnswers(AnswerMetaInformation answers) {
        this.answers = answers;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final QuestionMetaInformation other = (QuestionMetaInformation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questions{" + "id=" + id + ", position=" + position + ", family=" + family + ", subtype=" + subtype + ", visible=" + visible + ", headings=" + headings + '}';
    }

}
