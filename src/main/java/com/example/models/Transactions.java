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
	private double previousTransaction;
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
	
	public Transactions(int accountnumber2, String memo2, double transAmount2, String acctType) {
		// TODO Auto-generated constructor stub
		this.setId(new Random().nextInt(9000) + 1000);;
		this.timestamp = timestamp;
		this.accountnumber = accountnumber2;
		
		this.transAmount = transAmount2;
		this.transType = acctType;
		this.acctBalance = acctBalance;
	}
		//Method for making an inquiry on the account
		public  double inquiry() {
			
			System.out.println("*********************************************");
			System.out.println("Your current balance is:  $" + acctBalance);
			System.out.println("**********************************************");
			
			return acctBalance;
		}//end of inquiry method
		
		//Method for making a deposit on the account
		public  void  makeDeposit(double amount) {
			
			acctBalance = acctBalance += amount;
				previousTransaction = amount;
				
				System.out.println("************************************");
				System.out.println("Deposit:  $" + amount);
				System.out.println("Your new balance is:  $" + acctBalance);
				System.out.println("************************************");
			}// end of makeDeposit method
		
		
		
		//Method for making a withdrawal on the account
		public void makeWithdrawal(double amount) {
			if (amount <= acctBalance) {
		
				acctBalance -= amount;
				previousTransaction = amount;
				
				System.out.println("************************************");
				System.out.println("Withdrawn:  $" + amount);
				System.out.println("Your new balance is:  $" + acctBalance);
				System.out.println("************************************");
				} else { 
				
				System.out.println("************************************");
				System.out.println("Requested Withdrawal Amount:  $" + amount);
				System.out.println("We're unable to complete this transaction. Please try again later.");
				System.out.println("************************************");
				}//end of else statement
		}//end of make withdrawal method
		
		
		
		//Method for viewing the previous transactions
//		public void viewPreviousTransaction() {
//			
//			if(previousTransaction > 0) {
//				System.out.println("TRANS TYPE:  DEPOSIT ---- Amount: " + previousTransaction );
//				
//			} else if (previousTransaction < 0) {
//				System.out.println("TRANS TYPE:  WITHDRAWAL ---- Amount: " + previousTransaction );
//				
//			} else {
//				System.out.println("You did not make a transaction.");
//			} // end of else statement
		//} //end of viewPreviousTransaction method
		
		
		// method to transfer money between accounts
//		public void transferMoney(double amount, Transactions acct) {
//			
//			if(acctBalance < amount) {
//				
//				System.out.println("We're unable to complete this transaction. Please try again later.");
//				
//				}
//			
//			else {
//				acctBalance -= amount;
//				acct.acctBalance += amount;
//				
//				System.out.println("************************************************************************************");
//				System.out.println("Transfer is successful. " + " The new balance in " + acctType  + "'s account is "+ acctBalance);
//				System.out.println("Transfer received. $" + acct.acctBalance + " was deposited into " + acct.acctType  + " 's account.");
//				System.out.println("*************************************************************************************");
////				
//			}//end of else statement
//			}//end of transferMoney method
		
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
	public void makeDeposit(Transactions t) {
		// TODO Auto-generated method stub
		
	}
	
		
}
