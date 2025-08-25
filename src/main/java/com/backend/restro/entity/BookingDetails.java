package com.backend.restro.entity;

import com.backend.restro.model.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "booking_details")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetails {

    @Id
    @SequenceGenerator(name = "booking_id_seq", sequenceName = "booking_id_seq", allocationSize = 1, initialValue = 15)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_user_fk", referencedColumnName = "user_id")
    private UserDetails userDetails;
    private LocalDate bookingDate;
    private BookingStatus status;
    private Integer headCount;


}
