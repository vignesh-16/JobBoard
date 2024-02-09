package com.learn.springboot.jobboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.springboot.jobboard.schema.User;

public interface UserRepo  extends MongoRepository<User, String> {
    
}
