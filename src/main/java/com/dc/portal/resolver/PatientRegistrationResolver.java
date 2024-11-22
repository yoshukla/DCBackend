package com.dc.portal.resolver;

import com.dc.portal.dto.PatientRegistrationInput;
import com.dc.portal.entity.PatientRegistration;
import com.dc.portal.service.PatientRegistrationService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PatientRegistrationResolver {

    private final PatientRegistrationService patientService;

    public PatientRegistrationResolver(PatientRegistrationService patientService) {
        this.patientService = patientService;
    }

    // Query: Get all patients
    @QueryMapping
    public List<PatientRegistration> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Query: Get a patient by ID
    @QueryMapping
    public PatientRegistration getPatientById(@Argument int id) {
        return patientService.getPatientById(id);
    }

    // Mutation: Register a new patient
    @MutationMapping
    public PatientRegistration registerPatient(@Argument PatientRegistrationInput input) {
        return patientService.registerPatient(input);
    }

    // Mutation: Update an existing patient
    @MutationMapping
    public PatientRegistration updatePatient(@Argument int id, @Argument PatientRegistrationInput input) {
        return patientService.updatePatient(id, input);
    }

    // Mutation: Delete a patient
    @MutationMapping
    public Boolean deletePatient(@Argument int id) {
        return patientService.deletePatient(id);
    }
}
