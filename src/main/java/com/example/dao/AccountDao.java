package com.example.dao;
import java.sql.SQLException;
import java.util.List;
import com.example.models.Account;
import com.example.models.User;
public interface AccountDao {

		List<Account> getAllAccount();
		
				
		void createAccount(Account acct) throws SQLException;
				
		//public List<PostDisplay> getAllAccounts();
		
		public List<Account> getUserAccount(User u);
		
	}

