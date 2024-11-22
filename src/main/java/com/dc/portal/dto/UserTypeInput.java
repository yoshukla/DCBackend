package com.dc.portal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTypeInput {
    
    private String name;  // Role name, e.g., "ADMIN", "USER"

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}