package com.dc.portal.dto;

import lombok.Data;

@Data
public class LoginInput {
	
    private String companyId;
    private String password;
    
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
     
    
 
    
}
