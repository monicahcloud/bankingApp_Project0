package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Account {

	/**
	 * The name of the account: checking or savings
	 */
	private String name;
	
	/**
	 * The current balance of the account
	 */
	
	private double acctBalance;
	
	/**
	 * The account number 
	 */
	
	private int accountNum;
	
	/**
	 * The Customer object that owns this account
	 */
	private Customer owner;
	
	/**
	 * The list of transactions for this account
	 */
	private ArrayList<Transactions> transactions;
	
	//Constructors
	
	/*
	 * Create a new account
	 */
	
	public Account(String acctName, Customer acctOwner, double balance, Bank bank) {
		this.name = acctName;
		this.owner = acctOwner;
		this.setAcctNum(Math.abs(ThreadLocalRandom.current().nextInt()));
		acctBalance = balance;
		
	}

	public Account(String string, Customer newCust, Bank bank) {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return acctBalance;
	}

	public void setBalance(double balance) {
		acctBalance = balance;
	}

	public int getAcctNum() {
		return accountNum;
	}

	public void setAcctNum(int i) {
		this.accountNum = i;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public ArrayList<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transactions> transactions) {
		this.transactions = transactions;
	}
	

//Getters and Setters
	
	
	
	
	
	
	
	

		
}
