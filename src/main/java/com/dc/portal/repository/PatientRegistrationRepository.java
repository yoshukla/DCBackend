package com.dc.portal.repository; 
import com.dc.portal.entity.PatientRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Integer> {
    boolean existsByEmail(String email); // To check if the email is already registered
}