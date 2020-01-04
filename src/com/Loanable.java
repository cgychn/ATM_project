package com;

public interface Loanable {
	/**
	 * 申请贷款
	 * @param money
	 */
	public void requestLoan(double money);
	/**
	 * 支付贷款
	 * @param money
	 */
	public void payLoan(double money);
	/**
	 * 获取用户贷款总额
	 */
	public double getLoan();
}
