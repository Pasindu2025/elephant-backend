package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.User;
import com.pasindu.elephant_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // To call any frontend
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Use to  Register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Use to Login
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return "Success";
        } else {
            return "Fail";
        }
    }
}