package com.dc.portal.service;

import com.dc.portal.dto.UserTypeInput;
import com.dc.portal.entity.UserType;
import com.dc.portal.repository.UserTypeRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;

    // Manually adding the constructor
    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public UserType createUserType(UserTypeInput input) {
    	 
    	 if (input.getName() == null || input.getName().isEmpty()) {
    	        throw new IllegalArgumentException("User Type name must not be null or empty");
    	    }

    	    // Check if a UserType with the same name already exists
    	    UserType existingUserType = userTypeRepository.findByName(input.getName());
    	    if (existingUserType != null) {
    	        throw new RuntimeException("User Type with this name already exists");
    	    }

    	    // Create and save the new UserType
    	    UserType userType = new UserType();
    	    userType.setName(input.getName());

    	    try {
    	        // Attempt to save the UserType
    	        UserType savedUserType = userTypeRepository.save(userType);

    	        // Return the saved UserType, ensuring it's not null
    	        if (savedUserType == null) {
    	            throw new RuntimeException("Failed to create UserType");
    	        }

    	        return savedUserType; // Return the valid, non-null UserType
    	    } catch (Exception e) {
    	        // Handle any errors that occur during the saving process
    	        throw new RuntimeException("Error creating UserType: " + e.getMessage());
    	    }
    }

    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    public UserType getUserTypeById(int id) {
        return userTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Type not found"));
    }

    public UserType updateUserType(int id, UserTypeInput roleInput) {
        UserType role = getUserTypeById(id);
        role.setName(roleInput.getName());
        return userTypeRepository.save(role);
    }

    public Boolean deleteUserType(int id) {
        if (userTypeRepository.existsById(id)) {
        	userTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
