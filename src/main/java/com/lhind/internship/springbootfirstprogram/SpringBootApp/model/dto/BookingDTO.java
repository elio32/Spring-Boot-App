package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.BoookingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    private Date bookingDate;
    private BoookingStatusEnum status;
    private List<FlightDTO> flights;


}

