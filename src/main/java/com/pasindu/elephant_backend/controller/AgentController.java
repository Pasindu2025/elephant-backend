package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.Agent;
import com.pasindu.elephant_backend.repository.AgentRepository;
import com.pasindu.elephant_backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> createAgent(@RequestBody Agent agent) {
        // Front-end eken ID eka (Wildlife ID) ewala nathnam error ekak yawanna
        if (agent.getId() == null || agent.getId().isEmpty()) {
            return ResponseEntity.badRequest().body("Wildlife Agent ID is required!");
        }

        // 1. Auto-generate Username
        String baseName = agent.getFullName().toLowerCase().replaceAll("\\s+", "");
        String generatedUsername = baseName + "_" + (int)(Math.random() * 9000 + 1000);

        // 2. Auto-generate Password
        String generatedPassword = UUID.randomUUID().toString().substring(0, 8);

        agent.setUsername(generatedUsername);
        agent.setPassword(generatedPassword);

        // Wildlife ID eka (agent.getId()) ekkama save wenawa
        Agent savedAgent = agentRepository.save(agent);

        try {
            emailService.sendCredentialEmail(savedAgent.getEmail(), generatedUsername, generatedPassword);
        } catch (Exception e) {
            System.out.println("Email error: " + e.getMessage());
        }

        return ResponseEntity.ok(savedAgent);
    }

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable String id, @RequestBody Agent agentDetails) {
        return agentRepository.findById(id)
                .map(agent -> {
                    agent.setFullName(agentDetails.getFullName());
                    agent.setContactNumber(agentDetails.getContactNumber());
                    agent.setEmail(agentDetails.getEmail());
                    agent.setAddress(agentDetails.getAddress());
                    agent.setAssignedArea(agentDetails.getAssignedArea());
                    return ResponseEntity.ok(agentRepository.save(agent));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable String id) {
        return agentRepository.findById(id)
                .map(agent -> {
                    agentRepository.delete(agent);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}