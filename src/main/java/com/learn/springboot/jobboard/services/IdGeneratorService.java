package com.learn.springboot.jobboard.services;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class IdGeneratorService {
    
    public String generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();

        // Combine the most significant bits and least significant bits
        long combinedBits = mostSignificantBits ^ leastSignificantBits;

        // Take the absolute value to handle negative numbers
        combinedBits = Math.abs(combinedBits);

        // Extract the last 8 digits
        long last8Digits = combinedBits % 100000000;

        return String.format("%08d", last8Digits); // Pad with leading zeros if necessary
    }
}
