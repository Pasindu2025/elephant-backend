package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.DangerArea;
import com.pasindu.elephant_backend.repository.DangerAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/danger-areas")
@CrossOrigin(origins = "*")
public class DangerAreaController {

    @Autowired
    private DangerAreaRepository dangerAreaRepository;

    // 1. තියෙන ඔක්කොම Areas ටික ගන්න (Map එක Load වෙද්දී අඳින්න)
    @GetMapping("/all")
    public List<DangerArea> getAllAreas() {
        return dangerAreaRepository.findAll();
    }

    // 2. අලුත් Area එකක් Save කරන්න
    @PostMapping("/add")
    public DangerArea addArea(@RequestBody DangerArea dangerArea) {
        return dangerAreaRepository.save(dangerArea);
    }

    // 3. Area එකක් මකන්න (ID එක දීලා)
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeArea(@PathVariable Long id) {
        try {
            dangerAreaRepository.deleteById(id);
            return ResponseEntity.ok().body("Area removed successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error removing area.");
        }
    }
}