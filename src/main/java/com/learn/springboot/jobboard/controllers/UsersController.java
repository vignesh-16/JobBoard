package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.jobboard.params.ServerResponse;
import com.learn.springboot.jobboard.repository.UserAuthenticateRepo;
import com.learn.springboot.jobboard.repository.UserRepo;
import com.learn.springboot.jobboard.schema.User;
import com.learn.springboot.jobboard.schema.UserAuthenticate;
import com.learn.springboot.jobboard.services.IdGeneratorService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UsersController {

    Logger logger = Logger.getLogger(getClass().getName());
    
    @Autowired
    UserRepo repo;

    @Autowired
    UserAuthenticateRepo credsRepo;

    @Autowired
    IdGeneratorService createUserId;
    
    @PostMapping("/createuser")
    public void createUserAndCredentials(@RequestBody User newUser, @RequestBody UserAuthenticate userCreds) {
        String userId = createUserId.generateUniqueId();
        String credsId = createUserId.generateUniqueId();
        newUser.setId(userId);
        repo.save(newUser);
        userCreds.setId(credsId);
        userCreds.setUserId(userId);
        credsRepo.save(userCreds);
    }

    @PostMapping("/CreateUser")
    public ServerResponse createUser (@RequestBody User newUser) {
        User existing = repo.findByEmail(newUser.getEmail());
        if(existing != null) {
            return new ServerResponse(409, "User with same email already exists");
        } else {
            String userId = createUserId.generateUniqueId();
            newUser.setId(userId);
            repo.save(newUser);
            return new ServerResponse(200, "User created successfully!!!", userId);
        }
    }

    @PostMapping("/SaveUserCredentials")
    public ServerResponse createOrSaveUserCredentials (@RequestBody UserAuthenticate userCreds) {
        String credsId = createUserId.generateUniqueId();
        userCreds.setId(credsId);
        credsRepo.save(userCreds);
        return new ServerResponse(200, "User credentials generated successfully!");
    }
    
    
}
