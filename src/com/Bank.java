package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import util.Constant;
import util.Util;
import entity.Account;
import entity.CreditAccount;
import entity.LoanCreditAccount;
import entity.LoanSavingAccount;
import entity.SavingAccount;
import exception.BalanceNotEnoughException;
import exception.LoginException;
import exception.RegisterException;

public class Bank {
	private List<Account> accountList = Constant.ACCOUNTLIST;
	/**
	 * �����췽��˽�л���ȷ�����ܱ��ⲿʵ����
	 */
	private Bank(){};
	//��������
	private static Bank bankInstance= new Bank();
	//id��
	private static long AUTOID = 100000;
	/**
	 * �ṩ�������ⲿ����
	 * @return Bank
	 */
	public static Bank getInstance(){
		return bankInstance;
	}
	/**
	 * ע���˻�
	 * @param id
	 * @param password
	 * @param name
	 * @param personId
	 * @param email
	 * @param balance
	 * @param accountType
	 * @return Account
	 */
	public Account register(long id,String password,String name,String personId,String email,double balance,String accountType) throws RegisterException{
		//����idΪϵͳ�Զ�
		//id = AUTOID;
		//AUTOID = AUTOID + 1;
		id = oprateFileToGetNewId("src/com/accountid.txt");
		//����˻��Ƿ����
		for(Account account : accountList){
			if(account.getId()==id){
				throw new RegisterException("�˻��Ѵ���");
			}
		}
		Account account;
		if(accountType.equals("�����˻�")){
			//Ĭ��10000��͸֧��ȣ���������޸�
			account = new CreditAccount(id,password,name,personId,email,0,10000);
			
		}
		else if(accountType.equals("�����˻�")){
			account = new SavingAccount(id,password,name,personId,email,0);
		}
		else if(accountType.equals("������˻�")){
			account = new LoanSavingAccount(id,password,name,personId,email,0,10000);
		}
		else{
			account = new LoanCreditAccount(id,password,name,personId,email,0,10000,100000);
		}
		accountList.add(account);
		//����¼д���ļ�
		Util.writeAccountToFile(account,true);
		return account;
	}
	/**
	 * ��½�˻�
	 * @param id
	 * @param password
	 * @return Account
	 */
	public Account login(long id , String password) throws LoginException{
		for(Account account : accountList){
			if(account.getId()==id && account.getPassword().equals(password)){
				return account;
			}
		}
		throw new LoginException("���޴��˻�");
	}
	/**
	 * ���
	 * @param id
	 * @param num
	 * @return Account
	 */
	public Account deposit(long id, double num){
		for(Account account : accountList){
			if(account.getId()==id){
				Account accountTemp = account.deposit(num);
				Util.updateAccount();
				return accountTemp;
			}
		}
		return null;
	}
	/**
	 * ȡ��
	 * @param id
	 * @param num
	 * @return Account
	 */
	public Account withdraw(long id, double num){
		for(Account account : accountList){
			if(account.getId()==id){
				try {
					Account accountTemp = account.withdraw(num);
					Util.updateAccount();
					return accountTemp;
				} catch (BalanceNotEnoughException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * ����͸֧���
	 * @param id
	 * @param num
	 * @return Account
	 */
	public Account setCeiling(long id ,double num){
		for(Account account : accountList){
			if(account.getId()==id){
				//�ж��Ƿ���͸֧�˻�
				if(CreditAccount.class.isInstance(account)){
					((CreditAccount)account).setCeiling(num);
				}
				Util.updateAccount();
				return account;
			}
		}
		return null;
	}
	/**
	 * ת�ˣ�ֻ�д������ת�ˣ�
	 * @param from
	 * @param to
	 * @param money
	 * @return Account
	 */
	public boolean transfer(long from , long to , double money){
		Account accountFrom = null;
		Account accountTo = null;
		//�Ȳ�����Ǯ�˻��Ƿ���ڣ���������ھͲ�ת����ֹ�������
		boolean isExist = false;
		for(Account account : accountList){
			if(account.getId()==to){
				accountTo = account;
				isExist = true;
			}
		}
		if(!isExist){
			return false;
		}
		for(Account account : accountList){
			if(account.getId()==from){
				accountFrom = account;
				//�ж��Ƿ���͸֧�˻�
				if(SavingAccount.class.isInstance(accountFrom)){
					//ִ��ת��
					try {
						accountFrom.withdraw(money);
					} catch (BalanceNotEnoughException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					accountTo.deposit(money);
					Util.updateAccount();
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * ����
	 * @param id
	 * @param money
	 * @return Account
	 */
	public Account requestLoan(long id , double money){
		for(Account account : accountList){
			if(account.getId()==id){
				if(LoanSavingAccount.class.isInstance(account)){
					((LoanSavingAccount)account).requestLoan(money);
					System.out.println("�������ɹ�");
				}
				if(LoanCreditAccount.class.isInstance(account)){
					((LoanCreditAccount)account).requestLoan(money);
					System.out.println("���ÿ�����ɹ�");
				}
				Util.updateAccount();
				return account;
			}
		}
		return null;
	}
	/**
	 * ������
	 * @param id
	 * @param money
	 * @return Account
	 */
	public Account payLoan(long id , double money){
		for(Account account : accountList){
			if(account.getId()==id){
				if(LoanSavingAccount.class.isInstance(account)){
					((LoanSavingAccount)account).payLoan(money);
					System.out.println("���������ɹ�");
				}
				if(LoanCreditAccount.class.isInstance(account)){
					((LoanCreditAccount)account).payLoan(money);
					System.out.println("���ÿ�������ɹ�");
				}
				Util.updateAccount();
				return account;
			}
		}
		return null;
	}
	/**
	 * ͳ�������˻������ܶ�
	 * @return double
	 */
	public double getAllAccountLoan(){
		double sum = 0.0;
		for(Account account : accountList){
			if(LoanSavingAccount.class.isInstance(account)){
				sum = sum + ((LoanSavingAccount)account).getLoan();
			}
			if(LoanCreditAccount.class.isInstance(account)){
				sum = sum + ((LoanCreditAccount)account).getLoan();
			}
		}
		return sum;
	}
	
	/**
	 * ��ʽ�����
	 * @return String
	 */
	@Override
	public String toString(){
		String str = "";
		str = "�û��ܴ���"+getAllAccountLoan()+"\n�û��б�";
		for(Account account : accountList){
			str = str + account.toString()+"\n";
		}
		return str;
	}
	
	/**
	 * �����˻�
	 */
	public void sortAccount(){
		Map<String, Double> hashMap = new HashMap<String, Double>();
		for(Account account : accountList){
			//������ھ�ִ�мӲ���
			if(hashMap.containsKey(account.getPersonId())){
				hashMap.put(account.getPersonId() , hashMap.get(account.getPersonId())+account.getBalance());
			}
			//��������ھ�ִ����Ӳ���
			else{
				hashMap.put(account.getPersonId(), account.getBalance());
			}
		}
		//��map����
		ArrayList<Entry<String, Double>> arrayList = new ArrayList<Map.Entry<String,Double>>(hashMap.entrySet());
		//����
		Collections.sort(arrayList, new Comparator<Map.Entry<String, Double>>(){
		    public int compare(Map.Entry<String, Double> map1, Map.Entry<String,Double> map2) {
		        return ((map2.getValue() - map1.getValue() == 0) ? 0 : (map2.getValue() - map1.getValue() > 0) ? 1 : -1);
		    }
		});
		//���
		for (Entry<String, Double> entry : arrayList) {
		    System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
	/**
	 * ���ļ��л�ȡ�µ�ID
	 * @param filePath
	 * @return long
	 */
	public long oprateFileToGetNewId(String filePath){
		long newId = 0;
		//��ȡ�ļ�����
		File  file = new File(filePath);
		BufferedReader reader = null;
		FileWriter fw = null;
        BufferedWriter bw = null;
        //�ȶ�ȡ�ļ��е�������Ϊ��ǰ��¼��id
		try {
			String temp = "";
			reader = new BufferedReader(new FileReader(file));
			while(null != (temp = reader.readLine())){
				//�����stringת������
				newId = Long.parseLong(temp.trim());
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��������¼��id+1��Ϊ�µ�id����һ��ʹ��
		try{
			fw = new FileWriter(file,false);
			bw = new BufferedWriter(fw);
			bw.write((newId + 1)+"");
			bw.close();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return newId;
	}
}
