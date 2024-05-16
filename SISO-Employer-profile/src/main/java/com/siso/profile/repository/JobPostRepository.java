package com.siso.profile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.JobPostDto;
import com.siso.profile.entity.JobPostEntity;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Long>{

	

	Optional<JobPostEntity> findByJobPostId(Long jobPostId);

	void save(Optional<JobPostEntity> job);
	 @Query("SELECT DISTINCT e FROM JobPostEntity j JOIN j.applicants e WHERE j.employer.employerId = :employerId")
	    List<EmployeeEntity> findApplicantsByEmployerId(@Param("employerId") String employerId);
	 
		/*
		 * @Query("SELECT jp FROM JobPostEntity jp JOIN jp.applicants e WHERE e.employeeId = :employeeId"
		 * ) List<JobPostEntity> findJobsAppliedByEmployeeId(@Param("employeeId") String
		 * employeeId);
		 */
	 @Query("SELECT new com.siso.profile.entity.JobPostDto(jp.jobPostId, jp.jobRole, jp.company, jp.requiredExperience, jp.workLocation, jp.jobDescription, jp.requiredSkills, jp.responsibilities, jp.lastApplyDate, jp.datePosted, jp.postedBy, jp.modeOfJob, jp.contact, jp.category, jp.type, jp.ctc) " +
	           "FROM JobPostEntity jp JOIN jp.applicants e WHERE e.employeeId = :employeeId")
	    List<JobPostDto> findJobsAppliedByEmployeeId(@Param("employeeId") String employeeId);
	}



