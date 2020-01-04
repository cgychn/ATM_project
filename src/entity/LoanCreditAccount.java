package entity;

import com.Loanable;

import exception.BalanceNotEnoughException;

public class LoanCreditAccount extends CreditAccount implements Loanable{
	double Loan;
	public LoanCreditAccount(long id,String password,String name,String personId,String email,double balance,double ceiling,double loan){
		this.id = id;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.email = email;
		this.balance = balance;
		this.ceiling = ceiling;
		this.Loan = loan;
	}
	public void setLoan(double loan) {
		Loan = loan;
	}

	/**
	 * ����
	 * @param money
	 */
	public void requestLoan(double money) {
		// TODO Auto-generated method stub
		if(money <= getLoan()){
			//���Դ���
			this.setLoan(this.getLoan() - money);
			this.deposit(money);
			System.out.println("����ɹ�");
		}else{
			System.out.println("����ʧ��");
		}
	}

	/**
	 * ������
	 * @param money
	 */
	public void payLoan(double money) {
		// TODO Auto-generated method stub
		if(this.getBalance() >= money){
			try {
				this.withdraw(money);
			} catch (BalanceNotEnoughException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setLoan(this.getLoan()+money);
			System.out.println("������ɹ�");
		}else{
			System.out.println("������ʧ��");
		}
	}

	/**
	 * ��ȡ�˻��Ĵ�����
	 */
	public double getLoan() {
		// TODO Auto-generated method stub
		return Loan;
	}
	/**
	 * ��ʽ�����
	 * @return String
	 */
	@Override
	public String toString(){
		String str = super.toString()+",Loan:"+Loan;
		return str;
	}

}
