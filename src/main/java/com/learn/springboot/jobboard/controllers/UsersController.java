package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.jobboard.repository.UserAuthenticateRepo;
import com.learn.springboot.jobboard.repository.UserRepo;
import com.learn.springboot.jobboard.schema.User;
import com.learn.springboot.jobboard.schema.UserAuthenticate;
import com.learn.springboot.jobboard.services.IdGeneratorService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsersController {

    Logger logger = Logger.getLogger(getClass().getName());
    
    @Autowired
    UserRepo repo;

    @Autowired
    UserAuthenticateRepo credsRepo;

    IdGeneratorService createUserId;
    
    @PostMapping("/createuser")
    public void postMethodName(@RequestParam(name="user") User newUser, @RequestParam(name = "credentials") UserAuthenticate userCreds) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> request received to the end point!! "+newUser.toString()+" : "+userCreds.toString());
        String userId = createUserId.generateUniqueId();
        String credsId = createUserId.generateUniqueId();
        newUser.setId(userId);
        repo.save(newUser);
        userCreds.setId(credsId);
        userCreds.setUserId(userId);
        credsRepo.save(userCreds);
    }
    
}
