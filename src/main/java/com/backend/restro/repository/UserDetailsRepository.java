package com.backend.restro.repository;

import com.backend.restro.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

//    @Query(value = "select u.id, u.email, u.name, u.password, u.phoneNumber from UserDetails u where u.name = :name and u.email = :userEmail", nativeQuery = true)
    @Query(value = """
            select
                u.user_id,
                u.email,
                u.name,
                u.password,
                u.phone_number
            from
                user_details u
            where
                1=1
                and u.name = :name
                and u.email = :userEmail
            """, nativeQuery = true)
//    @Query(value = "select u.user_id, u.email, u.name, u.password, u.phone_number from user_details u where u.name = ? and u.email = ?", nativeQuery = true)
    UserDetails getUserDetails(String name, String userEmail);

    UserDetails findByName(String name);
    // select * from user_details where name = :name

    // select * from user_details where name = :name and email = :email;
    UserDetails findByNameAndEmail(String name, String email);

}
