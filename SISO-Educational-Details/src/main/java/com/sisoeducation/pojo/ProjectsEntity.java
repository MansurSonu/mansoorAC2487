package com.sisoeducation.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")

public class ProjectsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectsId;

	@Column
	private String projectTitle;

	private String description;

	private Integer years;
	private Integer months;

	@JsonManagedReference("projects-technologies")
	@JsonIgnore
	@OneToMany(mappedBy = "projects", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TechnologiesEntity> te;

	@JsonBackReference("employee-projects")
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employee;

	public ProjectsEntity() {

	}

	public ProjectsEntity(Long projectsId, String projectTitle, String description, Integer years, Integer months,
			List<TechnologiesEntity> te, EmployeeEntity employee) {
		super();
		this.projectsId = projectsId;
		this.projectTitle = projectTitle;
		this.description = description;
		this.years = years;
		this.months = months;
		this.te = te;
		this.employee = employee;
	}

	public Long getProjectsId() {
		return projectsId;
	}

	public void setProjectsId(Long projectsId) {
		this.projectsId = projectsId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<TechnologiesEntity> getTe() {
		return te;
	}

	public void setTe(List<TechnologiesEntity> te) {
		this.te = te;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

}
