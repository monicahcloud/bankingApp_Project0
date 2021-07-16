package com.example.models;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Account {
	private int acctNumber;
	private User custID;
	private double openingBalance;
	private String acctType;
	
	public Account() {}
	
	public Account(int acctNumber, User custID, double openingBalance, String acctType) {
		
		this.setAcctNumber(Math.abs(ThreadLocalRandom.current().nextInt()));;
		this.custID = custID;
		this.openingBalance = openingBalance;
		this.acctType = acctType;
	}


	//Getters and Setters
	public int getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}

	public User getCustID() {
		return custID;
	}

	public void setCustID(User custID) {
		this.custID = custID;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

 
	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
			
}
