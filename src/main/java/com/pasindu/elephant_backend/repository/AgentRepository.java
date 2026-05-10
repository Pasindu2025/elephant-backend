package com.pasindu.elephant_backend.repository;

import com.pasindu.elephant_backend.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, String> {


    Optional<Agent> findByUsername(String username);
}