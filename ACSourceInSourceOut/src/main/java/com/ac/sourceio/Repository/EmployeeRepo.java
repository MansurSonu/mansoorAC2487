package com.ac.sourceio.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac.sourceio.Entity.EmployeeEntity;


@Repository

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String>{

	public EmployeeEntity findByEmployeeId(String employeeId);
	
	
	public EmployeeEntity findByEmailAndPassword(String email,String password);
	

	public EmployeeEntity findByphoneAndPassword(String phone, String password);

	public boolean existsByEmail(String email);

	public EmployeeEntity findByEmail(String email); 
		
	public EmployeeEntity findByphone(String phone);

	boolean existsByphone(String phone);

	public String deleteByEmployeeId(String employeeId);
 
	// Optional<EmployeeEntity> findByEmployeeId(String employeeId);

	
	
}
