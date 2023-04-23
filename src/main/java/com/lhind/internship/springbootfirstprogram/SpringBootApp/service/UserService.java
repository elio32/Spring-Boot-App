package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> loadAllUsers();
    void deleteUser(User user);
    UserDTO findUserById(Long id) throws ChangeSetPersister.NotFoundException;
    UserDTO saveNewUser(UserDTO userDTO);
}
