package com.lhind.internship.springbootfirstprogram.SpringBootApp.controller;


import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    Get all users
    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.loadAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable(value = "id") Long id){
        try {
            return ResponseEntity.ok(userService.findUserById(id));
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public UserDTO saveNewUser(@RequestBody UserDTO userDTO) {
        return userService.saveNewUser(userDTO);
    }



}
