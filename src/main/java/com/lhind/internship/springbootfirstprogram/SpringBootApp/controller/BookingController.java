package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.BookingDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //Delete a booking
    @RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
    public void deleteBooking(@PathVariable(value = "id") Long id){
        bookingService.deleteBooking(id);
    }


    //    Get all bookings ordered by booking date
    //Se di nqs eshte e sakte apo jo
    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings(){
        return ResponseEntity.ok(bookingService.loadAllBookings());
    }

    // Get all booking of a user
    @GetMapping("/user/{id}")
    public ResponseEntity<List<BookingDTO>> getAllBookingsForUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(bookingService.showAllBookings(id));
    }

    // Get all bookings on a flight
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<BookingDTO>> getAllBookingsOnFlight(@PathVariable(value = "flightId") Long flightId) {
        return ResponseEntity.ok(bookingService.showAllBookings(flightId));
    }

    // Get a specific booking for a specific user
    @GetMapping("{userId}/{bookingId}")
    public List<BookingDTO> getBookingForUser(@PathVariable(value = "userId") Long userId, @PathVariable(value = "bookingId") Long bookingId) {
        return bookingService.findBookingByIdForUser(userId, bookingId);
    }

    // Create/Update a booking for a user
    @PostMapping("/{userId}")
    public BookingDTO createBookingForUser(@PathVariable(value = "userId") Long userId, @RequestBody BookingDTO bookingDTO) {
        return bookingService.saveNewBookingForUser(userId, bookingDTO);
    }

}
