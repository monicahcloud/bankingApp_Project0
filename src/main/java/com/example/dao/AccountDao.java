package com.example.dao;
import java.sql.SQLException;
import java.util.List;
import com.example.models.Account;
import com.example.models.User;
public interface AccountDao {

		List<Account> getAllAccounts();
					
		void createAccount(Account a) throws SQLException;
				
		public List<Account> getUserAccount(User u);
						
		Account getAccountByUser(User u);
	
		//public void makeDeposit(String username, double amount);
		
		void deleteAccount(Account a);

		void makeDeposit( User u, int depositAmount);
	
		void withDrawal( User u, int withDrawalAmount);
	
	}

