package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.Fence;
import com.pasindu.elephant_backend.repository.FenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/fences")
public class FenceController {

    @Autowired
    private FenceRepository repo;

    // 🔹 GET ALL (Load all fences)
    @GetMapping
    public List<Fence> getAllFences() {
        return repo.findAll();
    }

    // 🔹 ADD (Wildlife marks fence)
    @PostMapping
    public Fence addFence(@RequestBody Fence fence) {
        fence.setStatus("OK"); // default status
        fence.setCreatedBy("WILDLIFE");
        return repo.save(fence);
    }

    // 🔹 UPDATE (Agent updates status)
    @PutMapping
    public Fence updateFence(@RequestBody Fence fence) {
        return repo.save(fence);
    }

    // 🔹 DELETE (by latitude + longitude)
    @DeleteMapping
    public void deleteFenceByLatLon(
            @RequestParam double latitude,
            @RequestParam double longitude) {

        System.out.println("DELETE API HIT: " + latitude + ", " + longitude);

        repo.deleteApprox(latitude, longitude);
    }
}