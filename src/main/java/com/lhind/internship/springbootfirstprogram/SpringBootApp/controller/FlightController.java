package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.FlightDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Flight;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/flight")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Get all flights
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        return ResponseEntity.ok(flightService.loadAllFlights());
    }

    //Get info for a specific flight
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<FlightDTO> findFlightById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(flightService.findFlightById(id));
    }

    //Update/create a flight
    @PostMapping
    public ResponseEntity<FlightDTO> saveNewFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.saveNewFlight(flight));
    }

    //Delete a flight
    @DeleteMapping(path = "/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId){
        flightService.deleteFlight(flightId);
        return ResponseEntity.status(200).build();
    }
    //Get all flights departing on a specific date from a specific airport
    @GetMapping(path = "{origin}/{departure_date}")
    public ResponseEntity<List<FlightDTO>> getFlightsByOriginAndDepartureDate(@PathVariable(value = "departure_date") Date departureDate, @PathVariable(value = "origin") String origin) {
        return ResponseEntity.ok(flightService.findFlightsByDateAndOrigin(departureDate,origin));
    }
}
