package com.ac.sourceio.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Applied_jobs_Institute")
public class JobsAppliedEntity {

	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long appliedId;
	    
	   @JsonBackReference
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "job_id")
	    private JobPostEntity jobPost;
	    
	    @JsonBackReference("employee-jobsapplied")
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "employee_id")
	    private EmployeeEntity employee;

	    public JobsAppliedEntity() {

	    }

		public JobsAppliedEntity(Long appliedId, JobPostEntity jobPost, EmployeeEntity employee) {
			super();
			this.appliedId = appliedId;
			this.jobPost = jobPost;
			this.employee = employee;
		}

		public Long getAppliedId() {
			return appliedId;
		}

		public void setAppliedId(Long appliedId) {
			this.appliedId = appliedId;
		}

		public JobPostEntity getJobPost() {
			return jobPost;
		}

		public void setJobPost(JobPostEntity jobPost) {
			this.jobPost = jobPost;
		}

		public EmployeeEntity getEmployee() {
			return employee;
		}

		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}
	    

}
