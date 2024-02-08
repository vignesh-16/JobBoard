package com.learn.springboot.jobboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.learn.springboot.jobboard.schema.UserAuthenticate;

@Service
public interface UserAuthenticateRepo extends MongoRepository<UserAuthenticate, String> {

    UserAuthenticate findByUserId(String userId); 

}
