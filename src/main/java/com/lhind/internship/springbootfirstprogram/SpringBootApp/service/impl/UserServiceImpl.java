package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.UserMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.repository.UserRepository;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserDTO> loadAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO findUserById(Long id) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with Id : " + id + " does not exist "));
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO saveNewUser(User user) {
        user = userRepository.save(user);
        return userMapper.toDto(user);

    }
    @Override
    public List<UserDTO> loadUsersByFlightId(Long flightId) {
        return userRepository.findUsersByFlightId(flightId).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findAllByUserDetails(UserDetails userDetails) {
        User user = userRepository.findAllByUserDetails(userDetails);
        return userMapper.toDto(user);
    }
}