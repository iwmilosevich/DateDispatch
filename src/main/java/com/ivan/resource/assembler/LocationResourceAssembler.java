package com.ivan.resource.assembler;

import com.ivan.domain.Location;
import com.ivan.resource.LocationResource;
import com.ivan.resource.ResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class LocationResourceAssembler extends ResourceAssembler<Location, LocationResource> {

    @Autowired
    protected EntityLinks entityLinks;

    private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";

    @Override
    public LocationResource toResource(Location location) {

        LocationResource resource = new LocationResource(location);

        final Link selfLink = entityLinks.linkToSingleResource(location);

        resource.add(selfLink.withSelfRel());
        resource.add(selfLink.withRel(UPDATE_REL));
        resource.add(selfLink.withRel(DELETE_REL));

        return resource;
    }
}