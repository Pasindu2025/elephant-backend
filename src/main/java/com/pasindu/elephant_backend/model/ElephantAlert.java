package com.pasindu.elephant_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "elephant_alerts")
public class ElephantAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String place;
    private LocalDateTime dateTime;
    private String imageName; // 👈 ඉමේජ් එකේ නම විතරක් සේව් කරන්න (උදා: alert.jpg)

    public ElephantAlert() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }
}