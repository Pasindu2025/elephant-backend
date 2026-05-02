package com.pasindu.elephant_backend.repository;

import com.pasindu.elephant_backend.model.InjuredElephant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InjuredElephantRepository extends JpaRepository<InjuredElephant, Long> {
    // Database එකේ CRUD (Create, Read, Update, Delete) වැඩ ටික Spring Boot මගින් මෙතනට ලබා දෙනවා.
}