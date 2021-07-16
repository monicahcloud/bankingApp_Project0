package com.example.services;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.models.Bank;
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
	
//	public void signUp() throws UserNameNotAvailable {
//		//System.out.println("What kind of account would you like to open? CHECKING or SAVINGS!");
//		String acctType= in.nextLine().toUpperCase();
//		
//			if(!"CHECKING".equals(acctType) && !"SAVINGS".equals(acctType)){
//				System.out.println("Please enter Checking or Savings");		
//				continue;
//			}
//			
//		
//		System.out.println("Please enter your First Name:   ");
//		String first = in.nextLine();
//		
//		System.out.println("Please enter your Last Name:   ");
//		String last = in.nextLine();
//		
//		System.out.println("Please enter a password:   ");
//		String password = in.nextLine();
//		
//		System.out.println("Please deposit an initial balance of at least $50 to open this account. ");
//		double initialBalance = in.nextDouble();
//		in.nextLine();
//		
//		if(initialBalance >= 50) {
//			
//			Customer customer = new Customer(first, last, email, password, userType );//create customer
//			customer.setAccount(initialBalance, acctType);//create account
//			bank.addCustomer(customer);//add to customers array
//			
//			System.out.println("You have successfully created a " + acctType + " account.");
//				
//			System.out.println("Your username is " + customer.getUsername() + " and your password is " + customer.getPassword());
//			System.out.println("Your starting balance is " + customer.getAccount().getBalance());
//			System.out.println();
//			
//		}else {
//			System.out.println("You did not meet the requirements to open an account.");
//			
//		}
//		
//	}
//	}
//
//	public void login (String userName, String passWord) throws InvalidCredentialsException, UserDoesNotExistException {
//		
//		System.out.println("Please enter your username:   ");
//		String username = in.nextLine();
//		
//		System.out.println("Please enter your password:   ");
//		String password = in.nextLine();
//		
//		for(Customer customer: bank.getCustomers()) {
//				if(customer.getUsername().equals(username) && password.equals(customer.getPassword())) {
//					System.out.println(customer.getFirstName() + customer.getLastName() + ": You have successfully logged into your account."
//							+ "\nPlease select one of the following options.");
//					System.out.println( );
//					
//					
//					System.out.println("1. Make a deposit.");
//					System.out.println("2. Make a withdrawal.");
//					System.out.println("3. View balance.");
//					System.out.println("4. View last transactions.");
//					System.out.println("5. Make a transfer");		
//					int option = Integer.parseInt(in.nextLine());
////					
////					switch (option) {
////					
////					case 1:
////						double amount;
////						System.out.println("How much are you depositing into this account?");
////						amount= Double.parseDouble(in.nextLine());
////						transaction.makeDeposit(amount);
////						break;
////					case 2:
////						double amount2;
////						System.out.println("How much are you withdrawing from this account?");
////						amount2= Double.parseDouble(in.nextLine());
////						transaction.makeWithdrawal(amount2);
////						break;
////					case 3:
////					
////						System.out.println("Your current balance is: ");
////						
////						transaction.inquiry();
////						break;
////					case 4:
////						
////						System.out.println("Your previous transaction is: ");
////						
////						transaction.viewPreviousTransaction();
////						break;
////					case 5:
////						double amount4 = Double.parseDouble(in.nextLine());
////						transaction.transferMoney(amount4, customer.getAccount());
////						break;
//					}else {
//						System.out.println("Invalid input.");
//					}
//				}}}
				