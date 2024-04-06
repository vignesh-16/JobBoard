package com.learn.springboot.jobboard.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class CandidateAccountController {

    Logger log = Logger.getLogger(getClass().getName());
    
    @Value("${upload.dir}")
    private String uploadDir;

    @SuppressWarnings("rawtypes")
    @PostMapping("/uploadResume")
    public ResponseEntity postMethodName(@RequestParam("file") MultipartFile resume) {
        try {
            // Create the directory if it doesn't exist
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            log.info("Saving files to: "+uploadDir);
            // Save the file to the specified directory
            String filePath = uploadDir + File.separator + resume.getOriginalFilename();
            resume.transferTo(new File(filePath));

            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to upload file!");
        }
    }
    
    @GetMapping("/joblisting")
    public ModelAndView getMethodName(@RequestParam(required = false) String param) {
        return new ModelAndView("/jobposts/joblistings");
    }
}
