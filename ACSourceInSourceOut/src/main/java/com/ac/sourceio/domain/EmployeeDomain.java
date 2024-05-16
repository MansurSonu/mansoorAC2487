package com.ac.sourceio.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EmployeeDomain {

	private Long userId;
	private String userName;

	private String firstName;

	private String lastName;

	private String email;
	private String emailOtp;
	
	private String phone;
	private String phoneOtp;

	private String password;
	private String gender;
	private Date dob;
	private String designation;
	private String modeOfJob;
	private String typeOfJob;
	private Integer years;
	private Integer months;
	private Double currentSalary;
	private Double expectedSalary1;
	private Double expectedSalary2;
	private byte[] resume;
	private byte[] image;

	private List<CertificationsDomain> certifications;

	private List<AddressDomain> address;

	private List<TechnicalSkillsDomain> technicalSkills;

	private List<JobsAppliedDomain> jobsapplied;

	private List<EducationQualificationsD> eq;

	public EmployeeDomain() {
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneOtp() {
		return phoneOtp;
	}

	public void setPhoneOtp(String phoneOtp) {
		this.phoneOtp = phoneOtp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getModeOfJob() {
		return modeOfJob;
	}

	public void setModeOfJob(String modeOfJob) {
		this.modeOfJob = modeOfJob;
	}

	public String getTypeOfJob() {
		return typeOfJob;
	}

	public void setTypeOfJob(String typeOfJob) {
		this.typeOfJob = typeOfJob;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public Double getExpectedSalary1() {
		return expectedSalary1;
	}

	public void setExpectedSalary1(Double expectedSalary1) {
		this.expectedSalary1 = expectedSalary1;
	}

	public Double getExpectedSalary2() {
		return expectedSalary2;
	}

	public void setExpectedSalary2(Double expectedSalary2) {
		this.expectedSalary2 = expectedSalary2;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<CertificationsDomain> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<CertificationsDomain> certifications) {
		this.certifications = certifications;
	}

	public List<AddressDomain> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDomain> address) {
		this.address = address;
	}

	public List<TechnicalSkillsDomain> getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(List<TechnicalSkillsDomain> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public List<JobsAppliedDomain> getJobsapplied() {
		return jobsapplied;
	}

	public void setJobsapplied(List<JobsAppliedDomain> jobsapplied) {
		this.jobsapplied = jobsapplied;
	}

	public List<EducationQualificationsD> getEq() {
		return eq;
	}

	public void setEq(List<EducationQualificationsD> eq) {
		this.eq = eq;
	}

	public EmployeeDomain(Long userId, String userName, String firstName, String lastName, String email,
			String emailOtp, String phone, String phoneOtp, String password, String gender, Date dob,
			String designation, String modeOfJob, String typeOfJob, Integer years, Integer months, Double currentSalary,
			Double expectedSalary1, Double expectedSalary2, byte[] resume, byte[] image,
			List<CertificationsDomain> certifications, List<AddressDomain> address,
			List<TechnicalSkillsDomain> technicalSkills, List<JobsAppliedDomain> jobsapplied,
			List<EducationQualificationsD> eq) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.emailOtp = emailOtp;
		this.phone = phone;
		this.phoneOtp = phoneOtp;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.designation = designation;
		this.modeOfJob = modeOfJob;
		this.typeOfJob = typeOfJob;
		this.years = years;
		this.months = months;
		this.currentSalary = currentSalary;
		this.expectedSalary1 = expectedSalary1;
		this.expectedSalary2 = expectedSalary2;
		this.resume = resume;
		this.image = image;
		this.certifications = certifications;
		this.address = address;
		this.technicalSkills = technicalSkills;
		this.jobsapplied = jobsapplied;
		this.eq = eq;
	}

	@Override
	public String toString() {
		return "EmployeeDomain [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", emailOtp=" + emailOtp + ", phone=" + phone
				+ ", phoneOtp=" + phoneOtp + ", password=" + password + ", gender=" + gender + ", dob=" + dob
				+ ", designation=" + designation + ", modeOfJob=" + modeOfJob + ", typeOfJob=" + typeOfJob + ", years="
				+ years + ", months=" + months + ", currentSalary=" + currentSalary + ", expectedSalary1="
				+ expectedSalary1 + ", expectedSalary2=" + expectedSalary2 + ", resume=" + Arrays.toString(resume)
				+ ", image=" + Arrays.toString(image) + ", certifications=" + certifications + ", address=" + address
				+ ", technicalSkills=" + technicalSkills + ", jobsapplied=" + jobsapplied + ", eq=" + eq + "]";
	}
	
	}
