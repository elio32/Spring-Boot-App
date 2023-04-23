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
import java.util.Optional;
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
        flightRepository.delete(id);

    }

    @Override
    public Optional<Flight> findFlightById(Long id) {
        if (flightRepository.findById(id) == null)
            throw new IllegalArgumentException("Flight with Id : " + id + " does not exist ");
        return Optional.of(flightRepository.findById(id).get());

    }

    @Override
    public FlightDTO saveNewFlight(FlightDTO flightDTO) {
        return flightRepository.saveFlight(flightDTO);

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