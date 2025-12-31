package com.fitness.userservice.services;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.exception.EmailAlreadyExistsException;
import com.fitness.userservice.model.Users;
import com.fitness.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    @Autowired
    ModelMapper modelMapper;


    public UserResponse register(RegisterRequest registerRequest) {
        if(repository.existsByEmail(registerRequest.getEmail())) {
            throw  new EmailAlreadyExistsException(); // User already exists
        }

        Users users = modelMapper.map(registerRequest, Users.class);
        Users savedUser = repository.save(users);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    public UserResponse getUserProfile(Long userid) {
        Users users = repository.findById(userid).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(users, UserResponse.class);
    }
}
