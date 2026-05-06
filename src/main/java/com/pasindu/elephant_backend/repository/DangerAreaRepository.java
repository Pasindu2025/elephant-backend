package com.pasindu.elephant_backend.repository;


import com.pasindu.elephant_backend.model.DangerArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DangerAreaRepository extends JpaRepository<DangerArea, Long> {
    // අවශ්‍ය නම් විතරක් custom methods මෙතනට දාන්න පුළුවන්.
    // දැනට JpaRepository එකේ තියෙන save, findAll, deleteById ඇති.
}