package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.entity;


import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.FlightStatusEnum;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Entity
@NamedQueries({
        @NamedQuery(name = "allFlights", query = "SELECT e from Flight e"),
        @NamedQuery(name = "findByOrigin",query = "SELECT e from Flight e where e.origin = :origin")
})
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;
    @Column(name = "origin",nullable = false,unique = true)
    private String origin;
    @Column(name = "destination",nullable = false,unique = true)
    private String destination;
    @Column(name = "airline",nullable = false,unique = true)
    private String airline;
    @Column(name = "flight_number",nullable = false,unique = true)
    private String flightNumber;
    @Column(name = "departure_date",nullable = false,unique = true)
    @Temporal(value = TemporalType.DATE)
    private Date departureDate;
    @Column(name = "arrival_date",nullable = false,unique = true)
    @Temporal(value = TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "status",nullable = false,unique = true)
    @Enumerated(value = EnumType.STRING)
    private FlightStatusEnum status;
    @ManyToMany(mappedBy = "flights",cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public FlightStatusEnum getStatus() {
        return status;
    }

    public void setStatus(FlightStatusEnum status) {
        this.status = status;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", status=" + status +
                ", bookings=" + bookings +
                '}';
    }
}
