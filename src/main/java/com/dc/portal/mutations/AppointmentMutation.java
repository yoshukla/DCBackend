package com.dc.portal.mutations;

import com.dc.portal.dto.AppointmentInput;
import com.dc.portal.entity.Appointment;
import com.dc.portal.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMutation {

    @Autowired
    private AppointmentService appointmentService;

    // Create a new Appointment
    @MutationMapping
    public Appointment createAppointment(@Argument AppointmentInput input) {
        return appointmentService.createAppointment(input);
    }

    // Update an existing Appointment
    @MutationMapping
    public Appointment updateAppointment(@Argument int id, @Argument AppointmentInput input) {
        return appointmentService.updateAppointment(id, input);
    }
     
    // Mutation: Delete an appointment
    @MutationMapping
     public Boolean deleteAppointment(@Argument int id) { 
     return appointmentService.deleteAppointment(id); 
    }
 
}
