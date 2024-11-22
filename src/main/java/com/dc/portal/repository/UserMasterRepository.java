package com.dc.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.portal.entity.UserMaster;

import java.util.Optional;

public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {

    Optional<UserMaster> findByEmailId(String emailId); // find by email
 	Optional<UserMaster> findByCompanyId(String companyId);
	Optional<UserMaster> findById(int id);
	boolean existsById(int id);
	void deleteById(int id);
	Optional<UserMaster> findByMobileNo(String mobileNo);
}
