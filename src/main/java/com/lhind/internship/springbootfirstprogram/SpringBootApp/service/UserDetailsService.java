package com.lhind.internship.springbootfirstprogram.SpringBootApp.service;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDetailsDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {
    List<UserDetailsDTO> loadAllUsersDetails();
    void deleteUserDetails(UserDetails userDetails);
    Optional<UserDetails> findUserDetailsById(Long id);
    UserDetails saveNewUserDetails(UserDetails userDetails);
}