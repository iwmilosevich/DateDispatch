package com.ivan.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan.domain.Event;
import org.springframework.hateoas.ResourceSupport;

public class EventResource extends ResourceSupport
{

    private final Long id;
    private final String name;
    private final String description;

    public EventResource(Event account) {
        id = account.getId();
        name = account.getName();
        description = account.getDescription();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}