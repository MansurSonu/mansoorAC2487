package com.ac.sourceio.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="technologies")
public class TechnologiesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long technologyId;
	
	private String Technology;
	
	@JsonBackReference("projects-technologies")
	@ManyToOne
	@JoinColumn(name="project_Id")
	private ProjectsEntity projects;
	public TechnologiesEntity() {
		
	}
	public TechnologiesEntity	(Long technologyId, String technology, ProjectsEntity projects) {
		super();
		this.technologyId = technologyId;
		Technology = technology;
		this.projects = projects;
	}
	public Long getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechnology() {
		return Technology;
	}
	public void setTechnology(String technology) {
		Technology = technology;
	}
	public ProjectsEntity getProjects() {
		return projects;
	}
	public void setProjects(ProjectsEntity projects) {
		this.projects = projects;
	}
	
	}
