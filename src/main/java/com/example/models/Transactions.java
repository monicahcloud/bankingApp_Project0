package com.example.models;

import java.util.Date;

public class Transactions {
	
	/**
	 * The amount of this transaction
	 */
		private double transAmount;
		/**
		 * The account this transactions occurs
		 */
		private Account inAcct;
		private Date timestamp;
		private double acctBalance;
		
		
	public Transactions() {
		
	}
	public Transactions(double amount, Account inAcct)
	{
		transAmount = amount;
		acctBalance = 0;
		this.inAcct = inAcct;
		this.timestamp = new Date();
		
	}
	
	public Transactions(double amount)
	{
		transAmount = amount;
		acctBalance = 0;
		this.timestamp = new Date();
		
	}

	
	

		
}
