package com.backend.restro.controller;

import com.backend.restro.model.RegistrationRequest;
import com.backend.restro.model.RegistrationResponse;
import com.backend.restro.model.RegistrationUpdateRequest;
import com.backend.restro.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

//    http://localhost:8080/user

    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    //    http://localhost:8080/user/test
    @GetMapping("/test")
    public ResponseEntity<String> getUserDetails(){
        return new ResponseEntity<>("This is a sample API response for user details", HttpStatus.ACCEPTED);
    }

    //    http://localhost:8080/user/test/Harsh
    @GetMapping("/test/{ownerName}")
    public ResponseEntity<String> getUserDetailsFromPath(@PathVariable(name = "ownerName") String name){
        return new ResponseEntity<>("This is a sample API response for " + name, HttpStatus.ACCEPTED);
    }

    //    http://localhost:8080/user/test/Avi/param?surname=Shinde
    @GetMapping("/test/{ownerName}/param")
    public ResponseEntity<String> getUserDetailsFromParams(@PathVariable(name = "ownerName") String name, @RequestParam("surname") String paramValue){
        return new ResponseEntity<>("This is a sample API response for " + name + paramValue, HttpStatus.ACCEPTED);
    }

    //    http://localhost:8080/user/create
    @PostMapping("/create")
    public ResponseEntity<RegistrationResponse> createUserRegistration(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<>(this.userService.createUserRegistration(registrationRequest), HttpStatus.OK);
    }

    //    http://localhost:8080/user/update
    @PutMapping("/update")
    public ResponseEntity<RegistrationResponse> updateUserRegistration(@RequestBody RegistrationUpdateRequest registrationRequest){
        return new ResponseEntity<>(this.userService.updateUserDetails(registrationRequest), HttpStatus.OK);
    }

    //    http://localhost:8080/user/delete/Sarthak
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<RegistrationResponse> deleteUserRegistration(@PathVariable String name){
        return new ResponseEntity<>(this.userService.deleteUserDetails(name), HttpStatus.OK);
    }




}
