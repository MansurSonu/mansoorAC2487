package com.ac.sourceio.domain;

public class EmailLogin {

	private String email;
	private String password;
	public EmailLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmailLogin [email=" + email + ", password=" + password + "]";
	}
	
	
}
