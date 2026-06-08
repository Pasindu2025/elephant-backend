package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.Agent;
import com.pasindu.elephant_backend.repository.AgentRepository;
import com.pasindu.elephant_backend.service.EmailService; // EmailService eka import karanna
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private EmailService emailService; // EmailService eka inject karanna

    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        // 1. Auto-generate Username (Name + random numbers)
        String baseName = agent.getFullName().toLowerCase().replaceAll("\\s+", "");
        String generatedUsername = baseName + "_" + (int)(Math.random() * 9000 + 1000);

        // 2. Auto-generate Password (8 characters)
        String generatedPassword = UUID.randomUUID().toString().substring(0, 8);

        // 3. Values tika Agent object ekata set karanna
        agent.setUsername(generatedUsername);
        agent.setPassword(generatedPassword);

        // 4. Database ekata save karanna
        Agent savedAgent = agentRepository.save(agent);

        // 5. Email eka yawanna (Service eka use karala)
        try {
            emailService.sendCredentialEmail(savedAgent.getEmail(), generatedUsername, generatedPassword);
        } catch (Exception e) {
            System.out.println("Email error: " + e.getMessage());
        }

        return savedAgent;
    }
}