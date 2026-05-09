package com.pasindu.elephant_backend.controller;

import com.pasindu.elephant_backend.model.ActiveAlert;
import com.pasindu.elephant_backend.repository.ActiveAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/active-alerts")
@CrossOrigin(origins = "*") // Frontend එකට අවහිරයක් නැතුව කතා කරන්න දෙනවා
public class ActiveAlertController {

    @Autowired
    private ActiveAlertRepository alertRepository;

    // 1. දැනට තියෙන ඔක්කොම Alerts ටික ගන්න (මැප් එක Load වෙද්දී)
    @GetMapping("/all")
    public List<ActiveAlert> getAllAlerts() {
        // අලුත්ම ඒවා උඩින් එන්න ඕනේ නම් Sort කරලා යවන්නත් පුළුවන්
        return alertRepository.findAll();
    }

    // 2. අලුත් Danger Zone එකක් Save කරන්න (Double Click කරද්දී)
    @PostMapping("/add")
    public ActiveAlert addAlert(@RequestBody ActiveAlert alert) {
        return alertRepository.save(alert);
    }

    // 3. තියෙන Zone එකක් මකන්න (Right Click කරද්දී)
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeAlert(@RequestParam Double lat, @RequestParam Double lon) {
        try {
            alertRepository.deleteByLatitudeAndLongitude(lat, lon);
            return ResponseEntity.ok().body("Alert removed successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error removing alert.");
        }
    }

    // 4. ඔක්කොම එකපාර මකන්න (Clear All Button එකට)
    @DeleteMapping("/clear-all")
    public ResponseEntity<?> clearAllAlerts() {
        alertRepository.deleteAll();
        return ResponseEntity.ok().body("All alerts cleared.");
    }
}