package com.pasindu.elephant_backend.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.UUID;

@Service
public class CredentialGeneratorService {


    public String generateUsername(String agentName) {
        String shortId = UUID.randomUUID().toString().substring(0, 4);
        return agentName.toLowerCase().replaceAll("\\s+", "") + "_" + shortId;
    }


    public String generateRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}