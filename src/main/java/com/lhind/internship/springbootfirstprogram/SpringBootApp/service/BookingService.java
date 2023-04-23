package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;


import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BookingDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<BookingDTO> loadAllBookings();
    void deleteBooking(Long id);
    Optional<Booking> findBookingById(Long id);
    Booking saveNewBooking(Booking booking);

    List<BookingDTO> showAllBookings(Long id);

    BookingDTO saveNewBookingForUser(Long userId, BookingDTO bookingDTO);


    List<BookingDTO> findBookingByIdForUser(Long userId, Long bookingId);
}