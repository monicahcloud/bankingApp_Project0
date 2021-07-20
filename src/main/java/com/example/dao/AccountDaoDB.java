package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
//We use callable statements to call stored procedures and functions from java
	
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statement we write our query as a string
			String sql = "SELECT * FROM accounts";
			
			//We need to create a statement with this sql string
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			}
			
			return accountList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void createAccount(Account a) throws SQLException {
		
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			
			String sql =  "INSERT INTO accounts(account_number, customerid, current_balance, account_type) values"
					+ "(?,?,?,?)";;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAcctNumber());
			ps.setInt(2, a.getCustID());
			ps.setDouble(3, a.getCurrentBalance());
			ps.setString(4, a.getAcctType());
		
			ps.execute();
					
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Account> getUserAccount(User u) {
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "SELECT * FROM accounts WHERE customerid =" + u.getId();
			CallableStatement cs = con.prepareCall(sql);
			//We need to create a statement with this sql string
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			
			
			}
			return accountList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public void deleteAccount(Account a) {
try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM accounts WHERE accounts.account_number = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, a.getAcctNumber());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Account getAccountByUser(User u) {
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			//String sql = "{?=call get_user_accounts()}";
			String sql = "SELECT * FROM accounts WHERE customerid =" + u.getId();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//CallableStatement cs = con.prepareCall(sql);
			
			//cs.registerOutParameter(1, Types.OTHER);
		
			
			//cs.execute();
			
			//ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Account a= new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
				accountList.add(0, a);
			}
			
			//u.setUserAcct(accountList);
			//con.setAutoCommit(true);
			return accountList.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void makeDeposit(User u, int depositAmount) {
		Account a = getAccountByUser(u);
		
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			
			String sql =  "UPDATE accounts set current_balance=? WHERE customerid=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, depositAmount + a.getCurrentBalance());
			ps.setInt(2, u.getId());
			ps.execute();

								
		}//end of try
		catch (SQLException e) {
			Logging.logger.warn("Account created that already exists in the database");
		}//end of catch
			 
		
			}//end of deposit

	@Override
	public void withDrawal(User u, int withDrawalAmount) {
Account a = getAccountByUser(u);
		
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			
			String sql =  "UPDATE accounts set current_balance=? WHERE customerid=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  a.getCurrentBalance() - withDrawalAmount);
			ps.setInt(2, u.getId());
			ps.execute();

								
		}//end of try
		catch (SQLException e) {
			Logging.logger.warn("Account created that already exists in the database");
		}//end of catch
			 
		
			}//end of deposit
		
	
	}//end of class

	
			

	