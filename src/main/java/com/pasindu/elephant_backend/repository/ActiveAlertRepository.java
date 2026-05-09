package com.pasindu.elephant_backend.repository;



import com.pasindu.elephant_backend.model.ActiveAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ActiveAlertRepository extends JpaRepository<ActiveAlert, Long> {

    // Map එකේ තියෙන Lat/Lon වලින් හොයලා DB එකෙන් මකන්න
    @Transactional
    void deleteByLatitudeAndLongitude(Double latitude, Double longitude);
}
