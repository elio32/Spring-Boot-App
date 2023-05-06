package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private UserRoleEnum role;
    private UserDetailsDTO userDetailsDTO;

}
