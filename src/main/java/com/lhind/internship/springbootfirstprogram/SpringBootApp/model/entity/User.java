package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "role",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user")
    private UserDetails userDetails;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Booking> bookings;

}
