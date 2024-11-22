package com.dc.portal.dto; // Ensure this matches your package structure

import java.time.LocalDateTime;

public class AppointmentInput {
	 
		private int id;
	    private int userId;
	    private String hospital;
	    private String patientName;
	    private String doctorName;
	    private LocalDateTime appointmentDate;
	    private String chiefComplaint;
	    private String bodyTemp;
	    private String heartRate;
	    private String respirationRate;
	    private String bloodPressure;
	    private String spO2;
	    private String weight;
	    private String height;
	    private String doctorNotes;
	    private String remarks;
	    
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
	    
	     
	   
}
