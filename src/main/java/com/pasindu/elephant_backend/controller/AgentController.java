package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.Agent;
import com.pasindu.elephant_backend.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

        import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;


    @GetMapping
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }


    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        return agentRepository.save(agent);
    }
    @PutMapping("/{id}")
    public Agent updateAgent(@PathVariable Long id, @RequestBody Agent agentDetails) {
        // find the agent that same to id
        return agentRepository.findById(id)
                .map(agent -> {
                    // update the details if who was there
                    agent.setFullName(agentDetails.getFullName());
                    agent.setContactNumber(agentDetails.getContactNumber());
                    agent.setEmail(agentDetails.getEmail());
                    agent.setAddress(agentDetails.getAddress());
                    agent.setAssignedArea(agentDetails.getAssignedArea());
                    agent.setEmployeeId(agentDetails.getEmployeeId()); // මේකත් අමතක කරන්න එපා

                    // save the edited details
                    return agentRepository.save(agent);
                })
                .orElseGet(() -> {
                    agentDetails.setId(id);
                    return agentRepository.save(agentDetails);
                });

    }@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable Long id) {
        return agentRepository.findById(id)
                .map(agent -> {
                    agentRepository.delete(agent);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

