package com.ac.sourceio.domain;

import java.util.Date;

import jakarta.persistence.Column;

public class Employment {

	private Long employementId;
	private String companyName;
	private String employementType;
	private Integer years;
	private Integer months;
	private Date joiningDate;
	private Date workedTill;
	private String designation;
	private Long annualSalary;
	private Integer noticePeriod;
	
public Employment() {
	
}

public Employment(Long employementId, String companyName, String employementType, Integer years, Integer months,
		Date joiningDate, Date workedTill, String designation, Long annualSalary, Integer noticePeriod) {
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

@Override
public String toString() {
	return "Employment [employementId=" + employementId + ", companyName=" + companyName + ", employementType="
			+ employementType + ", years=" + years + ", months=" + months + ", joiningDate=" + joiningDate
			+ ", workedTill=" + workedTill + ", designation=" + designation + ", annualSalary=" + annualSalary
			+ ", noticePeriod=" + noticePeriod + "]";
}


}
