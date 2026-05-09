package com.pasindu.elephant_backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendCredentialEmail(String toEmail, String username, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("pasindulakshan260example@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Your Agent Account Credentials");
        message.setText("Hello Agent,\n\n" +
                "Your account has been created successfully.\n" +
                "Username: " + username + "\n" +
                "Password: " + password + "\n\n" +
                "Please login and change your password immediately.");

        mailSender.send(message);
        System.out.println("Mail sent successfully to " + toEmail);
    }
}