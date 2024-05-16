package com.sisoeducation.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "university")
public class UniverisityDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uniId;

	private String study;             // Like Btech / Degree / UG and PG Like2....
	private String nameofInstitution;
	private String yearofPasing;
	private Double totalMarks;
    private String percentage;
    private String location;
    
    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employee;

    
    
	public UniverisityDetails() {
		super();
	}

	public Integer getuniId() {
		return uniId;
	}

	public void setuniId(Integer uniId) {
		this.uniId = uniId;
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	public String getNameofInstitution() {
		return nameofInstitution;
	}

	public void setNameofInstitution(String nameofInstitution) {
		this.nameofInstitution = nameofInstitution;
	}

	public String getYearofPasing() {
		return yearofPasing;
	}

	public void setYearofPasing(String yearofPasing) {
		this.yearofPasing = yearofPasing;
	}

	public Double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public UniverisityDetails(Integer uniId, String study, String nameofInstitution, String yearofPasing,
			Double totalMarks, String percentage, String location, EmployeeEntity employee) {
		super();
		this.uniId = uniId;
		this.study = study;
		this.nameofInstitution = nameofInstitution;
		this.yearofPasing = yearofPasing;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
		this.location = location;
		this.employee = employee;
	}
       
  }
