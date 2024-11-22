package com.dc.portal.resolver;

import com.dc.portal.dto.UserMasterInput;
import com.dc.portal.entity.UserMaster;
import com.dc.portal.service.UserMasterService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserMasterResolver {

    private final UserMasterService userMasterService;

    public UserMasterResolver(UserMasterService userMasterService) {
        this.userMasterService = userMasterService;
    }

    // Query: Get all users
    @QueryMapping
    public List<UserMaster> findAllUsers() {
        return userMasterService.findAllUsers();
    }

    // Query: Get a user by ID
    @QueryMapping
    public UserMaster findUserById(@Argument int id) {
        return userMasterService.findUserById(id);
    }

    // Mutation: Create a new user
    @MutationMapping
    public UserMaster createUser(@Argument UserMasterInput input) {
        return userMasterService.createUser(input);
    }

    // Mutation: Update an existing user
    @MutationMapping
    public UserMaster updateUser(@Argument int id, @Argument UserMasterInput input) {
        return userMasterService.updateUser(id, input);
    }

    // Mutation: Delete a user
    @MutationMapping
    public Boolean deleteUser(@Argument int id) {
        return userMasterService.deleteUser(id);
    }
}
