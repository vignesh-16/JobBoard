package com.learn.springboot.jobboard.controllers;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

@RestController
public class SessionController {

    Logger logger = Logger.getLogger(getClass().getName());

    @PostMapping("/TerminateSession")
    public void invalidateSession(HttpServletRequest request) {
        logger.warning("Request for session terminated received!!");
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        logger.info("Session terminated successfully!!");
    }
}

/**
 * Read more about redis: https://developer.redis.com/create/windows/
 */