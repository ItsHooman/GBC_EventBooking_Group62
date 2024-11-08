package com.gbc.eventbooking.BookingService.service;

import com.gbc.eventbooking.BookingService.client.RoomServiceClient;
import com.gbc.eventbooking.BookingService.model.Booking;
import com.gbc.eventbooking.BookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private RoomServiceClient roomServiceClient;

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        // Check room availability before booking
        Boolean isAvailable = roomServiceClient.isRoomAvailable(booking.getRoomId());
        if (isAvailable == null || !isAvailable) {
            throw new IllegalArgumentException("Room is not available for booking.");
        }
        return bookingRepository.save(booking);
    }
}
