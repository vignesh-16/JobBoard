package com.learn.springboot.jobboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.springboot.jobboard.schema.JobPost;

public interface JobPostDO extends MongoRepository<JobPost, String> {

}
