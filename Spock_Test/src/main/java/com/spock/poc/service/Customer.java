package com.spock.poc.service;

public class Customer {

	private String email = "";
	
	public void hasEmail(String emailAddress) 	{
		email = emailAddress;
	}

	public String getEmail() {
		return email;
	}
	
	
}
