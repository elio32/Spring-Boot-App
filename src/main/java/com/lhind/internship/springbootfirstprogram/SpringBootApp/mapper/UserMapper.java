package com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDTO>{

    private final UserDetailsMapper userDetailsMapper;

    public UserMapper() {
        this.userDetailsMapper = new UserDetailsMapper();
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setUserDetails(userDetailsMapper.toEntity(userDTO.getUserDetailsDTO()));
        return user;
    }
    @Override
    public UserDTO toDto(User user) {
        if (user ==null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setUserDetailsDTO(userDetailsMapper.toDto(user.getUserDetails()));
        return userDTO;
    }
}

