package com.sisoeducation.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "apply_Jobs")
public class ApplyJobs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appliedId;
	private String company;
	private String category;

	@Column
	private String jobRole;

	@Column
	private String requiredExperience;

	@Column
	private String modeOfJob;
	@Column
	private String workLocation;

	@Column
	private Date datePosted;

	@Column
	private Date lastApplyDate;

	private String type;
	private String responsibilities;

	@Column
	private String jobDescription;
	private String contact;
	@Column
	private String requiredSkills;

	@JsonIgnore
	@JsonBackReference("employee-jobsSave")
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employee;

	/*
	 * @JsonManagedReference("jobsSave-requiredSkills")
	 * 
	 * @OneToMany(mappedBy = "jobsSave", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<RequiredSkills> requiredSkills;
	 */

	public ApplyJobs() {

	}

	public ApplyJobs(int appliedId, String company, String category, String jobRole, String requiredExperience,
			String modeOfJob, String workLocation, Date datePosted, Date lastApplyDate, String type,
			String responsibilities, String jobDescription, String contact, String requiredSkills,
			EmployeeEntity employee) {
		super();
		this.appliedId = appliedId;
		this.company = company;
		this.category = category;
		this.jobRole = jobRole;
		this.requiredExperience = requiredExperience;
		this.modeOfJob = modeOfJob;
		this.workLocation = workLocation;
		this.datePosted = datePosted;
		this.lastApplyDate = lastApplyDate;
		this.type = type;
		this.responsibilities = responsibilities;
		this.jobDescription = jobDescription;
		this.contact = contact;
		this.requiredSkills = requiredSkills;
		this.employee = employee;
	}

	public int getAppliedId() {
		return appliedId;
	}

	public void setAppliedId(int appliedId) {
		this.appliedId = appliedId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getRequiredExperience() {
		return requiredExperience;
	}

	public void setRequiredExperience(String requiredExperience) {
		this.requiredExperience = requiredExperience;
	}

	public String getModeOfJob() {
		return modeOfJob;
	}

	public void setModeOfJob(String modeOfJob) {
		this.modeOfJob = modeOfJob;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public Date getLastApplyDate() {
		return lastApplyDate;
	}

	public void setLastApplyDate(Date lastApplyDate) {
		this.lastApplyDate = lastApplyDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	}
