package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.learn.springboot.jobboard.repository.UserAuthenticateRepo;
import com.learn.springboot.jobboard.repository.UserRepo;
import com.learn.springboot.jobboard.schema.User;
import com.learn.springboot.jobboard.schema.UserAuthenticate;
import com.learn.springboot.jobboard.services.IdGeneratorService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createUser (@RequestBody User newUser) {
        User existing = repo.findByEmail(newUser.getEmail());
        if(existing != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        } else {
            String userId = createUserId.generateUniqueId();
            newUser.setId(userId);
            repo.save(newUser);
            return ResponseEntity.ok(userId);
        }
    }

    @PostMapping("/SaveUserCredentials")
    public void createOrSaveUserCredentials (@RequestBody String entity) {

    }
    
    
}
