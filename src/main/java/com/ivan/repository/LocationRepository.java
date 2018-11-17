package com.ivan.repository;

import com.ivan.domain.Location;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository extends InMemoryRepository<Location> {

    protected void updateIfExists(Location original, Location updated) {
        original.setName(updated.getName());
        original.setDescription(updated.getDescription());
        original.setPhone(updated.getPhone());
        original.setAddress(updated.getAddress());
        original.setWebsite(updated.getWebsite());
    }
}