package com.sisoeducation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.JobsSave;

@Repository
public interface JobsSaveRepo extends JpaRepository<JobsSave, Integer> {
	@Query("SELECT js FROM JobsSave js WHERE js.employee.id = :employeeId")
	public List<JobsSave> findByEmployeeId(String employeeId);

}
