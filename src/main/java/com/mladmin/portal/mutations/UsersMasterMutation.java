package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.UserMasterInput;
import com.mladmin.portal.entity.UserMaster;
import com.mladmin.portal.service.UserMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class UsersMasterMutation {

    @Autowired
    private UserMasterService userMasterService;

    // Create a new UserMaster
    @MutationMapping
    public UserMaster createUser(@Argument UserMasterInput input) {
        return userMasterService.createUser(input);
    }

    // Update an existing UserMaster
    @MutationMapping
    public UserMaster updateUser(@Argument int id, @Argument UserMasterInput input) {
        return userMasterService.updateUser(id, input);
    }

    // Delete a UserMaster by ID
    @MutationMapping
    public Boolean deleteUser(@Argument int id) {
        return userMasterService.deleteUser(id);
    }
}
