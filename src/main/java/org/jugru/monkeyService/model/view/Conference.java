package org.jugru.monkeyService.model.view;

public class Conference {

    private String name;
    private long id;

    public Conference() {
    }

    public Conference(String name, long id) {
        this.name = name;
        this.id = id;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
