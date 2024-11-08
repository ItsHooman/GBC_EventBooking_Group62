package com.gbc.eventbooking.EventService.repository;

import com.gbc.eventbooking.EventService.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    // Custom queries can be added here if needed
}
