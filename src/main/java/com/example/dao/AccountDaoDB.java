package com.example.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public List<Account> getAllAccount() {
		List<Account> accountList = new ArrayList<Account>();
		
		return null;
	}

	@Override
	public void createAccount(Account acct) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(Account acct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Account acct) {
		// TODO Auto-generated method stub
		
	}

}
