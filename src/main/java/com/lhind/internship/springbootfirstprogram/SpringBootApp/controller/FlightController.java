package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.FlightDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.Flight;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    //Duhet te jet FlightDTO, por jep error
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Optional<ResponseEntity<Optional<Flight>>> findFlightById(@PathVariable(value = "id") Long id){
        return Optional.of(ResponseEntity.ok(flightService.findFlightById(id)));
//        try {
//            return Optional.of(ResponseEntity.ok(flightService.findFlightById(id)));
//        } catch (ChangeSetPersister.NotFoundException e) {
//            return Optional.ofNullable(ResponseEntity.notFound().build());
//        }
//    }
    }

    //Update/create a flight
    //duhet te jet flightDTO po me jep error
    @PostMapping
    public FlightDTO saveNewFlight(@RequestBody FlightDTO flightDTO) {
        return flightService.saveNewFlight(flightDTO);
    }

    //Delete a flight
    @DeleteMapping(path = "/{flightId}")
    public void deleteFlight( @PathVariable Long flightId){
        flightService.deleteFlight(flightId);
    }

    //?
    //Get all flights departing on a specific date from a specific airport
    @GetMapping(path = "{origin}/{departure_date}")
    public List<FlightDTO> getFlightsByOriginAndDepartureDate(@PathVariable(value = "departure_date") Date departureDate, @PathVariable(value = "origin") String origin) {
        return flightService.findFlightsByDateAndOrigin(departureDate,origin);
    }
}