package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Customer> customers = new ArrayList<Customer>(); 
	
	private List<Employee> employees = new ArrayList<Employee>(); 
	
	private List<Account> bankAcct = new ArrayList<Account>();
	

	//add an account to bank account array
	public void addAccount(Account newAcct) {
		this.bankAcct.add(newAcct);
	}
	
	/**
	 * Create a new customer of the bank
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param username
	 * @param password
	 * @param userType
	 * @return
	 */
	public Customer addCustomer(int id, String firstName, String lastName, String email, String username, String password, String userType) {
		
		//create a new customer object and add it to the bank list
		Customer newCust = new Customer(id, firstName, lastName, email, username, password, userType);
		this.customers.add(newCust);
		
		//create a savings account for the user customer
		
		Account newAcct = new Account("Savings", newCust, this);
		// add to owner bank list
				newCust.addAccount(newAcct);
				this.addAccount(newAcct);
				
				return newCust;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Account> getBankAcct() {
		return bankAcct;
	}

	public void setBankAcct(List<Account> bankAcct) {
		this.bankAcct = bankAcct;
	}
	
	
	
}
