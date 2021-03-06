/*
 * RegisterPanel.java
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
import exception.RegisterException;

/**
 *
 * @author  __USER__
 */
public class RegisterPanel extends javax.swing.JPanel {
	ATMClient atmClient;

	/** Creates new form RegisterPanel */
	public RegisterPanel(ATMClient atmClient) {
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

		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		jLabel1.setText("\u8d26\u6237\u7c7b\u578b\uff1a");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"储蓄账户", "贷款储蓄账户", "信用账户", "贷款信用账户" }));

		jLabel2.setText("\u7528\u6237\u540d\uff1a");

		jLabel3.setText("\u5bc6\u7801\uff1a");

		jLabel4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");

		jLabel5.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");

		jLabel6.setText("\u8be6\u7ec6\u5730\u5740\uff1a");

		jLabel7.setText("E-Mail\uff1a");

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField5ActionPerformed(evt);
			}
		});

		jButton1.setText("\u63d0\u4ea4");
		jButton1.setActionCommand("jButton1");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.add(59, 59, 59)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.LEADING)
								.add(layout
										.createSequentialGroup()
										.add(jLabel5)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(jTextField4,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												181, Short.MAX_VALUE))
								.add(layout
										.createSequentialGroup()
										.add(jLabel4)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(jTextField3,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												181, Short.MAX_VALUE))
								.add(layout
										.createSequentialGroup()
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(jLabel1).add(jLabel2)
												.add(jLabel3))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(jTextField1,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														181, Short.MAX_VALUE)
												.add(jTextField2,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														181, Short.MAX_VALUE)
												.add(jComboBox1, 0, 181,
														Short.MAX_VALUE)))
								.add(layout
										.createSequentialGroup()
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(jLabel6).add(jLabel7))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(layout
												.createParallelGroup(
														org.jdesktop.layout.GroupLayout.LEADING)
												.add(jTextField6,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														181, Short.MAX_VALUE)
												.add(jTextField5,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														181, Short.MAX_VALUE))))
						.add(62, 62, 62))
				.add(layout
						.createSequentialGroup()
						.add(125, 125, 125)
						.add(jButton1)
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(jButton2).addContainerGap(126, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.addContainerGap()
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel1)
								.add(jComboBox1,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel2)
								.add(jTextField1,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel3)
								.add(jTextField2,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel4)
								.add(jTextField3,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel5)
								.add(jTextField4,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel6)
								.add(jTextField5,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jLabel7)
								.add(jTextField6,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.RELATED, 25,
								Short.MAX_VALUE)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.BASELINE)
								.add(jButton1).add(jButton2)).addContainerGap()));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
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

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		//调用注册方法
		//Bank bank = Bank.getInstance();
		long id = 0;
		String name = jTextField1.getText();
		String password = jTextField2.getText();
		String confirm = jTextField3.getText();
		String personId = jTextField4.getText();
		String accountType = jComboBox1.getSelectedItem().toString();
		double balance = 0.0;
		String email = jTextField6.getText();
		try {
			Account account = null;
			if(password.equals(confirm)){
				if(accountType.equals("储蓄账户")){
					account = new SavingAccount();
					account.setId(0);
					account.setName(name);
					account.setPassword(password);
					account.setPersonId(personId);
					account.setEmail(email);
					account.setBalance(balance);
				}
				if(accountType.equals("信用账户")){
					account = new CreditAccount();
					account.setId(0);
					account.setName(name);
					account.setPassword(password);
					account.setPersonId(personId);
					account.setEmail(email);
					account.setBalance(balance);
					((CreditAccount)account).setCeiling(10000);
				}
				if(accountType.equals("贷款储蓄账户")){
					account = new LoanSavingAccount(id,password,name,personId,email,balance,10000);
				}
				if(accountType.equals("贷款信用账户")){
					account = new LoanCreditAccount(id,password,name,personId,email,balance,10000,10000);
				}
				To to = new To();
				to.setAction("register");
				to.setMyAccount(account);
				if(Constant.ATMCLIENTSERVICE.sendMsg(to)){
					to = Constant.ATMCLIENTSERVICE.receiveMsg();
					account = to.getMyAccount();
					//跳转到账户信息显示界面
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
				
				
				//account = bank.register(id, password, name, personId,
				//	email, balance, accountType);
			}else{
				throw new RegisterException("密码和确认密码不一样");
			}

			

		} catch (RegisterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	// End of variables declaration//GEN-END:variables

}