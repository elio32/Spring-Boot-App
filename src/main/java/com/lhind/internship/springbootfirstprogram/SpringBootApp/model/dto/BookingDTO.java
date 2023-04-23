package com.lhind.internship.springbootfirstprogram.SpringBootApp.model.dto;
import com.lhind.internship.springbootfirstprogram.SpringBootApp.model.enums.BoookingStatusEnum;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookingDTO {
    private Long id;
    private Date bookingDate;
    private BoookingStatusEnum status;

    public BookingDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;

    }

    public BoookingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BoookingStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingTDO{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                '}';
    }
}

