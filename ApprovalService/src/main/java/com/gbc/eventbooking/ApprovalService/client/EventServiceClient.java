package com.gbc.eventbooking.ApprovalService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "event-service", url = "http://localhost:8082/api/events")  // Replace with the actual EventService URL or service name if using Docker Compose
public interface EventServiceClient {

    @GetMapping("/{eventId}/exists")
    ResponseEntity<Boolean> eventExists(@PathVariable("eventId") String eventId);
}
