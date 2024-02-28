package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learn.springboot.jobboard.params.ServerResponse;
import com.learn.springboot.jobboard.params.SigninParams;
import com.learn.springboot.jobboard.repository.UserAuthenticateRepo;
import com.learn.springboot.jobboard.schema.UserAuthenticate;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class HomeController {

    Logger logger = Logger.getLogger(getClass().getName());
    
    @Autowired
    UserAuthenticateRepo credentials;

    @RequestMapping("/")
    public ModelAndView welcomePage() {
        return new ModelAndView("signin");
    }
    @PostMapping("/signin")
    public ServerResponse signUserIn(@RequestBody SigninParams user) {
        logger.info("Sign in request recieved for login id: "+user.getUsername());
        String logInId = user.getUsername();
        UserAuthenticate currentUser = credentials.findByUserLogin(logInId);
        logger.info("request param as : "+user.getPassword().getClass());
        if(currentUser!=null && currentUser.getPassword().equals(user.getPassword())) {
            logger.info("user credentials matches!!!");
            return new ServerResponse(200, "User authentication passed", new ModelAndView("home"));
        } else {
            logger.info("user credentials does not match");
            return new ServerResponse(401, "User authentication failed");
        }
    }

    @GetMapping("/home")
    public ModelAndView getHomePage() {
        return new ModelAndView("home");
    }
    
}
