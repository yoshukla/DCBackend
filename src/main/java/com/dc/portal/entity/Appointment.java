package com.dc.portal.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "APPOINTMNETS")
public class Appointment {
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "userid", nullable = true)
	    private int userId;

	    @Column(name = "hospital", length = 500, nullable = true)
	    private String hospital;

	    @Column(name = "patient_name", length = 1000, nullable = true)
	    private String patientName;

	    @Column(name = "doctor_name", length = 1000, nullable = true)
	    private String doctorName;

	    @Column(name = "appointment_date", nullable = true)
	    private LocalDateTime appointmentDate;

	    @Column(name = "chief_complaint", columnDefinition = "TEXT", nullable = true)
	    private String chiefComplaint;

	    @Column(name = "body_temp", length = 10, nullable = true)
	    private String bodyTemp;

	    @Column(name = "heart_rate", length = 10, nullable = true)
	    private String heartRate;

	    @Column(name = "respiration_rate", length = 10, nullable = true)
	    private String respirationRate;

	    @Column(name = "blood_pressure", length = 10, nullable = true)
	    private String bloodPressure;

	    @Column(name = "sp_o2", length = 10, nullable = true)
	    private String spO2;

	    @Column(name = "weight", length = 10, nullable = true)
	    private String weight;

	    @Column(name = "height", length = 10, nullable = true)
	    private String height;

	    @Column(name = "doctor_notes", columnDefinition = "TEXT", nullable = true)
	    private String doctorNotes;

	    @Column(name = "remarks", length = 500, nullable = true)
	    private String remarks;

	    @Column(name = "created_on", nullable = true)
	    private LocalDateTime createdOn;

	    @Column(name = "updated_on", nullable = true)
	    private LocalDateTime updatedOn;

	    @Column(name = "created_by", nullable = true)
	    private String createdBy;

	    @Column(name = "updated_by", nullable = true)
	    private String updatedBy;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getHospital() {
			return hospital;
		}

		public void setHospital(String hospital) {
			this.hospital = hospital;
		}

		public String getPatientName() {
			return patientName;
		}

		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}

		public String getDoctorName() {
			return doctorName;
		}

		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}

		public LocalDateTime getAppointmentDate() {
			return appointmentDate;
		}

		public void setAppointmentDate(LocalDateTime appointmentDate) {
			this.appointmentDate = appointmentDate;
		}

		public String getChiefComplaint() {
			return chiefComplaint;
		}

		public void setChiefComplaint(String chiefComplaint) {
			this.chiefComplaint = chiefComplaint;
		}

		public String getBodyTemp() {
			return bodyTemp;
		}

		public void setBodyTemp(String bodyTemp) {
			this.bodyTemp = bodyTemp;
		}

		public String getHeartRate() {
			return heartRate;
		}

		public void setHeartRate(String heartRate) {
			this.heartRate = heartRate;
		}

		public String getRespirationRate() {
			return respirationRate;
		}

		public void setRespirationRate(String respirationRate) {
			this.respirationRate = respirationRate;
		}

		public String getBloodPressure() {
			return bloodPressure;
		}

		public void setBloodPressure(String bloodPressure) {
			this.bloodPressure = bloodPressure;
		}

		public String getSpO2() {
			return spO2;
		}

		public void setSpO2(String spO2) {
			this.spO2 = spO2;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}

		public String getDoctorNotes() {
			return doctorNotes;
		}

		public void setDoctorNotes(String doctorNotes) {
			this.doctorNotes = doctorNotes;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public LocalDateTime getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(LocalDateTime createdOn) {
			this.createdOn = createdOn;
		}

		public LocalDateTime getUpdatedOn() {
			return updatedOn;
		}

		public void setUpdatedOn(LocalDateTime updatedOn) {
			this.updatedOn = updatedOn;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		} 
 
}
