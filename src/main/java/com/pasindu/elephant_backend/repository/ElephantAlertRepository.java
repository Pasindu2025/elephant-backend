package com.pasindu.elephant_backend.repository;

import com.pasindu.elephant_backend.model.ElephantAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElephantAlertRepository extends JpaRepository<ElephantAlert, Long> {
}