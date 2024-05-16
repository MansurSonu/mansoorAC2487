package com.ac.sourceio.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employer")
public class EmployerEntity {
	@Id
	private String employerId;
	private String companyName;
	private String type;
	private String email;
	private Integer noOfEmployees;
	private String url;
	private String contactPerson;
	private String designation;
	private Long mobile;
	private String password;
	private String pan;
	private String aadhar;
	private String Gst;
	private String emailOtp;
	private String phoneOtp;
	@JsonManagedReference("employer-address")
	@JsonIgnore
	@OneToMany(mappedBy = "employer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List <AddressEntity> address;
	
	@JsonManagedReference("employer-jobpost")
	@JsonIgnore
	@OneToMany(mappedBy = "employer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List <JobPostEntity> jobPost;
	
	
	
}
