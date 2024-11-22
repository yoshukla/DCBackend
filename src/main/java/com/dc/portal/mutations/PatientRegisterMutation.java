package com.dc.portal.mutations;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import com.dc.portal.dto.PatientRegistrationInput;
import com.dc.portal.entity.PatientRegistration;
import com.dc.portal.service.PatientRegistrationService;

@Component
public class PatientRegisterMutation {

    @Autowired
    private PatientRegistrationService patientService;

    // Register a new patient
    @MutationMapping
    public PatientRegistration registerPatient(@Argument PatientRegistrationInput input) {
        return patientService.registerPatient(input);
    }

    // Update an existing patient
    @MutationMapping
    public PatientRegistration updatePatient(@Argument int id, @Argument PatientRegistrationInput input) {
        return patientService.updatePatient(id, input);
    }

    // Delete a patient by ID
    @MutationMapping
    public Boolean deletePatient(@Argument int id) {
        return patientService.deletePatient(id);
    }

    // Get all patients
    @QueryMapping
    public List<PatientRegistration> getAllPatients() {
        return patientService.getAllPatients();
    }
}