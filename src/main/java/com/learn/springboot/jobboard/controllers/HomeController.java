package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @RequestMapping("/")
    public ModelAndView welcomepage() {
        return new ModelAndView("signin");
    }
}
