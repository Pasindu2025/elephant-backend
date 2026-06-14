package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.InjuredElephant;
import com.pasindu.elephant_backend.repository.InjuredElephantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/injured-elephants")
public class InjuredElephantController {

    @Autowired
    private InjuredElephantRepository repository;

    @GetMapping("/all")
    public List<InjuredElephant> getAllInjuries() {
        return repository.findAll();
    }

    @PostMapping("/report")
    public InjuredElephant reportInjury(@RequestBody InjuredElephant entry) {
        return repository.save(entry);
    }

    @CrossOrigin // Java Swing එකෙන් එන Request බාරගන්න මේක තියෙන්නම ඕනේ
    @DeleteMapping("/remove")
    public void deleteInjured(@RequestParam double lat, @RequestParam double lon) {
        System.out.println("Request received to remove injured elephant from DB at: " + lat + ", " + lon);
        repository.deleteByCoordinates(lat, lon); // Repository එකේ Custom Query එකට කෝල් කරනවා
    }
}