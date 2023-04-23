package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.UserDetailsMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDetailsDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.UserDetailsRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Optional<UserDetails> findUserDetailsById(Long id) {
        if (userDetailsRepository.findById(id) == null)
            throw new IllegalArgumentException("UserDetails with Id : " + id + " does not exist ");
        return Optional.of(userDetailsRepository.findById(id).get());

    }

    @Override
    public UserDetails saveNewUserDetails(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }
}
