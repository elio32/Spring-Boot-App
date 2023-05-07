package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;


import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BookingDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;

import java.util.List;

public interface BookingService {
    List<BookingDTO> loadAllBookings();
    void deleteBooking(Long id);
    BookingDTO findBookingById(Long id);
    BookingDTO saveNewBooking(Booking booking);

    List<BookingDTO> showAllBookings(Long id);

    BookingDTO saveNewBookingForUser(Long userId, Booking booking);

    List<BookingDTO> findBookingByUserIdAndId(Long userId, Long bookingId);
}