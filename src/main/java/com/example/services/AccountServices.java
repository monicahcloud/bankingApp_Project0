package com.example.services;
 
import java.sql.SQLException;
import com.example.models.Account;
import com.example.dao.AccountDao;
import com.example.exceptions.UserNameNotAvailable;
import com.example.logging.Logging;


public class AccountServices {
	private AccountDao aDao;
	
	public AccountServices(AccountDao a) {
		this.aDao = a;
	}
	
	public Account createAccount( int customerID, double balance, String acctType) throws UserNameNotAvailable {
		Account a = new Account(customerID, balance, acctType);
		
		try {
			aDao.createAccount(a);
			Logging.logger.info("New account has been created.,");
			
		} catch (SQLException e) {
			Logging.logger.warn("Account created that already exists in the database");
			throw new UserNameNotAvailable();
		}
		 
		return a;
	}
//	public Account viewBalance( int acctNumber) throws UserNameNotAvailable {
//		Account a = new Account(acctNumber);
//		
//		try {
//			aDao.viewBalance(a);
//			Logging.logger.info("You have viewed your account balance");
//			
//		} catch (SQLException e) {
//			Logging.logger.warn("You are unable to view your balance.");
//			throw new UserNameNotAvailable();
//		}
//		 
//		return a;
//	}
	
}
	

	