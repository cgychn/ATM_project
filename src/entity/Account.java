package entity;

import java.io.Serializable;

import exception.BalanceNotEnoughException;

public abstract class Account implements Serializable {
	protected long id;
	protected String password;
	protected String name;
	protected String personId;
	protected String email;
	protected double balance;
	public Account(){
		
	}
	public Account(long id,String password,String name,String personId,String email,double balance){
		this.id = id;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.email = email;
		this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public final Account deposit(double num){
		this.setBalance(this.getBalance()+num);
		System.out.println("存款成功");
		return this;
	}
	public abstract Account withdraw(double num) throws BalanceNotEnoughException;
	
	/**
	 * 格式化输出
	 * @return String
	 */
	@Override
	public String toString(){
		String str = "id:"+id+",password:"+password+",name:"+name+",personId:"+personId+",email:"+email+",balance:"+balance;
		return str;
	}
}
