package com.backend.restro.entity;

import com.backend.restro.model.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "booking_details")
public class BookingDetails {

    @Id
    @SequenceGenerator(name = "booking_id_seq", sequenceName = "booking_id_seq", allocationSize = 1, initialValue = 15)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_user_fk", referencedColumnName = "user_id")
    private UserDetails userDetails;
    private Date bookingDate;
    private BookingStatus status;
    private Integer headCount;


}
