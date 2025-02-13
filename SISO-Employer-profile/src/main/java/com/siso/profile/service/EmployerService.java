package com.siso.profile.service;

import java.util.List;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.EmployerEntity;
import com.siso.profile.entity.JobPostEntity;
import com.siso.profile.entity.ProjectPost;

public interface EmployerService {

	public EmployerEntity registeremployer(EmployerEntity employer);

	public EmployerEntity getemployer(String employerId);

	public List<EmployerEntity> getallemployers();

	String loginEmployer(String companyEmail, String password);

	public String deleteEmployerId(String employerId);

	// public EmployerEntity updateemployer( String employerId, EmployerEntity
	// employer);

	// JobPost //

//	public Boolean saveApply(JobPostEntity apply, String employeeId,String employeerId);

	public EmployerEntity addJobpost(String employerId, JobPostEntity jobpost);

	public List<JobPostEntity> getAllJobposts();

	public String deleteJobpostById(Long jobPostId);

	public JobPostEntity findByJobPostId(Long jobPostId);

	// Project Post//

	public EmployerEntity addProject(String employerId, ProjectPost projects);

	public List<ProjectPost> getallProjects();

	public ProjectPost findByProjectId(Long projectId);

	
}
