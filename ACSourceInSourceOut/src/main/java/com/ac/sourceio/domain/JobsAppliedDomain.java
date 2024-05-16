package com.ac.sourceio.domain;

import com.ac.sourceio.Entity.EmployeeEntity;
import com.ac.sourceio.Entity.JobPostEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class JobsAppliedDomain {
	 private Long appliedId;
	    
	    
	    private JobPostEntity jobPost;
	    
	    public JobsAppliedDomain() {
	    	
	    }

		public JobsAppliedDomain(Long appliedId, JobPostEntity jobPost) {
			super();
			this.appliedId = appliedId;
			this.jobPost = jobPost;
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

		@Override
		public String toString() {
			return "JobsAppliedDomain [appliedId=" + appliedId + ", jobPost=" + jobPost + "]";
		}
	    

}
