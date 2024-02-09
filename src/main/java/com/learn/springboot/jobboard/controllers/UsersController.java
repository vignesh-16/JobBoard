package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.jobboard.repository.UserRepo;
import com.learn.springboot.jobboard.schema.User;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UsersController {

    Logger logger = Logger.getLogger(getClass().getName());
    
    @Autowired
    UserRepo repo;
    
    @PostMapping("/createuser")
    public void postMethodName(@RequestBody User newUser) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> request received to the end point!! "+newUser.toString());
        repo.save(newUser);
    }
    
}
