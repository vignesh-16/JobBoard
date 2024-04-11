package com.learn.springboot.jobboard.controllers;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learn.springboot.jobboard.repository.JobPostDO;
import com.learn.springboot.jobboard.schema.JobPost;
import com.learn.springboot.jobboard.services.IdGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class RecruiterActionsController {
    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    JobPostDO jobpostsDocument;

    @Autowired
    IdGeneratorService generateId;

    @PostMapping("/createJobPost")
    public void saveJobPost(@RequestBody  JobPost job) {
        logger.info("Post received : "+job.toString());
        job.setId(generateId.generateUniqueId());
        jobpostsDocument.save(job);
    }
    
    @RequestMapping("/addNewJobPost")
    public ModelAndView buildJobPost() {
        return new ModelAndView("/jobposts/createjobpost");
    }
    
}
