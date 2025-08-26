package com.backend.restro.services;

import com.backend.restro.entity.UserDetails;
import com.backend.restro.model.RegistrationRequest;
import com.backend.restro.model.RegistrationResponse;
import com.backend.restro.model.RegistrationUpdateRequest;
import com.backend.restro.repository.BookingRepository;
import com.backend.restro.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Value("${test.property.name}")
    private String dummyProperty;


    @Value("${test.property.pincode}")
    private Long pinCode;

    private UserDetailsRepository userDetailsRepository;
    private NotificationService notificationService;

    UserService(UserDetailsRepository userDetailsRepository, @Qualifier("emailNotificationService") NotificationService notificationService){
        this.userDetailsRepository = userDetailsRepository;
        this.notificationService = notificationService;
    }

    public RegistrationResponse createUserRegistration(RegistrationRequest request){
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

        return RegistrationResponse.builder()
                .isSuccess(Boolean.TRUE)
                .operation("Create")
                .build();
    }

    public RegistrationResponse updateUserDetails(RegistrationUpdateRequest updateRequest){
        log.warn("Registration update request {}", updateRequest);
        log.info("Dummy setting from configuration file : {}", dummyProperty);
        log.info("Dummy pincode from configuration file : {}", pinCode);

        log.info("Notification log : {}", notificationService.sendNotification());

        UserDetails userDetails = userDetailsRepository.getUserDetails(updateRequest.getName(), updateRequest.getEmail());

        userDetails.setPassword(updateRequest.getPassword() );

        userDetailsRepository.save(userDetails);

        return RegistrationResponse.builder()
                .isSuccess(Boolean.TRUE)
                .operation("Update")
                .build();
    }

    public RegistrationResponse deleteUserDetails(String name){
        log.error("Delete user {}", name);
        log.debug("debug log");

        UserDetails userDetails = userDetailsRepository.findByName(name);
        userDetailsRepository.delete(userDetails);

        return RegistrationResponse.builder()
                .isSuccess(Boolean.TRUE)
                .operation("Update")
                .build();
    }
}
