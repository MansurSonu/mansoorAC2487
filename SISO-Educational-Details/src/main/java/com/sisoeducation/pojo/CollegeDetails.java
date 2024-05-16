package com.sisoeducation.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="college")
public class CollegeDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clgId;
	
	private String study;             // Like 12th or Diploma...
	private String nameofInstitution;
	private String yearofPasing;
	private Double totalMarks;
    private String percentage;
    private String location;
    
      @OneToOne
    private EmployeeEntity details;

      
	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	public CollegeDetails() {
		super();
	}

	public Integer getclgId() {
		return clgId;
	}

	public void setclgId(Integer clgId) {
		this.clgId = clgId;
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

	public EmployeeEntity getDetails() {
		return details;
	}

	public void setDetails(EmployeeEntity details) {
		this.details = details;
	}

	public CollegeDetails(Integer clgId, String study,String nameofInstitution, String yearofPasing, Double totalMarks,
			String percentage, String location, EmployeeEntity details) {
		super();
		this.clgId = clgId;
		this.nameofInstitution = nameofInstitution;
		this.yearofPasing = yearofPasing;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
		this.location = location;
		this.details = details;
		this.study = study;
		
	}
	
  }