package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.models.Transactions;

public interface TransactionDao {
	
	List<Transactions> getAllTransaction();
	
	Transactions getTransactionByUser(String user);
	
 void makeDeposit(Transactions t) throws SQLException;
	 
	 void makeWithdrawl(Transactions t) throws SQLException;


}
