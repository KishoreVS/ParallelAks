package com.capg.projectbean;
public class ProjectBean {
	String uname;
	String pwd;
	float balance;
	String mobileNo;
    long accNo;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public ProjectBean(String uname, String pwd, float balance, String mobileNo, long accNo) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.balance = balance;
		this.mobileNo = mobileNo;
		this.accNo = accNo;
	}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "AccountNumber:"+accNo;
	}}