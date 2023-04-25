package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;


import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.UserMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    //    Get all users
    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.loadAllUsers());
    }

    //Get a specific user and their user details
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable(value = "id") Long id){
        try {
            return ResponseEntity.ok(userService.findUserById(id));
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //CreateUpdate a user and their user details
    @PostMapping
    public ResponseEntity<UserDTO> saveNewUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveNewUser(userDTO));
    }

    //delete a user and their details
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUserAndTheirDetails( @PathVariable(value = "id") Long userId) throws ChangeSetPersister.NotFoundException {
        userService.deleteUser(userId);
        return ResponseEntity.status(200).build();
    }
    //Get all users and their user details who have booked on a specific flight
    @GetMapping("/users/flight/{flightId}")
    public ResponseEntity<List<UserDTO>> getUsersByFlight(@PathVariable("flightId") Long flightId) {
       return ResponseEntity.ok(userService.loadUsersByFlightId(flightId));

    }



}
