package org.jugru.monkeyStatistics.model;

import javax.persistence.Embeddable;

@Embeddable
public class Required {
    private String text;
    private Integer amount;
    private String type;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
