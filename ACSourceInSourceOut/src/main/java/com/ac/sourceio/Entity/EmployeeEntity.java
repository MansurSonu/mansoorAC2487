package com.ac.sourceio.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String employeeId;

	@Column
	private String userName;
	@Column
	private String firstName;

	@Column
	private String lastName;

	private String email;

	@Column
	private String emailOtp;

	@Column
	private String enterOtp;

	@Column
	private String fileName;

	private String phone;

	@Column
	private String phoneOtp;

	@Column
	private String alternateMobile;
	private String password;
	private String newPassword;
	private String confirmNewPassword;
	private String gender;
	private Date dob;
	private String designation;
	private String jobRole;

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
	@Column(name = "resume", columnDefinition = "LONGBLOB")
	private byte[] resume;

	@Column
	private String resumeDescription;

	@Lob
	private Byte[] image;

	@JsonManagedReference("employee-certifications")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CertificationsEntity> certifications;

	@ElementCollection
	@JsonManagedReference("employee-address")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AddressEntity> addresses = new ArrayList<>();

	@JsonManagedReference("employee-technicalskills")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TechnicalSkillsEntity> technicalSkills;

	@JsonManagedReference("employee-jobsapplied")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JobsAppliedEntity> jobsapplied;

	@ElementCollection
	@JsonManagedReference("employee-educationqualifications")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EducationQualificationsEntity> eq;
	
	
	@JsonManagedReference("employee-AddEmployementEntity")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AddEmployementEntity> addEmployementEntities; 

	@OneToOne
	@JoinColumn(name = "job_Preference_Id")
	private JobPreferencesEntity jobpref;

	@JsonManagedReference("employee-projects")
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProjectsEntity> projects;

}
