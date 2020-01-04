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
	 * 将构造方法私有化，确定不能被外部实例化
	 */
	private Bank(){};
	//创建单例
	private static Bank bankInstance= new Bank();
	//id号
	private static long AUTOID = 100000;
	/**
	 * 提供单例给外部调用
	 * @return Bank
	 */
	public static Bank getInstance(){
		return bankInstance;
	}
	/**
	 * 注册账户
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
		//设置id为系统自动
		//id = AUTOID;
		//AUTOID = AUTOID + 1;
		id = oprateFileToGetNewId("src/com/accountid.txt");
		//检测账户是否存在
		for(Account account : accountList){
			if(account.getId()==id){
				throw new RegisterException("账户已存在");
			}
		}
		Account account;
		if(accountType.equals("信用账户")){
			//默认10000的透支额度，后面可以修改
			account = new CreditAccount(id,password,name,personId,email,0,10000);
			
		}
		else if(accountType.equals("储蓄账户")){
			account = new SavingAccount(id,password,name,personId,email,0);
		}
		else if(accountType.equals("贷款储蓄账户")){
			account = new LoanSavingAccount(id,password,name,personId,email,0,10000);
		}
		else{
			account = new LoanCreditAccount(id,password,name,personId,email,0,10000,100000);
		}
		accountList.add(account);
		//将记录写入文件
		Util.writeAccountToFile(account,true);
		return account;
	}
	/**
	 * 登陆账户
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
		throw new LoginException("查无此账户");
	}
	/**
	 * 存款
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
	 * 取款
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
	 * 设置透支金额
	 * @param id
	 * @param num
	 * @return Account
	 */
	public Account setCeiling(long id ,double num){
		for(Account account : accountList){
			if(account.getId()==id){
				//判断是否是透支账户
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
	 * 转账（只有储蓄卡可以转账）
	 * @param from
	 * @param to
	 * @param money
	 * @return Account
	 */
	public boolean transfer(long from , long to , double money){
		Account accountFrom = null;
		Account accountTo = null;
		//先查找收钱账户是否存在，如果不存在就不转（防止误操作）
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
				//判断是否是透支账户
				if(SavingAccount.class.isInstance(accountFrom)){
					//执行转账
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
	 * 贷款
	 * @param id
	 * @param money
	 * @return Account
	 */
	public Account requestLoan(long id , double money){
		for(Account account : accountList){
			if(account.getId()==id){
				if(LoanSavingAccount.class.isInstance(account)){
					((LoanSavingAccount)account).requestLoan(money);
					System.out.println("储蓄卡贷款成功");
				}
				if(LoanCreditAccount.class.isInstance(account)){
					((LoanCreditAccount)account).requestLoan(money);
					System.out.println("信用卡贷款成功");
				}
				Util.updateAccount();
				return account;
			}
		}
		return null;
	}
	/**
	 * 还贷款
	 * @param id
	 * @param money
	 * @return Account
	 */
	public Account payLoan(long id , double money){
		for(Account account : accountList){
			if(account.getId()==id){
				if(LoanSavingAccount.class.isInstance(account)){
					((LoanSavingAccount)account).payLoan(money);
					System.out.println("储蓄卡还贷款成功");
				}
				if(LoanCreditAccount.class.isInstance(account)){
					((LoanCreditAccount)account).payLoan(money);
					System.out.println("信用卡还贷款成功");
				}
				Util.updateAccount();
				return account;
			}
		}
		return null;
	}
	/**
	 * 统计所有账户贷款总额
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
	 * 格式化输出
	 * @return String
	 */
	@Override
	public String toString(){
		String str = "";
		str = "用户总贷款额："+getAllAccountLoan()+"\n用户列表：";
		for(Account account : accountList){
			str = str + account.toString()+"\n";
		}
		return str;
	}
	
	/**
	 * 排名账户
	 */
	public void sortAccount(){
		Map<String, Double> hashMap = new HashMap<String, Double>();
		for(Account account : accountList){
			//如果存在就执行加操作
			if(hashMap.containsKey(account.getPersonId())){
				hashMap.put(account.getPersonId() , hashMap.get(account.getPersonId())+account.getBalance());
			}
			//如果不存在就执行添加操作
			else{
				hashMap.put(account.getPersonId(), account.getBalance());
			}
		}
		//将map排序
		ArrayList<Entry<String, Double>> arrayList = new ArrayList<Map.Entry<String,Double>>(hashMap.entrySet());
		//排序
		Collections.sort(arrayList, new Comparator<Map.Entry<String, Double>>(){
		    public int compare(Map.Entry<String, Double> map1, Map.Entry<String,Double> map2) {
		        return ((map2.getValue() - map1.getValue() == 0) ? 0 : (map2.getValue() - map1.getValue() > 0) ? 1 : -1);
		    }
		});
		//输出
		for (Entry<String, Double> entry : arrayList) {
		    System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
	/**
	 * 从文件中获取新的ID
	 * @param filePath
	 * @return long
	 */
	public long oprateFileToGetNewId(String filePath){
		long newId = 0;
		//获取文件对象
		File  file = new File(filePath);
		BufferedReader reader = null;
		FileWriter fw = null;
        BufferedWriter bw = null;
        //先读取文件中的内容作为当前记录的id
		try {
			String temp = "";
			reader = new BufferedReader(new FileReader(file));
			while(null != (temp = reader.readLine())){
				//将这个string转成数字
				newId = Long.parseLong(temp.trim());
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将该条记录的id+1作为新的id供下一次使用
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
