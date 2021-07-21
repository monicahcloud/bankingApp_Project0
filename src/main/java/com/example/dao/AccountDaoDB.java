package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.logging.Logging;
import com.example.models.Account;
import com.example.models.User;
import com.example.utils.ConnectionUtil;

public class AccountDaoDB implements AccountDao{
	
	Scanner scan = new Scanner(System.in);

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public List<Account> getAllAccounts() {
		
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			
			Connection con = conUtil.getConnection();
		
			String sql = "SELECT * FROM accounts";
			
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
			String sql = "SELECT * FROM accounts WHERE customerid =" + u.getId();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Account a= new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
				accountList.add(0, a);
			}

			return accountList.get(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void makeDeposit(User u, int depositAmount) {
		Account a = getAccountByUser(u);
		
		if(depositAmount <= 0 ) {//if statement is not working...
			System.out.println("You can not make a deposit less than $1");
		}
		else {
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			
			String sql =  "UPDATE accounts set current_balance=? WHERE customerid=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, depositAmount + a.getCurrentBalance());
			ps.setInt(2, u.getId());
			ps.execute();

			String sql1 = "INSERT INTO transactions (account_number, transactions_type, transaction_amount) values (?,?,?)";
			
			PreparedStatement ps5 = con.prepareStatement(sql1);
			ps5.setInt(1, a.getAcctNumber());
			ps5.setString(2, "Deposit");
			ps5.setInt(3, depositAmount);
			
			ps5.execute();
			
			Logging.logger.info("Deposit has been made.");
		}//end of try
		catch (SQLException e) {
			Logging.logger.warn("Account created that already exists in the database");
		}//end of catch
	}//end of else
}//end of deposit

	
	
	@Override
	public void withDrawal(User u, int withDrawalAmount) {
		Account a = getAccountByUser(u);
		
		if(a.getCurrentBalance() < withDrawalAmount) {
			
			System.out.println("We're unable to complete this transaction. Please try again later.");
			
			}
		else {
		try {
			Connection con = conUtil.getConnection();
		
			String sql =  "UPDATE accounts set current_balance=? WHERE customerid=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  a.getCurrentBalance() - withDrawalAmount);
			ps.setInt(2, u.getId());
			ps.execute();
			
			String sql1 = "INSERT INTO transactions (account_number, transactions_type, transaction_amount) values (?,?,?)";
			
			PreparedStatement ps5 = con.prepareStatement(sql1);
			ps5.setInt(1, a.getAcctNumber());
			ps5.setString(2, "Withdrawal");
			ps5.setInt(3, withDrawalAmount);
			
			ps5.execute();

			Logging.logger.info("A withdrawal has been made.");					
		}//end of try
		
		catch (SQLException e) {
			Logging.logger.warn("Account created that already exists in the database");
			}//end of catch
		}// end of try
	}//end of deposit
		
	
	public void transfer () {
		
		System.out.println("Please enter the account number you want to transfer money from: ");
		int fromAcct = Integer.parseInt(scan.nextLine());
		
		System.out.println("Please enter the transfer amount: ");
		int transferAmount = Integer.parseInt(scan.nextLine());
		
		if (transferAmount > 0) {
			
			String sql1 = "Select current_balance FROM accounts WHERE account_number = ?";
			Connection con = conUtil.getConnection();
		
			try {
			
				PreparedStatement ps = con.prepareStatement(sql1);
				ps.setInt(1,  fromAcct);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					int current_balance = rs.getInt("current_balance");
					
					if(transferAmount <= current_balance) {
						
						System.out.println("Please enter the account number you would like to transfer money into.");
						int toAcct = Integer.parseInt(scan.nextLine());
						
						String sql2 = "SELECT current_balance FROM accounts WHERE account_number = ?";
						PreparedStatement ps2 = con.prepareStatement(sql2);
						
						ps2.setInt(1, toAcct);
						
						rs = ps2.executeQuery();
						
						if(rs.next()) {
							
							String sql3 = "UPDATE accounts SET current_balance=? WHERE account_number = ?";
							
							PreparedStatement ps3 = con.prepareStatement(sql3);
							ps3.setInt(1,  current_balance - transferAmount);
							ps3.setInt(2, fromAcct);
							
							ps3.executeUpdate();
							
							String sql4 = "UPDATE accounts SET current_balance = current_balance + ? WHERE account_number = ?";
							
							PreparedStatement ps4 = con.prepareStatement(sql4);
							ps4.setInt(1, transferAmount);
							ps4.setInt(2, toAcct);
							
							ps4.executeUpdate();
							
							System.out.println("************************************************************************************");
							System.out.println("Transfer is successful." );
							System.out.println("*************************************************************************************");
							
							Logging.logger.info("Successful transfer");
							
							String sql5 = "INSERT INTO transactions ( account_number, transactions_type, transaction_amount) values (?,?,?)";
							
							PreparedStatement ps5 = con.prepareStatement(sql5);
							ps5.setInt(1, fromAcct);
							ps5.setString(2, "Transfer");
							ps5.setInt(3, transferAmount);
							
							ps5.execute();
													
						} else {
							
							System.out.println("The receiving account number does not exist!");
							}
						} else {
							System.out.println("The account balance is insufficient!");
						}
					} else {
						System.out.println("The account number entered is incorrect");
					}
			}
				catch (SQLException e) {
					Logging.logger.warn("Your transfer could not be processed at this time.");
				}
		
			}else {
		           System.out.println("Please try again!");
			}         this.transfer(); 
		}
		
	}//end of class



















	
			

	