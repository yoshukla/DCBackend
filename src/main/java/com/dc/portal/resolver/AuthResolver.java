package com.dc.portal.resolver;
 
import com.dc.portal.dto.AuthResponse;
import com.dc.portal.dto.LoginInput;
import com.dc.portal.dto.UserMasterInput;
import com.dc.portal.service.AuthService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class AuthResolver {

    private final AuthService authService;

    // Constructor-based Dependency Injection
    public AuthResolver(AuthService authService) {
        this.authService = authService;
    }
 
    @MutationMapping
    public AuthResponse login(@Argument LoginInput input) {
        try {
            return authService.login(input);
        } catch (AuthenticationException ex) {
            return new AuthResponse(null, null, ex.getMessage());
        } catch (RuntimeException ex) {
            return new AuthResponse(null, null, "An unexpected error occurred");
        }
    }
}