package com.ac.sourceio.Entity;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="AddEmployementEntity")
public class AddEmployementEntity {
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
	

		
	}
