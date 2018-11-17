package com.ivan.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan.domain.Location;
import org.springframework.hateoas.ResourceSupport;

import java.net.URL;

public class LocationResource extends ResourceSupport
{
    private final Long id;
    private final String name;
    private final String description;
    private final String address;
    private final String phone;
    private final String website;

    public LocationResource(Location location) {
        id = location.getId();
        name = location.getName();
        description = location.getDescription();
        address = location.getAddress();
        phone = location.getPhone();
        website = location.getWebsite();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public String getAddress() { return address; }

    public String getPhone() { return phone; }

    public String getWebsite() { return website; }
}