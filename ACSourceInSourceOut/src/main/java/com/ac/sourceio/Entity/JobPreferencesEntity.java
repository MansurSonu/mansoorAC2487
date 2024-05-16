package com.ac.sourceio.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_preferences")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobPreferencesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String jobPreferenceId;
	
	@Column
	private String currentIndustry;
	
	@Column
	private String department;
	
	@Column
	private String roleCategory;
	
	@Column
	private String role;
	
	
	@Column
	private String desiredEmployementType;
	
	@Column
	private String preferredShift;
	
	@Column
	private String preferredLocation;
	
	@Column
	private String expectedSalary1;
	
	@Column
	private String expectedSalary2;


	
	
	
	

}
