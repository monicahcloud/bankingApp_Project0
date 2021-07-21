package com.example.models;
import java.util.concurrent.ThreadLocalRandom;

public class Account {
	private int acctNumber;
	private int custID;
	private int currentBalance;
	private String acctType;
	
	public Account() {}
	
	public Account( int custID, int currentBalance, String acctType) {
		
		this.setAcctNumber(Math.abs(ThreadLocalRandom.current().nextInt()));
		this.custID = custID;
		this.currentBalance = currentBalance;
		this.acctType = acctType;
	}
	
public Account( int acctNumber, int custID, int currentBalance, String acctType) {
		
		this.acctNumber = acctNumber;
		this.custID = custID;
		this.currentBalance = currentBalance;
		this.acctType = acctType;
	}
	
	public Account(double acctNumber) {
	this.acctNumber = (int) acctNumber;
}

	//Getters and Setters
	public int getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public int setCurrentBalance(int currentBalance) {
		return this.currentBalance = currentBalance;
	}

 
	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	@Override
	public String toString() {
		
		return "Account[acctNumber=" +  acctNumber + ", custID= " + custID + ",currentBalance=" + currentBalance + ", acctType= " + acctType +"]";
	}

	
	
	
}
