package com.sisoeducation.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="certificates")
public class CertificationsDetails {

  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer certId;	
	
     private String nameofCourse;
	 private String board;
	 private String durationTime;
	 private String year;
	 private String pass;
	 
	 @ManyToOne
	 @JsonIgnore
	 @JsonBackReference("employee-certificationDetails")
	 @JoinColumn(name="employee_id")
	 private EmployeeEntity employee;

	 
	public CertificationsDetails() {
		super();
	}

	public Integer getCertId() {
		return certId;
	}

	public void setCertId(Integer certId) {
		this.certId = certId;
	}

	public String getNameofCourse() {
		return nameofCourse;
	}

	public void setNameofCourse(String nameofCourse) {
		this.nameofCourse = nameofCourse;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public CertificationsDetails(Integer certId, String nameofCourse, String board, String durationTime, String year,
			String pass, EmployeeEntity employee) {
		super();
		this.certId = certId;
		this.nameofCourse = nameofCourse;
		this.board = board;
		this.durationTime = durationTime;
		this.year = year;
		this.pass = pass;
		this.employee = employee;
	}
		 
  }
