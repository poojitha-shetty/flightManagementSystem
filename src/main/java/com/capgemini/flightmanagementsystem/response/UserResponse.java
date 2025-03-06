package com.capgemini.flightmanagementsystem.response;

public class UserResponse {
	
	private int status;
	private String message;
	private String type;
	// Getter and Setter
	
	public int getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
