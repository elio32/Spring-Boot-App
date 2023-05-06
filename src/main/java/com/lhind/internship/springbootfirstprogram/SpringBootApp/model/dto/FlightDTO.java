package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto;

import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.FlightStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    private Long id;
    private String origin;
    private String destination;
    private String airline;
    private String flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private FlightStatusEnum status;
}
