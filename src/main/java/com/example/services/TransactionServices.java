package com.example.services;

import java.sql.SQLException;

import com.example.dao.AccountDao;
import com.example.exceptions.UserNameNotAvailable;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.Transactions;

public class TransactionServices {
	
	private Transactions tDao;
	
	public TransactionServices(Transactions t) {
		this.tDao = t;
		}
	
		
		public Transactions makeDeposit( int customerID, double balance, String acctType) throws UserNameNotAvailable {
			Account t = new Account(customerID, balance, acctType);
			
			try {
			tDao.makeDeposit(t);
				Logging.logger.info("New account has been created.,");
				
			} catch (SQLException e) {
				Logging.logger.warn("Account created that already exists in the database");
				throw new UserNameNotAvailable();
			}
			 
			return a;
		}
	}
	
	
	
	
	
	
	
	
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
