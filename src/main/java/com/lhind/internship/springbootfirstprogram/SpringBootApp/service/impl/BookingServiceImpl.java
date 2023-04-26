package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.BookingMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BookingDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.BookingRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.UserRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final UserRepository userRepository;


    @Override
    public List<BookingDTO> loadAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);

    }

    @Override
    public BookingDTO findBookingById(Long id) { // kte e kishe optional

        Booking booking = bookingRepository.findBookingById(id).orElseThrow(() -> new IllegalArgumentException("Booking with Id : " + id + " does not exist "));
        return bookingMapper.toDto(booking);

    }

    @Override
    public BookingDTO saveNewBooking(Booking booking) {
        return bookingMapper.toDto(bookingRepository.save(booking));

    }

    @Override
    public List<BookingDTO> showAllBookings(Long id) {
        return bookingRepository.findById(id).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public BookingDTO saveNewBookingForUser(Long userId, Booking booking) {
        User user = userRepository.findById(userId).orElse(null);
        booking.setUser(user);
        booking = bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    @Override
    public List<BookingDTO> findBookingByUserIdAndId(Long userId, Long bookingId) {
        List<Booking> bookingList = bookingRepository.findBookingByUserIdAndId(userId,bookingId);
        List<BookingDTO> bookingDTOList = new ArrayList<BookingDTO>();
        for (Booking book: bookingList) {
            bookingDTOList.add(bookingMapper.toDto(book));
        }
        return bookingDTOList;
    }
}
