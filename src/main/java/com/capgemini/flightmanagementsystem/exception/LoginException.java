package com.capgemini.flightmanagementsystem.exception;

public class LoginException extends RuntimeException {
	
	public String getMessage() {
		return "invalid login credentials";
	}

}
