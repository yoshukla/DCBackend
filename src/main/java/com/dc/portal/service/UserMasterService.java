package com.dc.portal.service;

import com.dc.portal.dto.UserMasterInput;
import com.dc.portal.entity.UserMaster;
import com.dc.portal.repository.UserMasterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMasterService {

    @Autowired
    private UserMasterRepository userMasterRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    // Create UserMaster
    public UserMaster createUser(UserMasterInput input) {
    	
    	// Check if the email or phone number already exists
        if (userMasterRepository.findByEmailId(input.getEmailId()).isPresent() || 
            userMasterRepository.findByMobileNo(input.getMobileNo()).isPresent()) {
            // Return a response with an error message if duplicate email or phone number exists
            UserMaster errorUser = new UserMaster();
            errorUser.setEmailId("Email or Phone number already exists");
            return errorUser;
        }
        
        // Generate companyId if not provided
        String companyId = input.getCompanyId() != null ? input.getCompanyId() : generateCompanyId();

        UserMaster userMaster = new UserMaster();
        userMaster.setCompanyId(companyId);
        userMaster.setEmailId(input.getEmailId());
        userMaster.setPassword(passwordEncoder.encode(input.getPassword()));  // Encrypt password
        userMaster.setAbhaid(input.getAbhaid());
        userMaster.setFirstName(input.getFirstName());
        userMaster.setLastName(input.getLastName());
        userMaster.setGender(input.getGender());
        userMaster.setMobileNo(input.getMobileNo());
        userMaster.setCity(input.getCity());
        userMaster.setAddress(input.getAddress());
        userMaster.setState(input.getState());
        //qualification
        userMaster.setLicenseRegistrationNo(input.getLicenseRegistrationNo());
        userMaster.setQualification(input.getQualification());
        userMaster.setCollageName(input.getCollageName());
        userMaster.setCourseYear(input.getCourseYear());

        // Set default userTypeId to 2 if it's not provided
        userMaster.setUserTypeId(input.getUserTypeId() > 0 ? input.getUserTypeId() : 2);

        return userMasterRepository.save(userMaster);
    }

    // Get All Users
    public List<UserMaster> findAllUsers() {
        return userMasterRepository.findAll();
    }

    // Get User by ID
    public UserMaster findUserById(int id) {
        Optional<UserMaster> userMaster = userMasterRepository.findById(id);
        if (userMaster.isPresent()) {
            return userMaster.get();
        }
        return null;
    }

    // Update UserMaster
    public UserMaster updateUser(int id, UserMasterInput input) {
        UserMaster userMaster = findUserById(id);
        if (userMaster != null) { 
            userMaster.setFirstName(input.getFirstName());
            userMaster.setLastName(input.getLastName());
            userMaster.setGender(input.getGender());
            userMaster.setMobileNo(input.getMobileNo());
            userMaster.setCity(input.getCity());
            userMaster.setAddress(input.getAddress());
            userMaster.setState(input.getState()); 
          //qualification
            userMaster.setLicenseRegistrationNo(input.getLicenseRegistrationNo());
            userMaster.setQualification(input.getQualification());
            userMaster.setCollageName(input.getCollageName());
            userMaster.setCourseYear(input.getCourseYear());
            return userMasterRepository.save(userMaster);
        }
        return null;
    }

    // Delete UserMaster
    public boolean deleteUser(int id) {
        if (userMasterRepository.existsById(id)) {
            userMasterRepository.deleteById(id);
            return true;
        }
        return false;
    }
     
    private String generateCompanyId() {
        // Example logic to generate alphanumeric company ID: MBD000001
        String prefix = "MBD";
        int number = (int)(Math.random() * 1000000); // Generate a random number between 0 and 999999
        return prefix + String.format("%06d", number);  // Format to always have 6 digits
    }

	 

}
