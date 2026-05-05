package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.User;
import com.pasindu.elephant_backend.model.Agent;
import com.pasindu.elephant_backend.repository.UserRepository;
import com.pasindu.elephant_backend.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AgentRepository agentRepository;

    /**
     * Endpoint for user registration
     */
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * Unified login endpoint for Users, Wildlife Admin, and Agents.
     */
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (existingUser != null) {
            if ("wildlife_admin".equals(existingUser.getUsername())) {
                return "WILDLIFE_SUCCESS";
            }
            return "USER_SUCCESS";
        }


        Optional<Agent> existingAgent = agentRepository.findByUsername(user.getUsername());

        if (existingAgent.isPresent() && existingAgent.get().getPassword().equals(user.getPassword())) {
            return "AGENT_SUCCESS"; // Agent kenek nam me response eka yawamu
        }

        return "FAIL";
    }

    /**
     * Wildlife login based on Request Parameters
     */
    @PostMapping("/wildlife-login")
    public String wildlifeLogin(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            return "WILDLIFE_SUCCESS";
        } else {
            return "FAIL";
        }
    }
}