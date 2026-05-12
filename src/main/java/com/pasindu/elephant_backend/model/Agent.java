package com.pasindu.elephant_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "agent")
public class Agent {

    @Id

    private String id;

    private String fullName;
    private String contactNumber;
    private String email;
    private String address;
    private String assignedArea;

    private String username;
    private String password;
}