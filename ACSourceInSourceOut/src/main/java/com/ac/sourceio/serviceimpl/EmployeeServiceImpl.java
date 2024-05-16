package com.ac.sourceio.serviceimpl;

import java.util.Optional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac.sourceio.Entity.AddEmployementEntity;
import com.ac.sourceio.Entity.EmployeeEntity;
import com.ac.sourceio.Repository.AddEmployementRepo;
import com.ac.sourceio.Repository.AddressRepo;
import com.ac.sourceio.Repository.EmployeeRepo;
import com.ac.sourceio.service.EmployeeService;

import io.jsonwebtoken.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private AddEmployementRepo addEmployementRepo;

	@Override
	public EmployeeEntity findByemployeeId(String employeeId) {

		return employeeRepo.findByEmployeeId(employeeId);
	}



	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employee) throws IOException {

		employeeRepo.save(employee);

		return employee;
	}



	@Override
	public AddEmployementEntity createEmployment(String employeeId, AddEmployementEntity employment) {
		EmployeeEntity empEntity=employeeRepo.findByEmployeeId(employeeId);
		if (empEntity!=null) {
			employment.setEmployee(empEntity);
			addEmployementRepo.save(employment);
			return employment;
		}
		return null;
	}





}
