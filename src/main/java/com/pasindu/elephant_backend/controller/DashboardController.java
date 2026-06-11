package com.pasindu.elephant_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*") // 👈 ෆෝන් ඇප් එකට කනෙක්ට් වෙන්න මේක අනිවාර්යයෙන්ම ඕනේ!
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/summary")
    public Map<String, Object> getDashboardSummary() {
        Map<String, Object> response = new HashMap<>();

        // 1. Default අගයන් සෙට් කිරීම (මොකක් හරි Error එකක් ආවොත් 0 යන්න)
        response.put("activeAlerts", 0);
        response.put("dangerAreas", 0);
        response.put("injuredElephants", 0);
        response.put("fenceIssues", 0);

        // 2. Stats ටික වෙන වෙනම ගන්නවා (එකක් අවුල් ගියත් අනිත් ඒවා වැඩ කරනවා)
        try { response.put("activeAlerts", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM active_alerts", Integer.class)); } catch (Exception e) {}
        try { response.put("dangerAreas", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM danger_areas", Integer.class)); } catch (Exception e) {}
        try { response.put("injuredElephants", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM injured_elephants", Integer.class)); } catch (Exception e) {}
        try { response.put("fenceIssues", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM fence WHERE status != 'OK'", Integer.class)); } catch (Exception e) {}

        // 3. Table එකට ඕන Data ටික ගන්නවා
        List<Map<String, Object>> recentAlerts = new ArrayList<>();

        // අලි alerts
        try {
            recentAlerts.addAll(jdbcTemplate.queryForList("SELECT place_name as location, 'Elephant Spotted' as type, 'Active' as status FROM active_alerts ORDER BY id DESC LIMIT 2"));
        } catch (Exception e) { System.out.println("Table Error 1: " + e.getMessage()); }

        // වැටවල් කැඩුණු ඒවා
        try {
            recentAlerts.addAll(jdbcTemplate.queryForList("SELECT place_name as location, 'Fence Issue' as type, status as status FROM fence WHERE status != 'OK' ORDER BY id DESC LIMIT 2"));
        } catch (Exception e) { System.out.println("Table Error 2: " + e.getMessage()); }

        // තුවාල වුණු සත්තු
        try {
            recentAlerts.addAll(jdbcTemplate.queryForList("SELECT 'Unknown Area' as location, 'Injured Elephant' as type, IF(severity LIKE '%Critical%', 'Critical', 'Active') as status FROM injured_elephants ORDER BY id DESC LIMIT 2"));
        } catch (Exception e) { System.out.println("Table Error 3: " + e.getMessage()); }

        // ඔක්කොම ටික response එකට දาනවා
        response.put("recentTable", recentAlerts);

        return response;
    }
}