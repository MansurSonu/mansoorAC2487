package com.ac.sourceio.domain;

import com.ac.sourceio.Entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TechnicalSkillsDomain {
	
	private Long skillId;
	
	
	private String skillName;
	private Integer years;
	private Integer months;
	public TechnicalSkillsDomain() {
		
	}
	public TechnicalSkillsDomain(Long skillId, String skillName, Integer years, Integer months) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.years = years;
		this.months = months;
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
	
}
