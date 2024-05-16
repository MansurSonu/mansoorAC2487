package com.ac.sourceio.domain;

import java.sql.Blob;

import com.ac.sourceio.Entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CertificationsDomain {
	private Long certificateId;
	private String cname;
	private Blob certificate;
	
	public CertificationsDomain() {
		
	}

	public CertificationsDomain(Long certificateId, String cname, Blob certificate) {
		super();
		this.certificateId = certificateId;
		this.cname = cname;
		this.certificate = certificate;
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

	@Override
	public String toString() {
		return "CertificationsDomain [certificateId=" + certificateId + ", cname=" + cname + ", certificate="
				+ certificate + "]";
	}
	
	
}
