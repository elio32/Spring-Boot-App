package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.FlightDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Flight;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<FlightDTO> loadAllFlights();
    void deleteFlight(Long id);
    Optional<Flight> findFlightById(Long id);
    FlightDTO saveNewFlight(FlightDTO flightDTO);
    FlightDTO findByOrigin(String origin);
    List<FlightDTO> findFlightsByDateAndOrigin(Date departureDate, String origin);

}