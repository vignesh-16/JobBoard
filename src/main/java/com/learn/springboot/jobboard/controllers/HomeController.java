package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learn.springboot.jobboard.params.SigninParams;
import com.learn.springboot.jobboard.repository.UserAuthenticateRepo;
import com.learn.springboot.jobboard.schema.UserAuthenticate;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public ModelAndView signUserIn(@RequestBody SigninParams user) {
        String userId = user.getUsername();
        UserAuthenticate currentUser = credentials.findByUserId(userId);
        if(currentUser != null && currentUser.getPassword().equals(user.getPassword())) {
            logger.info("user authentication matches!!!");
        }
        return new ModelAndView("home");
    }
    
}
