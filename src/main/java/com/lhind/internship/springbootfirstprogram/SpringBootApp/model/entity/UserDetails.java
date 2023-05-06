package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstname;
    @Column(name = "last_name",nullable = false)
    private String lastname;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private User user;

}
