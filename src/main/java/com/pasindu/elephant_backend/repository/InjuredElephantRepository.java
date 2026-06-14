package com.pasindu.elephant_backend.repository;

import com.pasindu.elephant_backend.model.InjuredElephant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InjuredElephantRepository extends JpaRepository<InjuredElephant, Long> {

    // 📍 Coordinates (Lat, Lon) වලට ඉතාම කිට්ටු රෙකෝඩ් එක ඩේටාබේස් එකෙන් මකන Custom Query එක
    @Transactional
    @Modifying
    @Query("DELETE FROM InjuredElephant i WHERE ABS(i.latitude - :lat) < 0.0001 AND ABS(i.longitude - :lon) < 0.0001")
    void deleteByCoordinates(@Param("lat") double lat, @Param("lon") double lon);
}