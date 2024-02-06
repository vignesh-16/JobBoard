package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learn.springboot.jobboard.params.SigninParams;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HomeController {
    Logger logger = Logger.getLogger(getClass().getName());
    @RequestMapping("/")
    public ModelAndView welcomePage() {
        return new ModelAndView("signin");
    }
    @PostMapping("/signin")
    public ModelAndView signUserIn(@RequestBody SigninParams user) {
        logger.info(" >> params recieved: "+user.toString());
        return new ModelAndView("home");
    }
    
}
