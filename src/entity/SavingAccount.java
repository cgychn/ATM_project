package entity;

import exception.BalanceNotEnoughException;

public class SavingAccount extends Account{
	public SavingAccount(){}
	public SavingAccount(long id,String password,String name,String personId,String email,double balance){
		super(id,password,name,personId,email,balance);
	}
	/**
	 * 取款
	 */
	@Override
	public Account withdraw(double num) throws BalanceNotEnoughException{
		if(this.getBalance()>=num){
			System.out.println("取款成功");
			this.setBalance(this.getBalance()-num);
		}else{
			throw new BalanceNotEnoughException("余额不足");
		}
		return this;
	}
	/**
	 * 格式化输出
	 * @return String
	 */
	@Override
	public String toString(){
		String str = super.toString();
		return str;
	}
}
