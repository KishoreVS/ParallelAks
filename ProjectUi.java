package com.capg.projectui;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



import com.capg.projectbean.ProjectBean;
import com.capg.projectdao.AccountNotFoundException;
import com.capg.projectdao.InsufficientBalanceException;
import com.capg.projectservice.ProjectService;
public class ProjectUi {
public static void main(String[] args)throws Exception {
		String mobile;
		String uname;
		String password;
		int balance=2000;
		long accNo;
		ProjectService service=new ProjectService();
		while(true) {
		System.out.println("1.Create account");
		System.out.println("2.Show balance");
		System.out.println("3.Deposit");
		System.out.println("4.Withdraw");
		System.out.println("5.Fund Transfer");
		System.out.println("6.print Transaction");
        System.out.println("enter ur choice");
		Scanner sc=new Scanner(System.in);
		int d=sc.nextInt();
		switch(d) {
		case 1:
			System.out.println("enter mobileno");
			mobile=service.mobileNoValidation(sc.next());
			System.out.println("enter name");
			uname=service.nameValidation(sc.next());
			System.out.println("enter password");
			password=sc.next();
			Random r=new Random();
			accNo=r.nextInt(2000);
		    ProjectBean bean1=new ProjectBean(uname, password,balance,mobile,accNo);
			ProjectBean bean=service.createAccount(bean1);
			System.out.println("account succesfully created");
			System.out.println(bean);
			break;
		case 2:
			System.out.println("enter accountno");
			accNo=sc.nextLong();
			try {
			ProjectBean bean11=service.showBalance(accNo);
			System.out.println("Available Balance is"+bean11.getBalance());
			}
			catch(AccountNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			break;
		
		case 3:
			try {
			System.out.println("enter your account num");
			accNo=sc.nextLong();
			System.out.println("enter amount to deposit");
			int bal=service.balValidation(sc.nextInt());
			ProjectBean bean2=service.deposit(accNo,(int) bal);
			System.out.println("Available Balance is "+bean2.getBalance());
			}
			catch(AccountNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			break;
		
		case 4:

			try {
				System.out.println("enter your account num");
				accNo=sc.nextLong();
				System.out.println("enter amount to withdraw");
				int bal1=service.balValidation(sc.nextInt());
			ProjectBean bean3=service.withdraw(accNo,bal1);
			
			System.out.println("Available Balance is "+bean3.getBalance());
			}
			catch(AccountNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			catch(InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			System.out.println("enter your account num");
			accNo=sc.nextLong();
			System.out.println("enter receiver account number");
			long accNo1=sc.nextLong();
			System.out.println("enter amount to transfer");
			int bal2=service.balValidation(sc.nextInt());
			try {
			ProjectBean bean4=service.fundTransfer(accNo,accNo1,bal2);
			System.out.println("amount transfered successfully");
			System.out.println("Available Balance is "+bean4.getBalance());
			}
			catch(AccountNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			break;
		case 6:
			System.out.println("enter your account number");
			accNo=sc.nextLong();
			try {
			ArrayList<?> al=service.getTransactions(accNo);
			System.out.println(al+"\n");
			}
			catch(AccountNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
			break;
		case 7:System.exit(0);
		break;
		default:System.out.println("enter your choice");
		
			
			sc.close();
			
		}
	}
}}
