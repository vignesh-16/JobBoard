package com.learn.springboot.jobboard.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.jobboard.repository.UserAuthenticateRepo;
import com.learn.springboot.jobboard.schema.UserAuthenticate;

@Service
public class UserService {
    private final UserAuthenticateRepo userRepository;

    @Autowired
    public UserService(UserAuthenticateRepo userRepository) {
        this.userRepository = userRepository;
    }

    public UserAuthenticate findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}

