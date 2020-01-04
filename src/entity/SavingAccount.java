package entity;

import exception.BalanceNotEnoughException;

public class SavingAccount extends Account{
	public SavingAccount(){}
	public SavingAccount(long id,String password,String name,String personId,String email,double balance){
		super(id,password,name,personId,email,balance);
	}
	/**
	 * ȡ��
	 */
	@Override
	public Account withdraw(double num) throws BalanceNotEnoughException{
		if(this.getBalance()>=num){
			System.out.println("ȡ��ɹ�");
			this.setBalance(this.getBalance()-num);
		}else{
			throw new BalanceNotEnoughException("����");
		}
		return this;
	}
	/**
	 * ��ʽ�����
	 * @return String
	 */
	@Override
	public String toString(){
		String str = super.toString();
		return str;
	}
}
