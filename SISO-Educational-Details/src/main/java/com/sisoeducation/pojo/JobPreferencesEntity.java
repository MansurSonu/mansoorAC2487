package com.sisoeducation.pojo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "job_preferences")
public class JobPreferencesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long preferenceId;

	@Column
	private String currentIndustry;

	@Column
	private String department;

	@Column
	private String roleCategory;

	@Column
	private String role;

	@Column
	private String desiredEmployementType;

	@Column
	private String preferredShift;

	@Column
	private String preferredLocation;

	@Column
	private String expectedSalary1;

	@Column
	private String expectedSalary2;
	
	

	public JobPreferencesEntity() {
		
	}



	public JobPreferencesEntity(Long preferenceId, String currentIndustry, String department, String roleCategory,
			String role, String desiredEmployementType, String preferredShift, String preferredLocation,
			String expectedSalary1, String expectedSalary2) {
		super();
		this.preferenceId = preferenceId;
		this.currentIndustry = currentIndustry;
		this.department = department;
		this.roleCategory = roleCategory;
		this.role = role;
		this.desiredEmployementType = desiredEmployementType;
		this.preferredShift = preferredShift;
		this.preferredLocation = preferredLocation;
		this.expectedSalary1 = expectedSalary1;
		this.expectedSalary2 = expectedSalary2;
	}



	public Long getPreferenceId() {
		return preferenceId;
	}



	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}



	public String getCurrentIndustry() {
		return currentIndustry;
	}



	public void setCurrentIndustry(String currentIndustry) {
		this.currentIndustry = currentIndustry;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getRoleCategory() {
		return roleCategory;
	}



	public void setRoleCategory(String roleCategory) {
		this.roleCategory = roleCategory;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getDesiredEmployementType() {
		return desiredEmployementType;
	}



	public void setDesiredEmployementType(String desiredEmployementType) {
		this.desiredEmployementType = desiredEmployementType;
	}



	public String getPreferredShift() {
		return preferredShift;
	}



	public void setPreferredShift(String preferredShift) {
		this.preferredShift = preferredShift;
	}



	public String getPreferredLocation() {
		return preferredLocation;
	}



	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}



	public String getExpectedSalary1() {
		return expectedSalary1;
	}



	public void setExpectedSalary1(String expectedSalary1) {
		this.expectedSalary1 = expectedSalary1;
	}



	public String getExpectedSalary2() {
		return expectedSalary2;
	}



	public void setExpectedSalary2(String expectedSalary2) {
		this.expectedSalary2 = expectedSalary2;
	}



	
	}
