package com.dc.portal.mutations;

import com.dc.portal.dto.UserTypeInput;
import com.dc.portal.entity.UserType;
import com.dc.portal.service.UserTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class UserTypeMutation {

    @Autowired
    private UserTypeService userTypeService;

    // Create a new UserType
    @MutationMapping
    public UserType createUserType(@Argument UserTypeInput input) {
    	
    	System.out.println("Saving UserType: " + input.getName()); 
        return userTypeService.createUserType(input);  // Calling the service layer
    }

    // Update an existing UserType
    @MutationMapping
    public UserType updateUserType(@Argument int id, @Argument UserTypeInput input) {
        return userTypeService.updateUserType(id, input);
    }

    // Delete an existing UserType by ID
    @MutationMapping
    public Boolean deleteUserType(@Argument int id) {
        return userTypeService.deleteUserType(id);
    }
}
