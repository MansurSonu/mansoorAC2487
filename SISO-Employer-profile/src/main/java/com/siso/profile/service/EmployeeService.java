package com.siso.profile.service;

import java.util.List;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.JobPostDto;

public interface EmployeeService {

	public List<EmployeeEntity> findAllEmployees();

	public String deleteEmployee(String employeeId);

	public EmployeeEntity getemployee(String employeeId);

//	public EmployeeEntity save(String employeeId, List<JobPostEntity> apply) ;
	public void applyForJob(Long jobPostId, String employeeId);

	public List<EmployeeEntity> getApplicantsByEmployer(String employerId);
//	public List<JobPostEntity> getAllJobsAppliedByEmployee(String employeeId);
	  public List<JobPostDto> getJobsAppliedByEmployee(String employeeId);
}