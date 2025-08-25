package com.backend.restro.services;

import com.backend.restro.entity.BookingDetails;
import com.backend.restro.entity.UserDetails;
import com.backend.restro.model.BookingRequest;
import com.backend.restro.model.BookingStatus;
import com.backend.restro.repository.BookingRepository;
import com.backend.restro.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private UserDetailsRepository userDetailsRepository;

    BookingService(BookingRepository bookingRepository, UserDetailsRepository userDetailsRepository){
        this.bookingRepository = bookingRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    public String registerBooking(BookingRequest request){
        UserDetails userDetails = userDetailsRepository.findByName(request.getName());

        BookingDetails bookingDetails = BookingDetails.builder()
                .userDetails(userDetails)
                .headCount(request.getHeadCount())
                .bookingDate(LocalDate.parse(request.getDate(), DateTimeFormatter.BASIC_ISO_DATE))
                .status(BookingStatus.CONFIRMED)
                .build();

        bookingRepository.save(bookingDetails);

        return "Booking created";
    }

}
