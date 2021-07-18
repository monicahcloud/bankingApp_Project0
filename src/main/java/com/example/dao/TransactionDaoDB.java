package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Transactions;
import com.example.models.User;
import com.example.utils.ConnectionUtil;


public class TransactionDaoDB implements TransactionDao {
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public List<Transactions> getAllTransaction() 
	{
		List<Transactions> transactionList  = new ArrayList<Transactions>();
		 
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statement we write our query as a string
			String sql = "SELECT * FROM transactions";
			
			//We need to create a statement with this sql string
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				transactionList.add(new Transactions(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getString(5), rs.getDouble(4), rs.getString(6), rs.getDouble(7)));
			}
			
			return transactionList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

@Override
	public Transactions getTransactionByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeDeposit(Transactions t) throws SQLException {
try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM accounts WHERE accounts.accountnumber = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, acct.getAcctNumber());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	}

	@Override
	public void makeWithdrawl(Transactions t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

	
}
