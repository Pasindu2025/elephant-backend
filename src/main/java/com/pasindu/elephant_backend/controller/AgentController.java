package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.Agent;
import com.pasindu.elephant_backend.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
