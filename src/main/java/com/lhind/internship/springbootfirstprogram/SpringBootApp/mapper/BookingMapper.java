package com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BookingDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;

public class BookingMapper extends AbstractMapper<Booking, BookingDTO>{
    @Override
    public Booking toEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(booking.getId());
        booking.setBookingDate(booking.getBookingDate());
        booking.setStatus(booking.getStatus());
        return booking;
    }

    @Override
    public BookingDTO toDto(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setStatus(booking.getStatus());
        return bookingDTO;
    }
}