package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.User;
import com.pasindu.elephant_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/forgot-password")
@CrossOrigin("*")
public class ForgotPasswordController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/request")
    public ResponseEntity<?> resetPasswordDirectly(@RequestParam("email") String email,
                                                   @RequestParam("newPassword") String newPassword) {

        System.out.println("Received Email from UI: [" + email + "]");
        User user = userRepository.findByEmail(email.trim());
        if (user == null) {
            System.out.println("User not found in Database for email: " + email);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

        // Password එක update කරනවා
        user.setPassword(newPassword);
        userRepository.save(user);

        return ResponseEntity.ok("Password updated successfully!");
    }
}