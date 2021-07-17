package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
//We use callable statements to call stored procedures and functions from java
	
	@Override
	public List<Account> getAllAccount() {
		List<Account> accountList = new ArrayList<Account>();
		
		return null;
	}

	@Override
	public void createAccount(Account acct) throws SQLException {
		
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			
			String sql =  "INSERT INTO accounts(accountnumber, customerid, opening_balance, accounttype) values"
					+ "(?,?,?,?)";;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, acct.getAcctNumber());
			ps.setInt(2, acct.getCustID());
			ps.setDouble(3, acct.getOpeningBalance());
			ps.setString(4, acct.getAcctType());
		
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
			
			//We need to create a statement with this sql string
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4)));
			}
			CallableStatement cs = con.prepareCall(sql);
			
			return accountList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}

	
//	@Override
//	public List<PostDisplay> getAllPosts() {
//		
//		List<PostDisplay> pList = new ArrayList<PostDisplay>();
//		
//		try {
//			Connection con = conUtil.getConnection();
//			con.setAutoCommit(false);
//			//Use this syntax to call a stored function
//			String sql = "{?=call get_all_posts()}";
//			
//			CallableStatement cs = con.prepareCall(sql);
//			
//			cs.registerOutParameter(1, Types.OTHER);
//			
//			cs.execute();
//			
//			ResultSet rs = (ResultSet) cs.getObject(1);
//			
//			while(rs.next()) {
//				PostDisplay post = new PostDisplay(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
//				pList.add(post);
//			}
//			
//			con.setAutoCommit(true);
//			return pList;
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//
//	@Override
//	public User getUsersPosts(User u) {
//		List<Post> posts = new ArrayList<Post>();
//		try {
//			Connection con = conUtil.getConnection();
//			con.setAutoCommit(false);
//			String sql = "{?=call get_user_posts(?)}";
//			
//			CallableStatement cs = con.prepareCall(sql);
//			
//			cs.registerOutParameter(1, Types.OTHER);
//			cs.setInt(2, u.getId());
//			
//			cs.execute();
//			
//			ResultSet rs = (ResultSet) cs.getObject(1);
//			
//			while(rs.next()) {
//				Post p = new Post(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
//				posts.add(p);
//			}
//			
//			u.setPosts(posts);
//			
//			con.setAutoCommit(true);
//			return u;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}

