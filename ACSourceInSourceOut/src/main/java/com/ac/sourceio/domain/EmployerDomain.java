package com.ac.sourceio.domain;

import java.util.List;

public class EmployerDomain {
	private Integer employerId;
	private String name;
	private String email;
	private String pan;
	private String aadhar;
	private String Gst;
	private List <AddressDomain> address;
	private List <JobPostDomain> jobPost;
	public EmployerDomain() {
		
	}
	public EmployerDomain(Integer employerId, String name, String email, String pan, String aadhar, String gst,
			List<AddressDomain> address, List<JobPostDomain> jobPost) {
		super();
		this.employerId = employerId;
		this.name = name;
		this.email = email;
		this.pan = pan;
		this.aadhar = aadhar;
		Gst = gst;
		this.address = address;
		this.jobPost = jobPost;
	}
	public Integer getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getGst() {
		return Gst;
	}
	public void setGst(String gst) {
		Gst = gst;
	}
	public List<AddressDomain> getAddress() {
		return address;
	}
	public void setAddress(List<AddressDomain> address) {
		this.address = address;
	}
	public List<JobPostDomain> getJobPost() {
		return jobPost;
	}
	public void setJobPost(List<JobPostDomain> jobPost) {
		this.jobPost = jobPost;
	}
	@Override
	public String toString() {
		return "EmployerDomain [employerId=" + employerId + ", name=" + name + ", email=" + email + ", pan=" + pan
				+ ", aadhar=" + aadhar + ", Gst=" + Gst + ", address=" + address + ", jobPost=" + jobPost + "]";
	}
	


}
