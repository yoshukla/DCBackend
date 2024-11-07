package com.mladmin.portal.entity;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class UserMaster {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_id", unique = true, nullable = false)
    private String companyId; // changed to String for alphanumeric values

    private String password;
    
    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId; // email is unique
    
    @Column(name = "abhaid", unique = true, nullable = false)
    private String abhaid;
    
    private String firstName;
    private String lastName;
    private String gender;
    
    @Column(name = "mobile_no", unique = true, nullable = false)
    private String mobileNo; // mobile number should be long
    
    private String city;
    private String address;
    private String state;
    
    private String licenseRegistrationNo;
    private String qualification;
    private String collageName;
    private Integer courseYear;
    
    @Column(name = "user_type_id")
    private int userTypeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAbhaid() {
		return abhaid;
	}

	public void setAbhaid(String abhaid) {
		this.abhaid = abhaid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	} 
	
	public String getLicenseRegistrationNo() {
		return licenseRegistrationNo;
	}

	public void setLicenseRegistrationNo(String licenseRegistrationNo) {
		this.licenseRegistrationNo = licenseRegistrationNo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public Integer getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(Integer courseYear) {
		this.courseYear = courseYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abhaid, emailId, mobileNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMaster other = (UserMaster) obj;
		return Objects.equals(abhaid, other.abhaid) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(mobileNo, other.mobileNo);
	}

	
}
