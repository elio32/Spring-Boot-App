package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.exception.UserNotFoundException;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> loadAllUsers();
    void deleteUser(Long userId);
    UserDTO findUserById(Long id) throws UserNotFoundException;
    UserDTO saveNewUser(User user);
    List<UserDTO> loadUsersByFlightId(Long flightId);

}
