package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.BookingMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BookingDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.BookingRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;


    @Override
    public List<BookingDTO> loadAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);

    }

    @Override
    public Optional<Booking> findBookingById(Long id) {
        if (bookingRepository.findById(id) == null)
            throw new IllegalArgumentException("Booking with Id : " + id + " does not exist ");
        return Optional.of(bookingRepository.findBookingById(id));

    }

    @Override
    public Booking saveNewBooking(Booking booking) {
        return bookingRepository.save(booking);

    }

    @Override
    public List<BookingDTO> showAllBookings(Long id) {
        return bookingRepository.findById(id).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public BookingDTO saveNewBookingForUser(Long userId, BookingDTO bookingDTO) {
        return bookingRepository.save(userId,bookingDTO);
    }

    @Override
    public List<BookingDTO> findBookingByIdForUser(Long userId, Long bookingId) {
        return bookingRepository.findBookingByIdForUser(userId,bookingId);
    }
}
