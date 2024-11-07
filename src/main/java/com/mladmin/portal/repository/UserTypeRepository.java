package com.mladmin.portal.repository;

import com.mladmin.portal.entity.UserType;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    UserType findByName(String name); 
	Optional<UserType> findById(int id);
	boolean existsById(int id);
	void deleteById(int id);
}