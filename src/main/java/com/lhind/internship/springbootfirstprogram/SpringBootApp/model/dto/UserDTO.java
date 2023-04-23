package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.UserRoleEnum;
import org.springframework.stereotype.Component;

@Component
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private UserRoleEnum role;
    private UserDetailsDTO userDetailsDTO;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, UserRoleEnum role, UserDetailsDTO userDetailsDTO) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.userDetailsDTO = userDetailsDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public UserDetailsDTO getUserDetailsDTO() {
        return userDetailsDTO;
    }

    public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", userDetailsDTO=" + userDetailsDTO +
                '}';
    }
}
