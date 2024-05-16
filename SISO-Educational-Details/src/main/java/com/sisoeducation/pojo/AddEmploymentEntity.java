package com.sisoeducation.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "AddEmployementEntity")

public class AddEmploymentEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long employementId;
		
		@Column
		private String companyName;
		
		@Column
		private String employementType;
		
		private Integer years;
		private Integer months;
		

		@Column
		private Date joiningDate;
		

		@Column
		private Date workedTill;
		
		private String designation;
		@Column
		private Long annualSalary;
		
		@Column
		private Integer noticePeriod;
		

		
		@JsonIgnore
		@JsonBackReference("employee-AddEmployementEntity")
		@ManyToOne
		@JoinColumn(name = "employee_id")
		private EmployeeEntity employee;
		
		public AddEmploymentEntity() {
			
		}

		public AddEmploymentEntity(Long employementId, String companyName, String employementType, Integer years,
				Integer months, Date joiningDate, Date workedTill, String designation, Long annualSalary,
				Integer noticePeriod, EmployeeEntity employee) {
			super();
			this.employementId = employementId;
			this.companyName = companyName;
			this.employementType = employementType;
			this.years = years;
			this.months = months;
			this.joiningDate = joiningDate;
			this.workedTill = workedTill;
			this.designation = designation;
			this.annualSalary = annualSalary;
			this.noticePeriod = noticePeriod;
			this.employee = employee;
		}

		public Long getEmployementId() {
			return employementId;
		}

		public void setEmployementId(Long employementId) {
			this.employementId = employementId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getEmployementType() {
			return employementType;
		}

		public void setEmployementType(String employementType) {
			this.employementType = employementType;
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

		public Date getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(Date joiningDate) {
			this.joiningDate = joiningDate;
		}

		public Date getWorkedTill() {
			return workedTill;
		}

		public void setWorkedTill(Date workedTill) {
			this.workedTill = workedTill;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public Long getAnnualSalary() {
			return annualSalary;
		}

		public void setAnnualSalary(Long annualSalary) {
			this.annualSalary = annualSalary;
		}

		public Integer getNoticePeriod() {
			return noticePeriod;
		}

		public void setNoticePeriod(Integer noticePeriod) {
			this.noticePeriod = noticePeriod;
		}

		public EmployeeEntity getEmployee() {
			return employee;
		}

		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}
		

}
