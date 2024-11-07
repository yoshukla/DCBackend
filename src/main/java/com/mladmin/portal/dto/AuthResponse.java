package com.mladmin.portal.dto;

import com.mladmin.portal.entity.UserMaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
public class AuthResponse {
	
	   private String message;
	    private UserMaster user;
	    private String token;
	
	    // Explicit constructor with all fields
	public AuthResponse(String message, UserMaster user, String token) {
	    this.message = message;
	    this.user = user;
	    this.token = token;
	}
    // Getters and Setters... 

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserMaster getUser() {
		return user;
	}

	public void setUser(UserMaster user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

    
}
