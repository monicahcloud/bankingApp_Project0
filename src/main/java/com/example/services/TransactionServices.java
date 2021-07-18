package com.example.services;

import com.example.models.Transactions;

public class TransactionServices {
	
	private String acctType;
	private double acctBalance;
	private double previousTransaction;
	
	public TransactionServices () {};
	
	public TransactionServices(String type) {
		
		acctType = type;
		acctBalance = 0;
	}// end of parameterized constructor
	
	
	
	public TransactionServices(String type, double balance) {
		super();
		acctType = type;
		acctBalance = balance;
		}// end of parameterized constructor

	
	
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
	public void viewPreviousTransaction() {
		
		if(previousTransaction > 0) {
			System.out.println("TRANS TYPE:  DEPOSIT ---- Amount: " + previousTransaction );
			
		} else if (previousTransaction < 0) {
			System.out.println("TRANS TYPE:  WITHDRAWAL ---- Amount: " + previousTransaction );
			
		} else {
			System.out.println("You did not make a transaction.");
		} // end of else statement
	} //end of viewPreviousTransaction method
	
	
	// method to transfer money between accounts
//	public void transferMoney(double amount, Transactions acct) {
//		
//		if(acctBalance < amount) {
//			
//			System.out.println("We're unable to complete this transaction. Please try again later.");
//			
//			}
//		
//		else {
//			acctBalance -= amount;
//			acct.acctBalance += amount;
//			
//			System.out.println("************************************************************************************");
//			System.out.println("Transfer is successful. " + " The new balance in " + acctType  + "'s account is "+ acctBalance);
//			System.out.println("Transfer received. $" + acct.acctBalance + " was deposited into " + acct.acctType  + " 's account.");
//			System.out.println("*************************************************************************************");
////			
//		}//end of else statement
//		}//end of transferMoney method
	
	
	//Getters and Setters
	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}

	public double getPreviousTransaction() {
		return previousTransaction;
	}

	public void setPreviousTransaction(double previousTransaction) {
		this.previousTransaction = previousTransaction;
	}

	
	

}
