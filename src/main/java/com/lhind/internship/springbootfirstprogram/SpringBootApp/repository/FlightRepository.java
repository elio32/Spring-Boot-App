package com.lhind.internship.springbootfirstprogram.SpringBootApp.repository;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.FlightDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    FlightDTO findByOrigin(String origin);

    void delete(Long id);
    List<Flight> findByDepartureDateAndOrigin(Date departureDate, String origin);

    FlightDTO saveFlight(FlightDTO flightDTO);
}