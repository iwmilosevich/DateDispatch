package com.ivan.resource.assembler;

import com.ivan.domain.Event;
import com.ivan.resource.EventResource;
import com.ivan.resource.ResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class EventResourceAssembler extends ResourceAssembler<Event, EventResource> {

    @Autowired
    protected EntityLinks entityLinks;

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public EventResource toResource(Event event) {

        EventResource resource = new EventResource(event);

        final Link selfLink = entityLinks.linkToSingleResource(event);

        resource.add(selfLink.withSelfRel());
        resource.add(selfLink.withRel(UPDATE_REL));
        resource.add(selfLink.withRel(DELETE_REL));

        return resource;
    }
}