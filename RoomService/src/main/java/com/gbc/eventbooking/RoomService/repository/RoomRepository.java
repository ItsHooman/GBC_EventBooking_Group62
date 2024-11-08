package com.gbc.eventbooking.RoomService.repository;

import com.gbc.eventbooking.RoomService.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // Custom query to find available rooms
    List<Room> findByAvailabilityTrue();
}
