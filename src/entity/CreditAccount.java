package entity;

import exception.BalanceNotEnoughException;

public class CreditAccount extends Account{
	double ceiling;
	public CreditAccount(){}
	public CreditAccount(long id,String password,String name,String personId,String email,double balance,double ceiling){
		super(id,password,name,personId,email,balance);
		this.ceiling = ceiling;
	}
	public double getCeiling() {
		return ceiling;
	}
	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}
	
	/**
	 * ȡ��
	 */
	@Override
	public Account withdraw(double num) throws BalanceNotEnoughException{
		if(this.ceiling+this.getBalance() >= num){
			System.out.println("ȡ��ɹ�");
			this.setBalance(this.getBalance() - num);
		}else{
			throw new BalanceNotEnoughException("͸֧��Ȳ������޷�͸֧ȡ��");
		}
		return this;
	}

	/**
	 * ��ʽ�����
	 * @return String
	 */
	@Override
	public String toString(){
		String str = super.toString()+",ceiling:"+ceiling;
		return str;
	}
	
}
	
