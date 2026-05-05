package com.pasindu.elephant_backend.repository;

import com.pasindu.elephant_backend.model.Fence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;

public interface FenceRepository extends JpaRepository<Fence, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Fence f WHERE ABS(f.latitude - :lat) < 0.0001 AND ABS(f.longitude - :lon) < 0.0001")
    void deleteApprox(@Param("lat") double lat, @Param("lon") double lon);
}