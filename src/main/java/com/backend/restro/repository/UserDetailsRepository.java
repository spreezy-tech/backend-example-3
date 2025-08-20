package com.backend.restro.repository;

import com.backend.restro.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

    UserDetails findByName(String name);
    // select * from user_details where name = :name

    // select * from user_details where name = :name and email = :email;
    UserDetails findByNameAndEmail(String name, String email);

}
