package com.gbc.eventbooking.BookingService.service;

import com.gbc.eventbooking.BookingService.model.Booking;
import com.gbc.eventbooking.BookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        // Validate that the room is available for the requested time
        List<Booking> overlappingBookings = bookingRepository.findByRoomIdAndEndTimeAfterAndStartTimeBefore(
                booking.getRoomId(), booking.getStartTime(), booking.getEndTime());

        if (!overlappingBookings.isEmpty()) {
            throw new IllegalArgumentException("Room is already booked for the specified time range.");
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(String id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
