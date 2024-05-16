package com.ac.sourceio.domain;

import com.ac.sourceio.Entity.EmployeeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class EducationQualificationsD {
	private Long eqId;

	private String education;

	private String boardUniversity;

	private Integer year;

	private String courseSpecialization;

	private String courseType;

	private String mediumOfSchool;

	private Integer marks;
	public EducationQualificationsD() {
		
	}
	public EducationQualificationsD(Long eqId, String education, String boardUniversity, Integer year,
			String courseSpecialization, String courseType, String mediumOfSchool, Integer marks) {
		super();
		this.eqId = eqId;
		this.education = education;
		this.boardUniversity = boardUniversity;
		this.year = year;
		this.courseSpecialization = courseSpecialization;
		this.courseType = courseType;
		this.mediumOfSchool = mediumOfSchool;
		this.marks = marks;
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
	@Override
	public String toString() {
		return "EducationQualificationsD [eqId=" + eqId + ", education=" + education + ", boardUniversity="
				+ boardUniversity + ", year=" + year + ", courseSpecialization=" + courseSpecialization
				+ ", courseType=" + courseType + ", mediumOfSchool=" + mediumOfSchool + ", marks=" + marks + "]";
	}
	
}
