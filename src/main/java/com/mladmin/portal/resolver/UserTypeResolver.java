package com.mladmin.portal.resolver;

import com.mladmin.portal.entity.UserType;
import com.mladmin.portal.service.UserTypeService;

import lombok.RequiredArgsConstructor;

import com.mladmin.portal.dto.UserTypeInput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor  // Automatically injects final fields
public class UserTypeResolver {
 
    private UserTypeService userTypeService;

	// Manually adding the constructor
    public UserTypeResolver(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @QueryMapping
    public List<UserType> roles() {
        return userTypeService.getAllUserTypes();
    }
 
    @MutationMapping
    public UserType createUserType(@Argument UserTypeInput input) {
        // Ensure service method returns a valid UserType
        return userTypeService.createUserType(input);
    }

    @MutationMapping
    public UserType updateUserType(@Argument int id, @Argument UserTypeInput input) {
        return userTypeService.updateUserType(id, input);
    }

    @MutationMapping
    public Boolean deleteUserType(@Argument int id) {
        return userTypeService.deleteUserType(id);
    }
}
