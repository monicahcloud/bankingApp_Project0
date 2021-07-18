package com.example.dao;
import java.sql.SQLException;
import java.util.List;
import com.example.models.Account;
import com.example.models.User;
public interface AccountDao {

		List<Account> getAllAccount();
					
		void createAccount(Account acct) throws SQLException;
				
		public List<Account> getUserAccount(User u);
				
		Account getAccountByUsername(String username);
	
//		void updateAccount(Account acct);
		
		void deleteAccount(Account acct);
//		void viewBalance(Account acctNumber) throws SQLException;
	}

