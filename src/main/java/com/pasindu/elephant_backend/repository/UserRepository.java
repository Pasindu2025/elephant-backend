package com.pasindu.elephant_backend.repository;

import com.pasindu.elephant_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // check whther have any user mach username and password
    User findByUsernameAndPassword(String username, String password);
}