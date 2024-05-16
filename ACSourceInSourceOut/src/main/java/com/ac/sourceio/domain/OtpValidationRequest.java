package com.ac.sourceio.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class OtpValidationRequest {
	private String mobileOtp;
	private String phone;
	public OtpValidationRequest() {
		
	}
	public OtpValidationRequest(String mobileOtp, String phone) {
		super();
		this.mobileOtp = mobileOtp;
		this.phone = phone;
	}
	public String getMobileOtp() {
		return mobileOtp;
	}
	public void setMobileOtp(String mobileOtp) {
		this.mobileOtp = mobileOtp;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
