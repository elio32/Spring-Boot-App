package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity;

import java.util.Date;
import java.util.List;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.BoookingStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;
    @Column(name = "booking_date",nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date bookingDate;
    @Column(name = "status",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BoookingStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "booking_flight",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private List<Flight> flights;
}