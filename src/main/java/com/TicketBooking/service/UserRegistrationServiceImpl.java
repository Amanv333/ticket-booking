package com.TicketBooking.service;

import com.TicketBooking.Repository.RoleRepository;
import com.TicketBooking.Repository.UserRegRepository;
import com.TicketBooking.Repository.UserRepository;
import com.TicketBooking.entity.Role;
import com.TicketBooking.entity.User;
import com.TicketBooking.entity.UserRegistration;
import com.TicketBooking.payload.UserDto;
import com.TicketBooking.payload.UserRegistrationDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserRegistrationServiceImpl {
    @Autowired
    private UserRepository regRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserRegistrationDto getUser(long id) {
        User byId = regRepository.getReferenceById(id);
        return new UserRegistrationDto(id,
                byId.getUsername(), byId.getEmail());

    }

    public UserRegistrationDto saveUser(UserDto dto, MultipartFile profilePicture) {
        User user = modelMapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Set<Role> roles = new HashSet<>();
        for (String role: dto.getRoles()){
            Role byName = roleRepository.getByName(role);
            roles.add(byName);
        }
        user.setRoles(roles);
        try {
            user.setProfilePicture(profilePicture.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        User save = regRepository.save(user);
        return new UserRegistrationDto(
                save.getId(), save.getUsername(),save.getEmail());


    }
}
