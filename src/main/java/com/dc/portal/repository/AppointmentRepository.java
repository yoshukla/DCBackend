package com.dc.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.portal.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> { 
	boolean existsById(int id); 
	void deleteById(int id);
	Optional<Appointment> findById(int id);  
}
