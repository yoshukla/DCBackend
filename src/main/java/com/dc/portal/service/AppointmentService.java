package com.dc.portal.service;

import com.dc.portal.dto.AppointmentInput; 
import com.dc.portal.entity.Appointment; 
import com.dc.portal.repository.AppointmentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

	@Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(AppointmentInput dto) {
        Appointment appointment = mapToEntity(dto);
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(int id, AppointmentInput dto) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            updateEntityFromDTO(appointment, dto);
            return appointmentRepository.save(appointment);
        }
        throw new RuntimeException("Appointment not found with id: " + id);
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    

    @Transactional // Add this annotation 
    public Boolean deleteAppointment(int id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        } 
       return false; 
    }

    private Appointment mapToEntity(AppointmentInput dto) {
        Appointment appointment = new Appointment();
        updateEntityFromDTO(appointment, dto);
        return appointment;
    }

    private void updateEntityFromDTO(Appointment appointment, AppointmentInput dto) {
        appointment.setUserId(dto.getUserId());
        appointment.setHospital(dto.getHospital());
        appointment.setPatientName(dto.getPatientName());
        appointment.setDoctorName(dto.getDoctorName());
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setChiefComplaint(dto.getChiefComplaint());
        appointment.setBodyTemp(dto.getBodyTemp());
        appointment.setHeartRate(dto.getHeartRate());
        appointment.setRespirationRate(dto.getRespirationRate());
        appointment.setBloodPressure(dto.getBloodPressure());
        appointment.setSpO2(dto.getSpO2());
        appointment.setWeight(dto.getWeight());
        appointment.setHeight(dto.getHeight());
        appointment.setDoctorNotes(dto.getDoctorNotes());
        appointment.setRemarks(dto.getRemarks()); 
    } 
}
