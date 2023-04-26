package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.FlightDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<FlightDTO> loadAllFlights();
    void deleteFlight(Long id);
    FlightDTO findFlightById(Long id);
    FlightDTO saveNewFlight(Flight flight);
    FlightDTO findByOrigin(String origin);
    List<FlightDTO> findFlightsByDateAndOrigin(Date departureDate, String origin);

}