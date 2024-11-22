package com.dc.portal.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "USER_TYPE")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false) // Ensure 'name' is unique and non-null
    private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
  
    
    
}