package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {

    List<UserDTO> loadAllUsers();
    void deleteUser(Long userId) throws ChangeSetPersister.NotFoundException;
    UserDTO findUserById(Long id) throws ChangeSetPersister.NotFoundException;
    UserDTO saveNewUser(User user);
    List<UserDTO> loadUsersByFlightId(Long flightId);

}
