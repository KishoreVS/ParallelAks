package com.capg.projectservice;
import java.util.ArrayList;
import java.util.Scanner;

import com.capg.projectbean.ProjectBean;
import com.capg.projectdao.ProjectDAO;
public class ProjectService implements ProjectServiceI{
	Scanner sc=new Scanner(System.in);
ProjectDAO pd=new ProjectDAO();
public ProjectBean createAccount(ProjectBean bean1) {
	ProjectBean pb=pd.createAccount(bean1);
	return pb;
}
public int balValidation(int balance) {
	while(true) {
		if(balance<=0) {
			System.out.println("Amount should not be less than zero\n Please Enter Valid Amount");
			balance=sc.nextInt();
		}
		else {
			return balance;
		}
	}
}
public String nameValidation(String userName) {
	if(userName.matches("[A-Z][a-zA-Z]*")) {
		return userName;	
	}
	else {
		System.out.println("Enter A Valid Name With Uppercase");
	
	return userName=sc.next();
}}
public String mobileNoValidation(String mobileNo) {
	while(true) {
		if(String.valueOf(mobileNo).length()==10) {
			System.out.println(mobileNo);
			return mobileNo;
		}
		else {
			System.out.println("enter a valid 10 digit number");
			mobileNo=sc.next();
		}
	}
}





public ProjectBean showBalance(long accNo)  {
	ProjectBean bean=pd.showBalance(accNo);
	return bean;
}
public ProjectBean deposit(long accNo,int bal) {
	ProjectBean bean=pd.deposit(accNo,bal);
	return bean;
}
public ProjectBean withdraw(long accNo,int bal1) {
	ProjectBean bean=pd.withdraw(accNo,bal1);
	return bean;
}
public ProjectBean fundTransfer(long accNo,long accNo1,int bal2){
	ProjectBean bean=pd.fundTransfer(accNo,accNo1,bal2);
	return bean;
}
public ArrayList<?> getTransactions(long accNo) {
	ArrayList<?> al=pd.getTransactions(accNo);
	return al;
	
}
}
