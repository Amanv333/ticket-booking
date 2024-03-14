package com.redbus.controller;

import com.redbus.entity.UserRegistration;
import com.redbus.payload.UserRegistrationDto;
import com.redbus.service.UserRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegController {
    @Autowired
    private UserRegistrationServiceImpl userService;
    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePicture") MultipartFile profilePicture

    ){
        UserRegistration user = new UserRegistration();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        try {
            user.setProfilePicture(profilePicture.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        userService.saveUser(user);


        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable long id){
        UserRegistrationDto user = userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
