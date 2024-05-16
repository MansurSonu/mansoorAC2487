package com.sisoeducation.pojo;

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
@Table(name = "TechnicalSkills")

public class TechnicalSkills {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillId;

	@Column
	private String skillName;
	private Integer years;
	private Integer months;

	@JsonIgnore
	@JsonBackReference("employee-technicalskills")
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employee;
	
	
	public TechnicalSkills() {

	}

	public TechnicalSkills(Long skillId, String skillName, Integer years, Integer months,
			EmployeeEntity employee) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.years = years;
		this.months = months;
		this.employee = employee;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
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

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

}
