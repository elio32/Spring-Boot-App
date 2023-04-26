package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.FlightMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.FlightDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Flight;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.FlightRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightDTO> loadAllFlights() {
        return flightRepository.findAll().stream().map(flightMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);

    }

    @Override
    public FlightDTO findFlightById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Booking with Id : " + id + " does not exist "));
        return flightMapper.toDto(flight);

    }

    @Override
    public FlightDTO saveNewFlight(Flight flight) {
        flight = flightRepository.save(flight);
        return flightMapper.toDto(flight);

    }

    @Override
    public FlightDTO findByOrigin(String origin) {
        return flightRepository.findByOrigin(origin);
    }
    @Override
    public List<FlightDTO> findFlightsByDateAndOrigin(Date departureDate, String origin) {
        List<Flight> flights = flightRepository.findByDepartureDateAndOrigin(departureDate, origin);
        return flights.stream().map(flightMapper::toDto).collect(Collectors.toList());
    }
}