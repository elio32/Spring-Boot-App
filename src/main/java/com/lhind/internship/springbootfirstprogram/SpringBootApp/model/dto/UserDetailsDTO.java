package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;

}
