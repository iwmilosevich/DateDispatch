package com.ivan.domain;

import java.util.Date;

public class Event implements Identifiable
{
    private Long id;
    private String name;
    private String description;
    private Date date;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
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

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}