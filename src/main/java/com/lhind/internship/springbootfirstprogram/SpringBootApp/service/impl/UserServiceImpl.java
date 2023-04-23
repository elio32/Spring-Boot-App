package com.lhind.internship.springbootfirstprogram.SpringBootApp.service.impl;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper.UserMapper;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
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
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public UserDTO findUserById(Long id) throws ChangeSetPersister.NotFoundException {
        return (UserDTO) userRepository.findById(id).stream().map(userMapper::toDto).collect(Collectors.toList());  //Nuk duhet ber cast, por me jep error nqs se bej
//        return userRepository.findById(id);
    }

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        return userRepository.saveNewUser(userDTO);

    }

}