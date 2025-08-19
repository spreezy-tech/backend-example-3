package com.backend.restro.repository;

import com.backend.restro.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Integer> {
}
