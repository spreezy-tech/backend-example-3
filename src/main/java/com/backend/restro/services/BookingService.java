package com.backend.restro.services;

import com.backend.restro.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

}
