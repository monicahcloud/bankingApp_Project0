package com.example.services;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.models.Transactions;
import com.example.models.User;
import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameNotAvailable;
import com.example.logging.Logging;


public class UserServices {
	private UserDao uDao;
	
	public UserServices(UserDao u) {
		this.uDao = u;
	}
	
	public User signUp(String first, String last, String email, String password) throws UserNameNotAvailable {
		User u = new User(first, last, email, password);
		
		try {
			uDao.createUser(u);
			Logging.logger.info("New user has registered");
			
		} catch (SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameNotAvailable();
		}
		 
		
		return u;
	}
	
	public User login (String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(username);
		
		if(u.getId() == 0) {
			Logging.logger.warn("User does not exist");
			throw new UserDoesNotExistException();
		}
		else if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("You have successfully logged in.");
			
			return u;
		}
	}
	
	
}
	
				