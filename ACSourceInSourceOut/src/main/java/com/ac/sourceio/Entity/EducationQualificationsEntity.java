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
@Table(name="education_qualifications")
public class EducationQualificationsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eqId;
	
	@Column
	private String education;
	
	@Column
	private String boardUniversity;
	
	@Column
	private Integer year;
	
	@Column
	private String courseSpecialization;
	
	@Column
	private String courseType;
	
	@Column
	private String mediumOfSchool;
	
	@Column
	private Integer marks;
	@ManyToOne
	@JsonBackReference("employee-educationqualifications")
	@JoinColumn(name="employee_id")
	private EmployeeEntity employee;
	
	public EducationQualificationsEntity() {
		
	}

	public EducationQualificationsEntity(Long eqId, String education, String boardUniversity, Integer year,
			String courseSpecialization, String courseType, String mediumOfSchool, Integer marks,
			EmployeeEntity employee) {
		super();
		this.eqId = eqId;
		this.education = education;
		this.boardUniversity = boardUniversity;
		this.year = year;
		this.courseSpecialization = courseSpecialization;
		this.courseType = courseType;
		this.mediumOfSchool = mediumOfSchool;
		this.marks = marks;
		this.employee = employee;
	}

	public Long getEqId() {
		return eqId;
	}

	public void setEqId(Long eqId) {
		this.eqId = eqId;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getBoardUniversity() {
		return boardUniversity;
	}

	public void setBoardUniversity(String boardUniversity) {
		this.boardUniversity = boardUniversity;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCourseSpecialization() {
		return courseSpecialization;
	}

	public void setCourseSpecialization(String courseSpecialization) {
		this.courseSpecialization = courseSpecialization;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getMediumOfSchool() {
		return mediumOfSchool;
	}

	public void setMediumOfSchool(String mediumOfSchool) {
		this.mediumOfSchool = mediumOfSchool;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	

	
}
