package com.capg.projectdao;

public class InsufficientBalanceException extends RuntimeException {

	private float balance;
	public InsufficientBalanceException(String message,float balance) {
		super(message);
		
		
	}
	
}
