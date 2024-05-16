package com.sisoeducation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.EmployeeEntity;

@Repository
public interface Employee_Repository extends JpaRepository<EmployeeEntity, String> {
	

	public Optional<EmployeeEntity> findByEmail(String email);

	public Optional<EmployeeEntity> findByEmployeeIdAndPassword(String empId, String password);
	
	public Optional<EmployeeEntity> findByEmployeeId(String id);

	
 }
