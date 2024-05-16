package com.ac.sourceio.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "job_post")
public class JobPostEntity {

	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "job_id")
	    private Long jobId;   
	    private String Role;
	    private String Company;
	    private String TotalExperience;
	    private String Location;
	    private String JobDescription;
	    private String RequiredSkills;
	    private String Responsibilities;
	    private String AdditionalResponsibilities;
	    private String LastApplyDate;
	    private String DatePosted;
	    private String Postedby;
	    private String modeOfJob;
	    private String contact;
	    @JsonBackReference
	    @ManyToOne
	    @JoinColumn( name="employer_id")
	    private EmployerEntity employer;
	    
	    public JobPostEntity() {
	    	
	    }

		public JobPostEntity(Long jobId, String role, String company, String totalExperience, String location,
				String jobDescription, String requiredSkills, String responsibilities,
				String additionalResponsibilities, String lastApplyDate, String datePosted, String postedby,
				String modeOfJob, String contact, EmployerEntity employer) {
			super();
			this.jobId = jobId;
			Role = role;
			Company = company;
			TotalExperience = totalExperience;
			Location = location;
			JobDescription = jobDescription;
			RequiredSkills = requiredSkills;
			Responsibilities = responsibilities;
			AdditionalResponsibilities = additionalResponsibilities;
			LastApplyDate = lastApplyDate;
			DatePosted = datePosted;
			Postedby = postedby;
			this.modeOfJob = modeOfJob;
			this.contact = contact;
			this.employer = employer;
		}

		public Long getJobId() {
			return jobId;
		}

		public void setJobId(Long jobId) {
			this.jobId = jobId;
		}

		public String getRole() {
			return Role;
		}

		public void setRole(String role) {
			Role = role;
		}

		public String getCompany() {
			return Company;
		}

		public void setCompany(String company) {
			Company = company;
		}

		public String getTotalExperience() {
			return TotalExperience;
		}

		public void setTotalExperience(String totalExperience) {
			TotalExperience = totalExperience;
		}

		public String getLocation() {
			return Location;
		}

		public void setLocation(String location) {
			Location = location;
		}

		public String getJobDescription() {
			return JobDescription;
		}

		public void setJobDescription(String jobDescription) {
			JobDescription = jobDescription;
		}

		public String getRequiredSkills() {
			return RequiredSkills;
		}

		public void setRequiredSkills(String requiredSkills) {
			RequiredSkills = requiredSkills;
		}

		public String getResponsibilities() {
			return Responsibilities;
		}

		public void setResponsibilities(String responsibilities) {
			Responsibilities = responsibilities;
		}

		public String getAdditionalResponsibilities() {
			return AdditionalResponsibilities;
		}

		public void setAdditionalResponsibilities(String additionalResponsibilities) {
			AdditionalResponsibilities = additionalResponsibilities;
		}

		public String getLastApplyDate() {
			return LastApplyDate;
		}

		public void setLastApplyDate(String lastApplyDate) {
			LastApplyDate = lastApplyDate;
		}

		public String getDatePosted() {
			return DatePosted;
		}

		public void setDatePosted(String datePosted) {
			DatePosted = datePosted;
		}

		public String getPostedby() {
			return Postedby;
		}

		public void setPostedby(String postedby) {
			Postedby = postedby;
		}

		public String getModeOfJob() {
			return modeOfJob;
		}

		public void setModeOfJob(String modeOfJob) {
			this.modeOfJob = modeOfJob;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public EmployerEntity getEmployer() {
			return employer;
		}

		public void setEmployer(EmployerEntity employer) {
			this.employer = employer;
		}
	    
}
