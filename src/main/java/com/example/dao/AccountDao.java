package com.example.dao;
import java.sql.SQLException;
import java.util.List;
import com.example.models.Account;
public interface AccountDao {

		List<Account> getAllAccount();
		
				
		void createAccount(Account acct) throws SQLException;
		
		void updateUser(Account acct);
		
		void deleteUser(Account acct);
		
	}

