package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.User;
import com.pasindu.elephant_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Allow requests from any frontend origin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint for user registration
     */
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * Unified login endpoint for both regular users and Wildlife officers.
     * It checks the credentials and returns a specific role-based status.
     */
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        // Authenticate user by checking username and password in the database
        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (existingUser != null) {
            // Check if the logging user is the designated Wildlife Admin
            if ("wildlife_admin".equals(existingUser.getUsername())) {
                return "WILDLIFE_SUCCESS";
            }
            // If it's a regular user
            return "USER_SUCCESS";
        } else {
            // Authentication failed
            return "FAIL";
        }
    }

    /**
     * Optional: This method can be kept if you still need a direct
     * request-param based login, otherwise, it can be removed.
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