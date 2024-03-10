package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.jobboard.params.AccountDetails;
import com.learn.springboot.jobboard.params.ServerResponse;
import com.learn.springboot.jobboard.repository.UserAccountHistoryRepo;
import com.learn.springboot.jobboard.repository.UserAuthenticateRepo;
import com.learn.springboot.jobboard.repository.UserRepo;
import com.learn.springboot.jobboard.schema.User;
import com.learn.springboot.jobboard.schema.UserAccountHistory;
import com.learn.springboot.jobboard.schema.UserAuthenticate;
import com.learn.springboot.jobboard.services.IdGeneratorService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.apache.commons.lang3.ObjectUtils;
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

    @Autowired
    UserAccountHistoryRepo logsRepo;
    
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
            String date = getDate();
            newUser.setId(userId);
            newUser.setCreatedAt(date);
            repo.save(newUser);
            boolean logCreated = saveLogs(newUser);
            logger.info("Logs for new user created ? "+logCreated);
            if (logCreated){
                return new ServerResponse(200, "User created successfully!!!", userId);
            } else {
                return new ServerResponse(500, "Could not create user logs");
            }
        }
    }

    @PostMapping("/SaveUserCredentials")
    public ServerResponse createOrSaveUserCredentials (@RequestBody UserAuthenticate userCreds) {
        String credsId = createUserId.generateUniqueId();
        userCreds.setId(credsId);
        credsRepo.save(userCreds);
        return new ServerResponse(200, "User credentials saved successfully!");
    }
    
    public String getDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        return format.format(now);
    }

    public boolean saveLogs(User user) {
        UserAccountHistory newUserLog = new UserAccountHistory();
        newUserLog.setId(createUserId.generateUniqueId());
        newUserLog.setForUserId(user.getId());
        AccountDetails userAccountDetails = new AccountDetails();
        userAccountDetails.setModifiedAt(getDate());
        userAccountDetails.setLog(user);
        userAccountDetails.setLogType("Account creation");
        userAccountDetails.setModifiedField("NA");
        newUserLog.setLogs(userAccountDetails);
        newUserLog = logsRepo.save(newUserLog);
        return !ObjectUtils.isEmpty(newUserLog);
    }
}
