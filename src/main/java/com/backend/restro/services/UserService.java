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

    UserService(UserDetailsRepository userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;
    }

    public String createUserRegistration(RegistrationRequest request){
        log.info("Registration request {}", request);
//        UserDetails userDetails = new UserDetails();
//        userDetails.setName(request.getName());
//        userDetails.setEmail(request.getEmail());
//        userDetails.setPassword(request.getPassword());
//        userDetails.setPhoneNumber(request.getPhoneNumber());

        UserDetails userDetails = UserDetails.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                        .build();


        userDetailsRepository.save(userDetails);

        return "User registered : "+userDetails.getName();
    }

    public String updateUserDetails(RegistrationUpdateRequest updateRequest){
        log.warn("Registration update request {}", updateRequest);
        return "User updated";
    }

    public String deleteUserDetails(String name){
        log.error("Delete user {}", name);
        log.debug("debug log");

        UserDetails userDetails = userDetailsRepository.findByName(name);
        userDetailsRepository.delete(userDetails);

        return "User deleted";
    }
}
