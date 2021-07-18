package com.example.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Transactions {
	private int id;
	private Date timestamp;
	private int accountnumber;
	private String memo;
	private double transAmount;
	private String transType;
	private double acctBalance;
//	protected List<Account> userAcct;
			
	public Transactions() {
		
	}
	public Transactions(int acctNum, String memo, String transactionType, double amount )
	{this.timestamp = new Date();
	this.accountnumber = acctNum;
	this.memo = memo;
	transAmount = amount;
	this.transType = transactionType;
	acctBalance = 0;
	}
	
	
	
	public Transactions(int id, Date timestamp, int accountnumber, String memo, double transAmount, String transType,
			double acctBalance) {
		
		this.setId(new Random().nextInt(9000) + 1000);;
		this.timestamp = timestamp;
		this.accountnumber = accountnumber;
		this.memo = memo;
		this.transAmount = transAmount;
		this.transType = transType;
		this.acctBalance = acctBalance;
	}
	public Transactions(double amount)
	{
		transAmount = amount;
		acctBalance = 0;
		this.timestamp = new Date();
		
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public double getAcctBalance() {
		return acctBalance;
	}
	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}
	@Override
	public String toString() {
		return "Transactions [timestamp=" + timestamp + ", accountnumber=" + accountnumber + ", memo=" + memo
				+ ", transAmount=" + transAmount + ", transType=" + transType + ", acctBalance=" + acctBalance + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
		
}
