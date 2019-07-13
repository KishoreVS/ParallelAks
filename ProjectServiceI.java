package com.capg.projectservice;

import java.util.ArrayList;

import com.capg.projectbean.ProjectBean;
import com.capg.projectdao.AccountNotFoundException;

public interface ProjectServiceI {
	public ProjectBean createAccount(ProjectBean bean1);
	public ProjectBean showBalance(long accNo) throws AccountNotFoundException;
	public ProjectBean deposit(long accNo,int bal) ;
	public ProjectBean withdraw(long accNo,int bal1) ;
	public ProjectBean fundTransfer(long accNo,long accNo1,int bal2);
	public ArrayList getTransactions(long accNo);
}
