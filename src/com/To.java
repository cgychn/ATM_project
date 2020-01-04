package com;

import java.io.Serializable;

import entity.Account;

public class To implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 操作
	 */
	private String action ;
	
	/**
	 * 客户端登录账户
	 */
	private Account myAccount ;
	
	/**
	 * 开户时的二次密码
	 */
	private String repassword ;
	
	/**
	 * 交互的金钱
	 */
	private double money ;
	
	/**
	 * 与之交互的账户
	 */
	private long toAccountId;
	public long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(long toAccountId) {
		this.toAccountId = toAccountId;
	}

	private Account toAccount ;

	public To() {
	}
	
	public To(String action, Account myAccount, Account toAccount) {
		this.action = action;
		this.myAccount = myAccount;
		this.toAccount = toAccount;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Account getMyAccount() {
		return myAccount;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public void setMyAccount(Account myAccount) {
		this.myAccount = myAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	
	
	
}
