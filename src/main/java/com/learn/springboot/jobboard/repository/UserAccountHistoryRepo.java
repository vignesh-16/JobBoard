package com.learn.springboot.jobboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.springboot.jobboard.schema.UserAccountHistory;

public interface UserAccountHistoryRepo extends MongoRepository<UserAccountHistory, String> {
    
}
