package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import entity.Account;
import entity.CreditAccount;
import entity.LoanCreditAccount;
import entity.LoanSavingAccount;
import entity.SavingAccount;
import exception.LoginException;
import exception.RegisterException;

public class ATMServerThread extends Thread {
	Socket socket = null;
	public ATMServerThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run(){
		System.out.println("action:");
		OutputStream out = null ;
		InputStream in = null ;
		ObjectOutputStream oos = null ;
		ObjectInputStream ois = null ;
		try {
			out = socket.getOutputStream() ;
			in = socket.getInputStream() ;
			oos = new ObjectOutputStream(out) ;
			ois = new ObjectInputStream(in) ;
			To send_message = null ;  //���������
			To receive_message = null  ;//�յ�������
			String action = "" ;
			while(!Thread.interrupted()){
				//���������տͻ��˴��ݵ�����
				receive_message = (To)ois.readObject() ;
				//��ò�������
				action = receive_message.getAction() ;
				System.out.println("action:"+action);
				if("exit".equals(action))
					break ;
				send_message = this.deal(receive_message, action) ;
				//�������ظ��ͻ���
				oos.writeObject(send_message.getMyAccount());
				oos.reset();
				oos.flush(); 
				send_message = null ;
			}
		} catch (SocketException e) {
			Thread.currentThread().interrupt();
			System.err.println("�ͻ����Ѿ��˳�"+ socket.getInetAddress());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
				try {
					if(oos != null)
						oos.close();
					if(out != null)
						out.close();
					if(ois != null)
						ois.close();
					if(in != null)
						in.close();
					if(socket != null)
						socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	private To deal(To to, String action) {
		// TODO Auto-generated method stub
		Bank bank = Bank.getInstance();
		Account myAccount = to.getMyAccount();
		Account realAccount = null;
		//��������
		if("register".equals(action)){
			myAccount.toString();
			String password = myAccount.getPassword() ;
			String name = myAccount.getName() ;
			String personId = myAccount.getPersonId() ;
			String email = myAccount.getEmail() ;
			String type = "";
			if(LoanCreditAccount.class.isInstance(myAccount)){
				realAccount = (LoanCreditAccount)myAccount;
				type = "���������˻�";
			}
			if(LoanSavingAccount.class.isInstance(myAccount)){
				realAccount = (LoanSavingAccount)myAccount;
				type = "������˻�";
			}
			if(!(LoanCreditAccount.class.isInstance(myAccount)) && CreditAccount.class.isInstance(myAccount)){
				realAccount = (CreditAccount)myAccount;
				type = "�����˻�";
			}
			if(!(LoanSavingAccount.class.isInstance(myAccount)) && SavingAccount.class.isInstance(myAccount)){
				realAccount = (SavingAccount)myAccount;
				type = "�����˻�";
			}
			synchronized(bank){
				try {
					realAccount = bank.register(0,password,name,personId,email,0.0,type) ;
				} catch (RegisterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			to.setMyAccount(realAccount);
		}
		
		//��¼����
		if("login".equals(action)){
			Account a = null ;
			synchronized(bank){
				try {
					System.out.println("login");
					System.out.println(myAccount.toString());
					a = bank.login(myAccount.getId(), myAccount.getPassword()) ;
					System.out.println(a.toString());
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			to.setMyAccount(a);
		}
		
		//���
		if("deposit".equals(action)){
			Account a = null ;
			synchronized(bank){
				a = bank.deposit(myAccount.getId(), to.getMoney()) ;
			}
			to.setMyAccount(a);
		}
		
		//ȡ��
		if("withdraw".equals(action)){
			Account a = null ;
			synchronized(bank){
				a = bank.withdraw(myAccount.getId(), to.getMoney()) ;
			}
			to.setMyAccount(a);
		}
		
		
		//����
		if("requestLoan".equals(action)){
			Account a = null ;
			synchronized(bank){
				a = bank.requestLoan(myAccount.getId(), to.getMoney()) ;
				to.setMyAccount(a); 
			}
		}
		
		//����
		if("payLoan".equals(action)){
			Account a = null ;
			synchronized(bank){
				a = bank.payLoan(myAccount.getId(), to.getMoney()) ;
				to.setMyAccount(a); 
			}
		}
		
		//ת��
		if("transfer".equals(action)){
			long toAccountId = to.getToAccountId() ;
			boolean bl = false ;
			synchronized(bank){
				bank.transfer(myAccount.getId(), toAccountId, to.getMoney()) ;
			}
		}
		
		//���๦��...
		return to ;
	}
	
}
