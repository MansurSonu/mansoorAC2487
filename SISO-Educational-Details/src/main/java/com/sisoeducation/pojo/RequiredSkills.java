package com.sisoeducation.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "required_skills")
public class RequiredSkills {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rSkillId;
	@Column
	private String skillsRequired;

	@JsonIgnore
	@JsonBackReference("jobsSave-requiredSkills")
	@ManyToOne
	@JoinColumn(name = "jobsSave_Id")
	private JobsSave jobsSave;

	

	public RequiredSkills() {

	}

	public RequiredSkills(int rSkillId, String skillsRequired, JobsSave jobsSave) {
		super();
		this.rSkillId = rSkillId;
		this.skillsRequired = skillsRequired;
		this.jobsSave = jobsSave;
	}

	public int getrSkillId() {
		return rSkillId;
	}

	public void setrSkillId(int rSkillId) {
		this.rSkillId = rSkillId;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public JobsSave getJobsSave() {
		return jobsSave;
	}

	public void setJobsSave(JobsSave jobsSave) {
		this.jobsSave = jobsSave;
	}

}