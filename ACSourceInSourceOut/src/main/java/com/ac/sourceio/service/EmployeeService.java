package com.ac.sourceio.service;

import java.io.IOException;

import com.ac.sourceio.Entity.AddEmployementEntity;
import com.ac.sourceio.Entity.AddEmployementEntity;
import com.ac.sourceio.Entity.AddEmployementEntity;
import com.ac.sourceio.Entity.AddEmployementEntity;
import com.ac.sourceio.Entity.AddEmployementEntity;
import com.ac.sourceio.Entity.EmployeeEntity;

public interface EmployeeService {

	public EmployeeEntity createEmployee(EmployeeEntity employee) throws IOException;

	public EmployeeEntity findByemployeeId(String employeeId);


	
	public AddEmployementEntity createEmployment(String employeeId, AddEmployementEntity employment);
	
	 
}
