package com.siso.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.JobPostDto;
import com.siso.profile.entity.JobPostEntity;
import com.siso.profile.repository.EmployeeEntityRepo;
import com.siso.profile.repository.JobPostRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeEntityRepo employeeentityrepo;

	@Autowired
	public JobPostRepository jobpostrepo;

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		// TODO Auto-generated method stub
		return employeeentityrepo.findAll();
	}

	@Override
	public EmployeeEntity getemployee(String employeeId) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> employ = employeeentityrepo.findByEmployeeId(employeeId);
		if (employ.isPresent()) {
			EmployeeEntity emp = employ.get();
			return emp;
		} else

			throw new RuntimeException("Employee Data Not Found");
	}

	@Override
	public String deleteEmployee(String employeeId) {
		// TODO Auto-generated method stub

		Optional<EmployeeEntity> exists = employeeentityrepo.findByEmployeeId(employeeId);
		if (exists.isPresent()) {
			employeeentityrepo.deleteById(employeeId);

			return "Successfully deleted employer Data";
		}
		return "Failed to delete employer data";
	}

	@Override
	public void applyForJob(Long jobPostId, String employeeId) {
		JobPostEntity jobPost = jobpostrepo.findById(jobPostId)
				.orElseThrow(() -> new IllegalArgumentException("Job post not found with id: " + jobPostId));

		EmployeeEntity applicant = employeeentityrepo.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));

		jobPost.addApplicant(applicant);
		jobpostrepo.save(jobPost);
	}

	@Override
	public List<EmployeeEntity> getApplicantsByEmployer(String employerId) {
		return jobpostrepo.findApplicantsByEmployerId(employerId);
	}

	@Override
	public List<JobPostDto> getJobsAppliedByEmployee(String employeeId) {

		return jobpostrepo.findJobsAppliedByEmployeeId(employeeId);
	}

}
