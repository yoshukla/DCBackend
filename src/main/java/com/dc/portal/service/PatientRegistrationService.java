package com.dc.portal.service;

import com.dc.portal.dto.PatientRegistrationInput;
import com.dc.portal.entity.PatientRegistration;
import com.dc.portal.repository.PatientRegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientRegistrationService {

    private final PatientRegistrationRepository repository;

    public PatientRegistrationService(PatientRegistrationRepository repository) {
        this.repository = repository;
    }

    // Register a new patient
    public PatientRegistration registerPatient(PatientRegistrationInput input) {
        // Check if email already exists
        if (repository.existsByEmail(input.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }

        // Check if passwords match
        if (!input.getPassword().equals(input.getConfirmPassword())) {
            throw new RuntimeException("Password and Confirm Password do not match");
        }

        // Map DTO to Entity
        PatientRegistration patient = new PatientRegistration();
        BeanUtils.copyProperties(input, patient);

        // Save to database
        return repository.save(patient);
    }

    // Update patient by ID
    public PatientRegistration updatePatient(int id, PatientRegistrationInput input) {
        PatientRegistration existingPatient = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Update the fields
        existingPatient.setName(input.getName());
        existingPatient.setEmail(input.getEmail());
        existingPatient.setMbno(input.getMbno());
        existingPatient.setCity(input.getCity());
        existingPatient.setState(input.getState());
        existingPatient.setDob(input.getDob());
        existingPatient.setSex(input.getSex());

        // Only update password if provided
        if (input.getPassword() != null && input.getConfirmPassword() != null) {
            if (!input.getPassword().equals(input.getConfirmPassword())) {
                throw new RuntimeException("Password and Confirm Password do not match");
            }
            existingPatient.setPassword(input.getPassword());
        }

        return repository.save(existingPatient);
    }

    // Delete a patient by ID
    public boolean deletePatient(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Patient not found");
        }
        repository.deleteById(id);
        return true;
    }

    // Get all patients
    public List<PatientRegistration> getAllPatients() {
        return repository.findAll();
    }

 // Get  patient by id
    public PatientRegistration getPatientById(int id) {
        // Fetch patient by ID or throw an exception if not found
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }
	 
}
