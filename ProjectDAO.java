package com.capg.projectdao;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;


import com.capg.projectbean.BankTransactions;
import com.capg.projectbean.ProjectBean;

public class ProjectDAO implements ProjectDAOI{
	ProjectBean pb1;
	HashMap<Long, ProjectBean> hx=null;
	HashMap<BankTransactions,Long> hx1=null;
	public ProjectDAO() {
		hx=new HashMap<Long,ProjectBean>();
		hx1=new HashMap<BankTransactions,Long>();
	}
	@Override
	public ProjectBean createAccount(ProjectBean bean1) {
		// TODO Auto-generated method stub
		hx.put(bean1.getAccNo(), bean1);
		ProjectBean pb1=(ProjectBean) hx.get(bean1.getAccNo());
		return pb1;
	}
	@Override
	public ProjectBean showBalance(long accNo) throws AccountNotFoundException {
		ProjectBean pb1=(ProjectBean) hx.get(accNo);
		if(pb1==null) {
			throw new AccountNotFoundException("not a valid account num");
		}
		else {
			
		return pb1;
	}}
	@Override
	public ProjectBean deposit(long accNo,int bal) {
		// TODO Auto-generated method stub
		ProjectBean pb1=(ProjectBean) hx.get(accNo);
		if(pb1==null) {
			throw new AccountNotFoundException("not a valid account num");
		}
		else {
		float s=pb1.getBalance();
		float s1=bal+s;
		pb1.setBalance(s1);
		Date date=(Date) Calendar.getInstance().getTime();
		DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate=dateformat.format(date);
		Random r=new Random();
		int transId=r.nextInt(289);
		BankTransactions t=new BankTransactions();
		t.setTransid(transId);
		t.setDateOfTrans(strDate);
		t.setBalance(s1);
		t.setTransType("deposit");
		hx1.put(t, accNo);
		return pb1;
	}}
	@Override
	public ProjectBean withdraw(long accNo,  int bal1) {
		// TODO Auto-generated method stub
		ProjectBean pb1=(ProjectBean) hx.get(accNo);
		if(pb1==null) {
			throw new AccountNotFoundException("not a valid account num");
		}
		else if(pb1.getBalance()<=bal1) {
				throw new InsufficientBalanceException("insufficient balance", accNo);
			}else {
		float s=pb1.getBalance();
		float s1=s-bal1;
		pb1.setBalance(s1);
		Date date=(Date) Calendar.getInstance().getTime();
		DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate=dateformat.format(date);
		Random r=new Random();
		int transId=r.nextInt(289);
		BankTransactions t=new BankTransactions();
		t.setTransid(transId);
		t.setDateOfTrans(strDate);
		t.setBalance(s1);
		t.setTransType("withdraw");
		hx1.put(t, accNo);
		return pb1;
		
	}}
	@Override
	public ProjectBean fundTransfer(long accNo,long accNo1,  int bal2) {
		// TODO Auto-generated method stub
		ProjectBean pb1=(ProjectBean) hx.get(accNo);
		ProjectBean pb2=(ProjectBean) hx.get(accNo1);
		if(pb1==null) {
			throw new AccountNotFoundException("not a valid account num");
		}
		else {
			if(pb1.getBalance()<=bal2) {
				throw new InsufficientBalanceException("insufficient balance", accNo1);
			}
		float s=pb1.getBalance();
		float s1=s-bal2;
		float s2=pb2.getBalance();
		float s3=s+bal2;
		pb1.setBalance(s1);
		pb2.setBalance(s3);
		Date date=(Date) Calendar.getInstance().getTime();
		DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate=dateformat.format(date);
		Random r=new Random();
		int transId=r.nextInt(289);
		BankTransactions t=new BankTransactions();
		t.setTransid(transId);
		t.setDateOfTrans(strDate);
		t.setBalance(s1);
		t.setTransType("transfer");
		hx1.put(t, accNo);
		return pb1;
	}}
	public ArrayList<BankTransactions> getTransactions(long accNo) {
		ArrayList<BankTransactions> al=new ArrayList<BankTransactions>(hx1.keySet());
		System.out.println(al);
		return al;
	}}
