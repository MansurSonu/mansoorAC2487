package com.sisoeducation.pojo;


//It is used to print the messages based on the login status

public class LoginStatus {
	
	String message;
    Boolean status;


	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public  LoginStatus(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

}
