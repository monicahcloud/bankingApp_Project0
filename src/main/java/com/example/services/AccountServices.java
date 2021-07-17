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
}
	
//	public User login (String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
//		
//		User u = uDao.getUserByUsername(username);
//		
//		if(u.getId() == 0) {
//			Logging.logger.warn("User does not exist");
//			throw new UserDoesNotExistException();
//		}
//		else if(!u.getPassword().equals(password)) {
//			Logging.logger.warn("User tried to login with invalid credentials");
//			throw new InvalidCredentialsException();
//		}
//		else {
//			Logging.logger.info("You have successfully logged in.");
//			
//			return u;
//		}
//	}
	