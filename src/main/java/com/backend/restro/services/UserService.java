package com.backend.restro.services;

import com.backend.restro.entity.UserDetails;
import com.backend.restro.model.RegistrationRequest;
import com.backend.restro.model.RegistrationUpdateRequest;
import com.backend.restro.repository.BookingRepository;
import com.backend.restro.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserDetailsRepository userDetailsRepository;
    private UserDetails userDetails = new UserDetails();

    UserService(UserDetailsRepository userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;
        this.userDetails.setName("ABC");
    }

    public String createUserRegistration(RegistrationRequest request){
        log.info("Registration request {}", request);
        return "User registered";
    }

    public String updateUserDetails(RegistrationUpdateRequest updateRequest){
        log.warn("Registration update request {}", updateRequest);
        return "User updated";
    }

    public String deleteUserDetails(String name){
        log.error("Delete user {}", name);
        log.debug("debug log");
        return "User deleted";
    }
}
