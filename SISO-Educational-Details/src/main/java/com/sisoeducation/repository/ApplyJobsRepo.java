package com.sisoeducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.ApplyJobs;



@Repository
public interface ApplyJobsRepo extends JpaRepository<ApplyJobs, Integer> {
	@Query("SELECT aJ FROM ApplyJobs aJ WHERE aJ.employee.id = :employeeId")
	public List<ApplyJobs> findByEmployeeId(String employeeId);
	
}
