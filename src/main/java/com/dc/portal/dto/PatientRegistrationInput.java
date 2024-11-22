package com.dc.portal.dto; // Ensure this matches your package structure

public class PatientRegistrationInput {
	
		private String name;
	    private String email;
	    private String mbno;
	    private String city;
	    private String state;
	    private String dob; // Assuming date is stored as a string in format "yyyy-MM-dd"
	    private String sex;
	    private String password;
	    private String confirmPassword;
	    
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMbno() {
			return mbno;
		}
		public void setMbno(String mbno) {
			this.mbno = mbno;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		
		@Override
		public String toString() {
			return "PatientInput [name=" + name + ", email=" + email + ", mbno=" + mbno + ", city=" + city + ", state="
					+ state + ", dob=" + dob + ", sex=" + sex + ", password=" + password + ", confirmPassword="
					+ confirmPassword + "]";
		}
		    
}
