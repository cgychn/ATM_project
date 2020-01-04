/*
 * MainPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import util.Constant;



/**
 *
 * @author  __USER__
 */
public class MainPanel extends javax.swing.JPanel {
	ATMClient atmClient;
	/** Creates new form MainPanel */
	public MainPanel(ATMClient atmClient) {
		this.atmClient = atmClient;
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("\u6a21\u62df ICBC ATM \u7ec8\u7aef");
		jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jButton1.setText("\u6ce8\u518c");
		jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u767b\u9646");
		jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
						.add(111, 111, 111)
						.add(layout
								.createParallelGroup(
										org.jdesktop.layout.GroupLayout.TRAILING,
										false)
								.add(layout
										.createSequentialGroup()
										.add(jButton1)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).add(jButton2))
								.add(org.jdesktop.layout.GroupLayout.LEADING,
										jLabel1))
						.addContainerGap(121, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING,
						layout.createSequentialGroup()
								.add(53, 53, 53)
								.add(jLabel1)
								.addPreferredGap(
										org.jdesktop.layout.LayoutStyle.RELATED,
										111, Short.MAX_VALUE)
								.add(layout
										.createParallelGroup(
												org.jdesktop.layout.GroupLayout.BASELINE)
										.add(jButton2).add(jButton1))
								.add(79, 79, 79)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		//µ¯³ö×¢²áÒ³Ãæ
		RegisterPanel registerPanel = new RegisterPanel(atmClient);
		for(JPanel jp : Constant.JPANELLIST){
			atmClient.remove(jp);
		}
		//atmClient.remove(Constant.JPANELLIST.get(0));
		Constant.JPANELLIST.add(registerPanel);
		atmClient.add(registerPanel, new FlowLayout(FlowLayout.CENTER));
		//atmClient.repaint();
		atmClient.validate();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		LoginPanel loginPanel = new LoginPanel(atmClient);
		for(JPanel jp : Constant.JPANELLIST){
			atmClient.remove(jp);
		}
		//atmClient.remove(Constant.JPANELLIST.get(0));
		Constant.JPANELLIST.add(loginPanel);
		atmClient.add(loginPanel, new FlowLayout(FlowLayout.CENTER));
		//atmClient.repaint();
		atmClient.validate();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	// End of variables declaration//GEN-END:variables

}