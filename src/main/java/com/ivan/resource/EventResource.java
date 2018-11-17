package com.ivan.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan.domain.Event;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

public class EventResource extends ResourceSupport
{

    private final Long id;
    private final String name;
    private final String description;
    private final Date date;

    public EventResource(Event event) {
        id = event.getId();
        name = event.getName();
        description = event.getDescription();
        date = event.getDate();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public Date getDate() { return date; }
}