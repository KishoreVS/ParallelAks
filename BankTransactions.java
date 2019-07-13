package com.capg.projectbean;

import java.sql.Date;

public class BankTransactions {
	private int transid;
    private String dateOfTrans;
	private String transType;
	private float balance;
	private long accFrom;
	private long accTo;
	
	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	public String getDateOfTrans() {
		return dateOfTrans;
	}

	public void setDateOfTrans(String dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public long getAccFrom() {
		return accFrom;
	}

	public void setAccFrom(long accFrom) {
		this.accFrom = accFrom;
	}

	public long getAccTo() {
		return accTo;
	}

	public void setAccTo(long accTo) {
		this.accTo = accTo;
	}

	public BankTransactions(int transid, String dateOfTrans, String transType, float balance, long accFrom,
			long accTo) {
		super();
		this.transid = transid;
		this.dateOfTrans = dateOfTrans;
		this.transType = transType;
		this.balance = balance;
		this.accFrom = accFrom;
		this.accTo = accTo;
	}
public BankTransactions() {
		// TODO Auto-generated constructor stub
	}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "TransactionId:"+transid+"   Date:"+dateOfTrans+"   Balance:"+balance+"   TransactionType:"+transType;
}
	
}


	
	