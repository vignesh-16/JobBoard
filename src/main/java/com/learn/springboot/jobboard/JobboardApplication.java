package com.learn.springboot.jobboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class JobboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobboardApplication.class, args);
	}

}
