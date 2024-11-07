package com.mladmin.portal.resolver;
 
import com.mladmin.portal.dto.AuthResponse;
import com.mladmin.portal.dto.LoginInput;
import com.mladmin.portal.dto.UserMasterInput;
import com.mladmin.portal.service.AuthService; 
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class AuthResolver {

    private  AuthService authService;

    public AuthResolver(AuthService authService) {
        this.authService = authService;
    } 

    @MutationMapping
    public AuthResponse login(@Argument LoginInput input) {
        return authService.login(input);
    }
    
    @ExceptionHandler(RuntimeException.class) 
    public AuthResponse handleRuntimeException(RuntimeException ex) {
        // Create a response object with null values for user and token
        AuthResponse response = new AuthResponse(ex.getMessage(), null, null);
        return response;
    }
}
