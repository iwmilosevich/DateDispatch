package com.ivan.repository;

import com.ivan.domain.Event;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository extends InMemoryRepository<Event> {

    protected void updateIfExists(Event original, Event updated) {
        original.setName(updated.getName());
        original.setDescription(updated.getDescription());
    }
}
