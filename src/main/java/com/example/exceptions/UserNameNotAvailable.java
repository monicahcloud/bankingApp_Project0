package com.example.exceptions;

public class UserNameNotAvailable extends RuntimeException{


	private static final long serialVersionUID = 1L;

	
	public UserNameNotAvailable () {
		super("Username already exist.");
	}
}
