package com.example.exceptions;

public class DepositOrWithdrawalException extends RuntimeException {
	
	
		private static final long serialVersionUID = 1L;

		public DepositOrWithdrawalException() {
		super("You account to withdraw or deposit an invalid amount.");
	}
	
}
