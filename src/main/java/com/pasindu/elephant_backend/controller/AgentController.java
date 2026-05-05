package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.service.EmailService;
import com.pasindu.elephant_backend.service.CredentialGeneratorService;
import com.pasindu.elephant_backend.model.Agent;
import com.pasindu.elephant_backend.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
@CrossOrigin
public class AgentController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CredentialGeneratorService credentialGenerator;

    @Autowired
    private AgentRepository agentRepository;

    // Agent la okkoma ganna (GET request)
    @GetMapping
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    // Aluth agent kenek register karanna (POST request)
    // Issella thibba "/register" kalla ain kara frontend ekath ekka match wenna
    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {

        // Username saha Password generate kireema
        String username = credentialGenerator.generateUsername(agent.getFullName());
        String password = credentialGenerator.generateRandomPassword();

        // Model ekata data set kireema
        agent.setUsername(username);
        agent.setPassword(password);

        // Database ekata save kireema
        Agent savedAgent = agentRepository.save(agent);

        // Agent ta email ekak yawanna credentials ekka
        emailService.sendCredentialEmail(savedAgent.getEmail(), username, password);

        return savedAgent;
    }
}