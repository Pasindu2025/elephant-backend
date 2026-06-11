package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.ElephantAlert;
import com.pasindu.elephant_backend.repository.ElephantAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "*")
public class AlertController {

    @Autowired
    private ElephantAlertRepository alertRepository;

    private final String FILE_PATH = "C:/Users/Lenovo/Desktop/Elephant_Project/detected_elephant.jpg";

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestAlert() {
        File file = new File(FILE_PATH);

        if (file.exists()) {
            List<ElephantAlert> all = alertRepository.findAll();
            if (all.isEmpty()) {
                ElephantAlert latest = new ElephantAlert();
                latest.setPlace("Live Camera Feed");
                latest.setDateTime(LocalDateTime.now());
                latest.setImageName("detected_elephant.jpg");
                return ResponseEntity.ok(alertRepository.save(latest));
            }
            return ResponseEntity.ok(all.get(0));
        } else {
            // පින්තූරේ නැත්නම් Database එකත් Clear කරනවා
            alertRepository.deleteAll();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No active alert");
        }
    }

    @DeleteMapping("/delete-image")
    public ResponseEntity<String> deleteImage() {
        // 1. Database එකෙන් රෙකෝඩ්ස් මකන්න
        alertRepository.deleteAll();

        // 2. පින්තූරේ ෆයිල් එක මකන්න
        File file = new File(FILE_PATH);
        if (file.exists()) {
            if (file.delete()) {
                return ResponseEntity.ok("Deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not delete file");
            }
        }
        return ResponseEntity.ok("No file to delete");
    }
}