package com.sisoeducation.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")

public class EmployeeEntity {

	@Id
	@SequenceGenerator(name = "emp_id")
	@GeneratedValue(generator = "emp-id-generator")
	@GenericGenerator(name = "emp-id-generator", strategy = "com.sisoeducation.generator.EmpIdGenerator")
	private String employeeId;
	
	@Column
	private String userName;
	@Column
	private String firstName;	
	@Column
	private String lastName;

	private String email;	
	@Column
	private String fileName;
	
	@Column
	private String emailOtp;
	
	@Column
	private String enterOtp;
		
		
	private String phone;
	private String phoneOtp;
	@Column
	private String alternateMobile;
	
	private String password;
	@Column
	private String newPassword;
	
	@Column
	private String confirmNewPassword;
	
	private String gender;
	
	private Date dob;
	@Column
	private String jobRole;
	
	private String designation;
	
	private String role;
	@Column
	private String registerAs;
	@Column
	private String workStatus;
	@Column
	private String benchStatus;	
	@Column
	private String modeOfJob;
	@Column
	private String typeOfJob;
		
	private Integer years;
	
	private Integer months;
	@Column
	private Double currentSalary;	
	@Column
	private Double expectedSalary1;
	@Column
	private Double expectedSalary2;
	@Lob
	@Column(name = "resume", columnDefinition = "MEDIUMBLOB")
	private byte[] resume;
	@Column
	private String resumeDescription;
	@Lob
	private Byte[] image;

	
	
	private Long doorNumber;
	
	private String streetName;
	
	private String state;
	
	private String city;
	
	private String country;
	
	private Long pincode;
	
	
	
   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private SchoolDetails school;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "college_id")
    private CollegeDetails college;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<UniverisityDetails> university;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<CertificationsDetails> certificates;

	@ElementCollection
	@JsonManagedReference("employee-address")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AddressEntity> addresses = new ArrayList<>();

	@JsonManagedReference("employee-technicalskills")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TechnicalSkills> technicalSkills;

	@JsonManagedReference("employee-jobsapplied")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobsAppliedEntity> jobsapplied;

	
	
	@JsonManagedReference("employee-AddEmployementEntity")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AddEmploymentEntity> addEmployementEntities;
	
	@JsonManagedReference("employee-applyJobs")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ApplyJobs> applyJobs;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preference_id")
	private JobPreferencesEntity jobpref;

	@JsonManagedReference("employee-projects")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProjectsEntity> projects;

	@JsonManagedReference("employee-jobsSave")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobsSave> jobsSave;
		

	@PrePersist
	public void prePersist() {
		if (employeeId == null) {
			employeeId = generateemployeeId();
		}
	}
		
	private String generateemployeeId() {
		return null;
	}

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(String employeeId, String userName, String firstName, String lastName, String email,
			String fileName, String emailOtp, String enterOtp, String phone, String phoneOtp, String alternateMobile,
			String password, String newPassword, String confirmNewPassword, String gender, Date dob, String jobRole,
			String designation, String role, String registerAs, String workStatus, String benchStatus, String modeOfJob,
			String typeOfJob, Integer years, Integer months, Double currentSalary, Double expectedSalary1,
			Double expectedSalary2, byte[] resume, String resumeDescription, Byte[] image, Long doorNumber,
			String streetName, String state, String city, String country, Long pincode, SchoolDetails school,
			CollegeDetails college, List<UniverisityDetails> university, List<CertificationsDetails> certificates,
			List<AddressEntity> addresses, List<TechnicalSkills> technicalSkills, List<JobsAppliedEntity> jobsapplied,
			List<AddEmploymentEntity> addEmployementEntities, List<ApplyJobs> applyJobs, JobPreferencesEntity jobpref,
			List<ProjectsEntity> projects, List<JobsSave> jobsSave) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.fileName = fileName;
		this.emailOtp = emailOtp;
		this.enterOtp = enterOtp;
		this.phone = phone;
		this.phoneOtp = phoneOtp;
		this.alternateMobile = alternateMobile;
		this.password = password;
		this.newPassword = newPassword;
		this.confirmNewPassword = confirmNewPassword;
		this.gender = gender;
		this.dob = dob;
		this.jobRole = jobRole;
		this.designation = designation;
		this.role = role;
		this.registerAs = registerAs;
		this.workStatus = workStatus;
		this.benchStatus = benchStatus;
		this.modeOfJob = modeOfJob;
		this.typeOfJob = typeOfJob;
		this.years = years;
		this.months = months;
		this.currentSalary = currentSalary;
		this.expectedSalary1 = expectedSalary1;
		this.expectedSalary2 = expectedSalary2;
		this.resume = resume;
		this.resumeDescription = resumeDescription;
		this.image = image;
		this.doorNumber = doorNumber;
		this.streetName = streetName;
		this.state = state;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		this.school = school;
		this.college = college;
		this.university = university;
		this.certificates = certificates;
		this.addresses = addresses;
		this.technicalSkills = technicalSkills;
		this.jobsapplied = jobsapplied;
		this.addEmployementEntities = addEmployementEntities;
		this.applyJobs = applyJobs;
		this.jobpref = jobpref;
		this.projects = projects;
		this.jobsSave = jobsSave;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}

	public String getEnterOtp() {
		return enterOtp;
	}

	public void setEnterOtp(String enterOtp) {
		this.enterOtp = enterOtp;
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

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
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

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRegisterAs() {
		return registerAs;
	}

	public void setRegisterAs(String registerAs) {
		this.registerAs = registerAs;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getBenchStatus() {
		return benchStatus;
	}

	public void setBenchStatus(String benchStatus) {
		this.benchStatus = benchStatus;
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

	public String getResumeDescription() {
		return resumeDescription;
	}

	public void setResumeDescription(String resumeDescription) {
		this.resumeDescription = resumeDescription;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	public Long getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(Long doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public SchoolDetails getSchool() {
		return school;
	}

	public void setSchool(SchoolDetails school) {
		this.school = school;
	}

	public CollegeDetails getCollege() {
		return college;
	}

	public void setCollege(CollegeDetails college) {
		this.college = college;
	}

	public List<UniverisityDetails> getUniversity() {
		return university;
	}

	public void setUniversity(List<UniverisityDetails> university) {
		this.university = university;
	}

	public List<CertificationsDetails> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<CertificationsDetails> certificates) {
		this.certificates = certificates;
	}

	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public List<TechnicalSkills> getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(List<TechnicalSkills> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public List<JobsAppliedEntity> getJobsapplied() {
		return jobsapplied;
	}

	public void setJobsapplied(List<JobsAppliedEntity> jobsapplied) {
		this.jobsapplied = jobsapplied;
	}

	public List<AddEmploymentEntity> getAddEmployementEntities() {
		return addEmployementEntities;
	}

	public void setAddEmployementEntities(List<AddEmploymentEntity> addEmployementEntities) {
		this.addEmployementEntities = addEmployementEntities;
	}

	public List<ApplyJobs> getApplyJobs() {
		return applyJobs;
	}

	public void setApplyJobs(List<ApplyJobs> applyJobs) {
		this.applyJobs = applyJobs;
	}

	public JobPreferencesEntity getJobpref() {
		return jobpref;
	}

	public void setJobpref(JobPreferencesEntity jobpref) {
		this.jobpref = jobpref;
	}

	public List<ProjectsEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectsEntity> projects) {
		this.projects = projects;
	}

	public List<JobsSave> getJobsSave() {
		return jobsSave;
	}

	public void setJobsSave(List<JobsSave> jobsSave) {
		this.jobsSave = jobsSave;
	}

	
		
 }