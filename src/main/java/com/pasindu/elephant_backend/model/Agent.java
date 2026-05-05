package com.pasindu.elephant_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String contactNumber;
    private String email;
    private String employeeId;
    private String address;
    private String assignedArea;


    private String username;
    private String password;
}