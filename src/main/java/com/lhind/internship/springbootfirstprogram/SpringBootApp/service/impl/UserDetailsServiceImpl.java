package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.UserDetailsMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDetailsDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.UserDetailsRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor

public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsMapper userDetailsMapper;


    @Override
    public List<UserDetailsDTO> loadAllUsersDetails() {
        return userDetailsRepository.findAll().stream().map(userDetailsMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public void deleteUserDetails(UserDetails userDetails) {
        userDetailsRepository.delete(userDetails);

    }

    @Override
    public UserDetailsDTO findUserDetailsById(Long id) {
        UserDetails userDetails = userDetailsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with Id : " + id + " does not exist "));
        return userDetailsMapper.toDto(userDetails);

    }

    @Override
    public UserDetailsDTO saveNewUserDetails(UserDetails userDetails) {
        userDetails = userDetailsRepository.save(userDetails);
        return userDetailsMapper.toDto(userDetails);
    }
}
