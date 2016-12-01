package com.mycompany.api;

import java.util.Date;

public class Event {
    private long id;
    private String name;
    private String description;
    private String location;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void updateExceptId(Event event) {
        this.name = event.name;
        this.description = event.description;
        this.location = event.getLocation();
        this.date = event.date;
    }
}