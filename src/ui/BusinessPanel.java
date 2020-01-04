/*
 * BusinessPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package ui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import util.Constant;

import com.Bank;
import com.To;

import entity.Account;
import entity.CreditAccount;
import entity.LoanCreditAccount;
import entity.LoanSavingAccount;
import entity.SavingAccount;

/**
 *
 * @author  __USER__
 */
public class BusinessPanel extends javax.swing.JPanel {
	ATMClient atmClient;
	Account account;

	/** Creates new form BusinessPanel */
	public BusinessPanel(ATMClient atmClient, Account account) {
		this.account = account;
		this.atmClient = atmClient;
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jButton4 = new javax.swing.JButton();

		jButton1.setText("jButton1");

		jLabel1.setText("\u8d26\u6237\uff1a");

		jLabel2.setText("\u59d3\u540d\uff1a");

		jLabel3.setText("\u4f59\u989d\uff1a");

		jLabel4.setText("\u4fe1\u7528\u989d\u5ea6\uff1a");

		jLabel5.setText("\u8d37\u6b3e\u989d\uff1a");

		jLabel6.setText(account.getId()+"");

		jLabel7.setText(account.getName());

		jLabel8.setText(account.getBalance()+"");

		
		if(LoanCreditAccount.class.isInstance(account)){
			jLabel9.setText(((LoanCreditAccount)account).getCeiling()+"");
			jLabel10.setText(((LoanCreditAccount)account).getLoan()+"");
		}
		if(LoanSavingAccount.class.isInstance(account)){
			jLabel9.setText("不能透支");
			jLabel10.setText(((LoanSavingAccount)account).getLoan()+"");
		}
		if((!LoanCreditAccount.class.isInstance(account)) && CreditAccount.class.isInstance(account)){
			jLabel9.setText(((CreditAccount)account).getCeiling()+"");
			jLabel10.setText("不能贷款");
		}
		if((!LoanSavingAccount.class.isInstance(account)) && SavingAccount.class.isInstance(account)){
			jLabel9.setText("不能透支");
			jLabel10.setText("不能贷款");
		}

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"存款", "取款", "贷款", "还贷款" }));

		jButton2.setText("\u63d0\u4ea4");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u8fd4\u56de");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jTextField1.setText("0");

		jLabel11.setText("\u8f6c\u8d26\uff1a");

		jTextField2.setText("toid");

		jTextField3.setText("money");

		jButton4.setText("\u8f6c\u8d26");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.add(102, 102, 102)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.TRAILING,
										false)
								.add(layout
										.createSequentialGroup()
										.add(jButton2)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).add(jButton3))
								.add(layout
										.createSequentialGroup()
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(jLabel1)
												.add(jLabel2)
												.add(jLabel3)
												.add(jLabel4)
												.add(jLabel5)
												.add(jComboBox1,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.add(layout
														.createSequentialGroup()
														.add(jLabel11)
														.addPreferredGap(
																org.jdesktop.layout.LayoutStyle.RELATED)
														.add(layout
																.createParallelGroup(
																		org.jdesktop.layout.GroupLayout.LEADING)
																.add(layout
																		.createSequentialGroup()
																		.add(10,
																				10,
																				10)
																		.add(jButton4))
																.add(jTextField2,
																		org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																		65,
																		org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING,
														false)
												.add(jTextField3)
												.add(jLabel10,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.add(jLabel9).add(jLabel8)
												.add(jLabel7).add(jLabel6)
												.add(jTextField1))))
						.addContainerGap(116, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.add(28, 28, 28)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel1).add(jLabel6))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel2).add(jLabel7))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel3).add(jLabel8))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel4).add(jLabel9))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel5).add(jLabel10))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jComboBox1,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jTextField1,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jTextField3,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jTextField2,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jLabel11))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(jButton4)
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED, 20,
								Short.MAX_VALUE)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jButton3).add(jButton2)).add(31, 31, 31)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		//提交转账
		long toId = Long.parseLong(jTextField2.getText());
		double money = Double.parseDouble(jTextField3.getText());
		To to = new To();
		to.setAction("transfer");
		to.setMyAccount(account);
		to.setMoney(money);
		to.setToAccountId(toId);
		if (Constant.ATMCLIENTSERVICE.sendMsg(to)) {
			to = Constant.ATMCLIENTSERVICE.receiveMsg();
			account = to.getMyAccount();
			to.setAction("login");
			if(Constant.ATMCLIENTSERVICE.sendMsg(to)){
				to = Constant.ATMCLIENTSERVICE.receiveMsg();
				BusinessPanel businessPanel = new BusinessPanel(atmClient, to.getMyAccount());
				for (JPanel jp : Constant.JPANELLIST) {
					atmClient.remove(jp);
				}
				//atmClient.remove(Constant.JPANELLIST.get(0));
				Constant.JPANELLIST.add(businessPanel);
				atmClient.add(businessPanel, new FlowLayout(FlowLayout.CENTER));
				//atmClient.repaint();
				atmClient.validate();
			}
//			BusinessPanel businessPanel = new BusinessPanel(atmClient, to.getMyAccount());
//			for (JPanel jp : Constant.JPANELLIST) {
//				atmClient.remove(jp);
//			}
//			//atmClient.remove(Constant.JPANELLIST.get(0));
//			Constant.JPANELLIST.add(businessPanel);
//			atmClient.add(businessPanel, new FlowLayout(FlowLayout.CENTER));
//			//atmClient.repaint();
//			atmClient.validate();
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		MainPanel businessPanel = new MainPanel(atmClient);
		for (JPanel jp : Constant.JPANELLIST) {
			atmClient.remove(jp);
		}
		//atmClient.remove(Constant.JPANELLIST.get(0));
		Constant.JPANELLIST.add(businessPanel);
		atmClient.add(businessPanel, new FlowLayout(FlowLayout.CENTER));
		//atmClient.repaint();
		atmClient.validate();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String optionType = jComboBox1.getSelectedItem().toString();
		//Bank bank = Bank.getInstance();
		double money = Double.parseDouble(jTextField1.getText());
		To to = new To();
		if (optionType.equals("取款")) {
			to.setAction("withdraw");
			to.setMoney(money);
			to.setMyAccount(account);
			//bank.withdraw(account.getId(), money);
		}
		if (optionType.equals("存款")) {
			to.setAction("deposit");
			to.setMoney(money);
			to.setMyAccount(account);
			//bank.deposit(account.getId(), money);
		}
		if (optionType.equals("还贷款")) {
			to.setAction("payLoan");
			to.setMoney(money);
			to.setMyAccount(account);
			//bank.payLoan(account.getId(), money);
		}
		if (optionType.equals("贷款")) {
			to.setAction("requestLoan");
			to.setMoney(money);
			to.setMyAccount(account);
			//bank.requestLoan(account.getId(), money);
		}
		if (Constant.ATMCLIENTSERVICE.sendMsg(to)) {
			to = Constant.ATMCLIENTSERVICE.receiveMsg();
			account = to.getMyAccount();
			BusinessPanel businessPanel = new BusinessPanel(atmClient, account);
			for (JPanel jp : Constant.JPANELLIST) {
				atmClient.remove(jp);
			}
			//atmClient.remove(Constant.JPANELLIST.get(0));
			Constant.JPANELLIST.add(businessPanel);
			atmClient.add(businessPanel, new FlowLayout(FlowLayout.CENTER));
			//atmClient.repaint();
			atmClient.validate();
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}