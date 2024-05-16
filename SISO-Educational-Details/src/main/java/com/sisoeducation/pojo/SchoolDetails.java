package com.sisoeducation.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="school")
public class SchoolDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String study;             // Like 10th or Other
	private String nameofInstitution;
	private String yearofPasing;
	private Double totalMarks;
    private String percentage;
    private String location;
   
 
   
public SchoolDetails() {
	super();
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
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


public String getStudy() {
	return study;
}

public void setStudy(String study) {
	this.study = study;
}

public SchoolDetails(Integer id,String study, String nameofInstitution, String yearofPasing, Double totalMarks, String percentage,
		String location ) {
	super();
	this.id = id;
	this.nameofInstitution = nameofInstitution;
	this.yearofPasing = yearofPasing;
	this.totalMarks = totalMarks;
	this.percentage = percentage;
	this.location = location;
	this.study = study;
}

 }
