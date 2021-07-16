//package com.example.models;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Customer extends User{
//
//	//fields
//	private List<Account> custAcct;
//	
//	//constructors
//	public Customer() {
//		super();
//		//empty list of customer accounts
//		this.custAcct = new ArrayList<Account>();
//		
//	}
//	
//	/**
//	 * Create new customer
//	 * @param firstName extended from User class
//	 * @param lastName extended from User class
//	 * @param email extended from User class
//	 * @param password extended from User class
//	 * @param userType extended from User class
//	 */
//	public Customer(String firstName, String lastName, String email, String password, String userType) {
//		super(firstName, lastName, email, password, userType);
//		this.custAcct = new ArrayList<Account>();
//	}
//
//	public Customer(int id, String firstName, String lastName, String email, String username, String password, String userType) {
//		super(id, firstName, lastName, username, email, password, userType);
//		this.custAcct = new ArrayList<Account>();
//	}
//
//	//add an account to customers account array
//	public void addAccount(Account newAcct) {
//		this.custAcct.add(newAcct);
//	}
//	
//}