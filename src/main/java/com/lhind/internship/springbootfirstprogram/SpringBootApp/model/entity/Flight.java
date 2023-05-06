package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.FlightStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "airline")
    private String airline;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_date")
    @Temporal(value = TemporalType.DATE)
    private Date departureDate;

    @Column(name = "arrival_date")
    @Temporal(value = TemporalType.DATE)
    private Date arrivalDate;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private FlightStatusEnum status;

    @ManyToMany(mappedBy = "flights",cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
