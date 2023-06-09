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
    private UserRoleEnum role;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;


}
