package com;

public interface Loanable {
	/**
	 * �������
	 * @param money
	 */
	public void requestLoan(double money);
	/**
	 * ֧������
	 * @param money
	 */
	public void payLoan(double money);
	/**
	 * ��ȡ�û������ܶ�
	 */
	public double getLoan();
}
