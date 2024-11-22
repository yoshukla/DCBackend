package com.dc.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dc.portal.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    UserType findByName(String name); 
	Optional<UserType> findById(int id);
	boolean existsById(int id);
	void deleteById(int id);
}