package com.gbc.eventbooking.BookingService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "room-service", url = "http://localhost:8085/rooms")
public interface RoomServiceClient {

    @GetMapping("/{id}/availability")
    Boolean isRoomAvailable(@PathVariable("id") Long roomId);
}
