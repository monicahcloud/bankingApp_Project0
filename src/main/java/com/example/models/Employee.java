package com.example.models;

import java.util.List;
import java.util.Random;

public class Employee extends User {

	//instance variables 
	private static final long serialVersionUID = 1L;
	private int employeeNum;
	private boolean approval;
	private List<Employee> employees;
	//****************************************************************************************************//
	
	//constructors
		
	public Employee() {
		this.employeeNum = (new Random().nextInt(9000)+1000);
			}

	
	//****************************************************************************************************//
	
	//behaviors of the employee
	
	//An employee can approve or reject an account. 
	public String approveCustomerAccount(double initialDeposit) {
		
		String approved = "";
			
		if(initialDeposit >= 50) {
			approval = true;
			approved = "Your account has been approved.";
		} else {
			approval = false;
			approved = " You did not meet the minimum deposit required to open an account.";
		}
		return approved;
	}//end of approveCustomerAccount
	
	
	//An employee can view a customer's bank accounts.
	public void viewCustomerAccount() {	
		
		
	}//end of viewCustomerAccount


	public boolean isApproval() {
		return approval;
	}


	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	

	
}//end of class



