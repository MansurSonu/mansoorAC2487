package com.ac.sourceio.Entity;

import java.sql.Blob;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="certifications")
public class CertificationsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long certificateId;
	private String cname;
	private Blob certificate;
	
	@JsonBackReference("employee-certifications")
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeEntity employee;
	
	public CertificationsEntity() {
		
	}

	public CertificationsEntity(Long certificateId, String cname, Blob certificate, EmployeeEntity employee) {
		super();
		this.certificateId = certificateId;
		this.cname = cname;
		this.certificate = certificate;
		this.employee = employee;
	}

	public Long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Blob getCertificate() {
		return certificate;
	}

	public void setCertificate(Blob certificate) {
		this.certificate = certificate;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	
}
