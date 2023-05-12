package com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BookingDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.FlightDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BookingMapper extends AbstractMapper<Booking, BookingDTO>{

    private final FlightMapper flightMapper;
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
        List<FlightDTO> flightDTO = booking.getFlights().stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
        bookingDTO.setFlights(flightDTO);
        return bookingDTO;
    }
}