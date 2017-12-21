package org.jugru.monkeyStatistics.model.chart;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class ChoiceGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String text;
    @OrderColumn
    @ElementCollection(fetch = FetchType.EAGER)
   // @LazyCollection(LazyCollectionOption.FALSE)
    private List<Long> choicesId = new ArrayList<>();

    public ChoiceGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addChoiceId(Long id) {
        choicesId.add(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> getChoicesId() {
        return choicesId;
    }

    public void setChoicesId(List<Long> ID) {
        this.choicesId = ID;
    }

}
