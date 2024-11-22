package com.dc.portal.resolver;

import com.dc.portal.dto.AppointmentInput;
import com.dc.portal.entity.Appointment;
import com.dc.portal.service.AppointmentService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppointmentResolver {

    private final AppointmentService appointmentService;

    public AppointmentResolver(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Query: Get all appointments
    @QueryMapping
    public List<Appointment> getAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Query: Get an appointment by ID
    @QueryMapping
    public Appointment findAppointmentById(@Argument int id) {
        return appointmentService.getAppointmentById(id);
    }

    // Mutation: Create a new appointment
    @MutationMapping
    public Appointment createAppointment(@Argument AppointmentInput input) {
        return appointmentService.createAppointment(input);
    }

    // Mutation: Update an existing appointment
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
