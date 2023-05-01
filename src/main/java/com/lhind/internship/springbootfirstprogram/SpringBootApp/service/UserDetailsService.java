package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDetailsDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserDetailsService {
    List<UserDetailsDTO> loadAllUsersDetails();
    void deleteUserDetails(UserDetails userDetails);
    UserDetailsDTO findUserDetailsById(Long id) throws ChangeSetPersister.NotFoundException;
    UserDetailsDTO saveNewUserDetails(UserDetails userDetails);
}