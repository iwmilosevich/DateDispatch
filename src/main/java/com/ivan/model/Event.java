package com.ivan.model;

import java.util.concurrent.atomic.AtomicLong;

public class Event {
    private final long id;
    private final String name;
    private final String description;
    private static final AtomicLong counter = new AtomicLong(100);

    private Event(EventBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    public Event(){
        Event event = new EventBuilder().id().build();
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }

    public Event(long id, String name, String description) {
        Event event = new EventBuilder()
                .id()
                .name(name)
                .description(description)
                .build();
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }

    public long getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString(){
        return "ID: " + id
                + " Name: " + name + "\n"
                + "Description: " + description;
    }

    public static class EventBuilder {
        private long id;
        private String name = "";
        private String description = "";

        public EventBuilder id(){
            this.id = Event.counter.getAndIncrement();
            return this;
        }

        public EventBuilder id(long id){
            this.id = id;
            return this;
        }

        public EventBuilder name(String name){
            this.name = name;
            return this;
        }

        public EventBuilder description(String description){
            this.description = description;
            return this;
        }

        public Event build(){
            return new Event(this);
        }
    }
}