package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.Agent;
import com.pasindu.elephant_backend.repository.AgentRepository;
import com.pasindu.elephant_backend.service.EmailService; // EmailService eka import karanna
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

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }





    @PutMapping("/{id}")
    public Agent updateAgent(@PathVariable String id, @RequestBody Agent agentDetails) {
        // Seek the where is the Agent relevent to that id
        return agentRepository.findById(id)
                .map(agent -> {
                    // If who is there then update the details
                    agent.setFullName(agentDetails.getFullName());
                    agent.setContactNumber(agentDetails.getContactNumber());
                    agent.setEmail(agentDetails.getEmail());
                    agent.setAddress(agentDetails.getAddress());
                    agent.setAssignedArea(agentDetails.getAssignedArea());


                    return agentRepository.save(agent);
                })
                .orElseGet(() -> {
                    agentDetails.setId(id);
                    return agentRepository.save(agentDetails);
                });
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