package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CandidateAccountController {
    @PostMapping("/uploadResume")
    public String postMethodName(@RequestParam("file") MultipartFile resume) {
        //TODO: process POST request
        
        return "File received successfully "+resume;
    }
    
}
