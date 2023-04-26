package com.lhind.internship.springbootfirstprogram.SpringBootApp.repository;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Optional<Booking> findBookingById(Long id);
    List<Booking> findBookingByUserIdAndId(Long userId, Long bookingId);
}

