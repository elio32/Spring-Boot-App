package com.lhind.internship.springbootfirstprogram.SpringBootApp.mapper;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto.UserDetailsDTO;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity.UserDetails;

public class UserDetailsMapper extends AbstractMapper<UserDetails, UserDetailsDTO>{
    @Override
    public UserDetails toEntity(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(userDetailsDTO.getId());
        userDetails.setFirstname(userDetailsDTO.getFirstname());
        userDetails.setLastname(userDetailsDTO.getLastname());
        userDetails.setEmail(userDetailsDTO.getEmail());
        userDetails.setPhoneNumber(userDetailsDTO.getPhoneNumber());
        return userDetails;
    }

    @Override
    public UserDetailsDTO toDto(UserDetails userDetails) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(userDetails.getId());
        userDetailsDTO.setFirstname(userDetails.getFirstname());
        userDetailsDTO.setLastname(userDetails.getLastname());
        userDetailsDTO.setEmail(userDetails.getEmail());
        userDetailsDTO.setPhoneNumber(userDetails.getPhoneNumber());
        return userDetailsDTO;
    }
}
