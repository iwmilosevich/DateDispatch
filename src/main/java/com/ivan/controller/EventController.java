package com.ivan.controller;

import com.ivan.domain.Event;
import com.ivan.domain.Event;
import com.ivan.repository.EventRepository;
import com.ivan.resource.EventResource;
import com.ivan.resource.EventResourceAssembler;
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
@ExposesResourceFor(Event.class)
@RequestMapping(value = "/event", produces = "application/json")
public class EventController {

    @Autowired
    private EventRepository repository;

    @Autowired
    private EventResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<EventResource>> findAllEvents() {
        List<Event> events = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(events), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<EventResource> createEvent(@RequestBody Event event) {
        Event createdEvent = repository.create(event);
        return new ResponseEntity<>(assembler.toResource(createdEvent), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EventResource> findEventById(@PathVariable Long id) {
        Optional<Event> event = repository.findById(id);

        if (event.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(event.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<EventResource> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        boolean wasUpdated = repository.update(id, updatedEvent);

        if (wasUpdated) {
            return findEventById(id);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}