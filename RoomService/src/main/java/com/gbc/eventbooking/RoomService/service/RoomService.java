package com.gbc.eventbooking.RoomService.service;

import com.gbc.eventbooking.RoomService.model.Room;
import com.gbc.eventbooking.RoomService.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailabilityTrue();
    }

    public Room updateRoomAvailability(Long roomId, boolean availability) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
        room.setAvailability(availability);
        return roomRepository.save(room);
    }
}

