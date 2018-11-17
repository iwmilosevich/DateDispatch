package com.ivan.controller;

import com.ivan.domain.Location;
import com.ivan.repository.LocationRepository;
import com.ivan.resource.LocationResource;
import com.ivan.resource.assembler.LocationResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Location.class)
@RequestMapping(value = "/location", produces = "application/json")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private LocationResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<LocationResource>> findAllLocations() {
        List<Location> locations = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(locations), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<LocationResource> createLocation(@RequestBody Location location) {
        Location createdLocation = repository.create(location);
        return new ResponseEntity<>(assembler.toResource(createdLocation), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LocationResource> findLocationById(@PathVariable Long id) {
        Optional<Location> location = repository.findById(id);

        if (location.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(location.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<LocationResource> updateLocation(@PathVariable Long id, @RequestBody Location updatedLocation) {
        boolean wasUpdated = repository.update(id, updatedLocation);

        if (wasUpdated) {
            return findLocationById(id);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}