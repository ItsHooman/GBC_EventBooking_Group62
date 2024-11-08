package com.gbc.eventbooking.RoomService.controller;

import com.gbc.eventbooking.RoomService.model.Room;
import com.gbc.eventbooking.RoomService.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @PutMapping("/{id}/availability")
    public Room updateRoomAvailability(@PathVariable Long id, @RequestParam boolean availability) {
        return roomService.updateRoomAvailability(id, availability);
    }
}
