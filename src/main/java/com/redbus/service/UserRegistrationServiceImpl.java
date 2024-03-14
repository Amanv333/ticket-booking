package com.redbus.service;

import com.redbus.Repository.UserRegRepository;
import com.redbus.entity.UserRegistration;
import com.redbus.payload.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationServiceImpl {
    @Autowired
    private UserRegRepository regRepository;

    public void saveUser(UserRegistration user) {
        regRepository.save(user);
    }

    public UserRegistrationDto getUser(long id) {
        UserRegistration byId = regRepository.getById(id);
        return new UserRegistrationDto(id,
                byId.getName(), byId.getEmail(), byId.getPassword(), byId.getProfilePicture());

    }
}
