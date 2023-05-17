package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.exception.UserNotFoundException;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;
    }

    //    Get all users
    @PreAuthorize(value = "hasAnyRole('MANAGER')")
    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.loadAllUsers());
    }

    //Get a specific user and their user details
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable(value = "id") Long id) throws UserNotFoundException{
            return ResponseEntity.ok(userService.findUserById(id));
    }

    //Create/Update a user and their user details
    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveNewUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveNewUser(user));
    }

    //delete a user and their details
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUserAndTheirDetails( @PathVariable(value = "id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(200).build();
    }
    //Get all users and their user details who have booked on a specific flight
    @GetMapping("/user/flight/{id}")
    public ResponseEntity<List<UserDTO>> getUsersByFlight(@PathVariable("id") Long flightId) {
       return ResponseEntity.ok(userService.loadUsersByFlightId(flightId));

    }



}
