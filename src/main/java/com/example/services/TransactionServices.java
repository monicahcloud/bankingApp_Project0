package com.example.services;

import java.sql.Date;
import java.sql.SQLException;

import com.example.dao.AccountDao;
import com.example.dao.TransactionDao;
import com.example.exceptions.UserNameNotAvailable;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.TransDisplay;
import com.example.models.Transactions;

public class TransactionServices {
	private TransactionDao tDao;
	
	public TransactionServices(TransactionDao t) {
		this.tDao = t;
	}
	
	public Transactions deposit( int customerID, double balance, String acctType) throws UserNameNotAvailable {
		Account t = new Account(customerID, balance, acctType);
		
		try {
		tDao.makeDeposit(t);
			Logging.logger.info("New account has been created.,");
			
		} catch (SQLException e) {
			Logging.logger.warn("Account created that already exists in the database");
			throw new UserNameNotAvailable();
		}
		 
		return t;

}
	
	
}
