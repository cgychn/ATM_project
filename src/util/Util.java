package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import entity.Account;
import entity.CreditAccount;
import entity.LoanCreditAccount;
import entity.LoanSavingAccount;
import entity.SavingAccount;

public class Util {
	/**
	 * ���ļ��е�account��¼��������ŵ��б���
	 */
	public static void ReadFileAccount(){
		File  file = new File("src/com/accounts.txt");
		BufferedReader reader = null;
		String temp = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			Account account = null;
			while((temp = reader.readLine()) != null){
				temp = temp.trim();
				if(temp.startsWith("LoanCreditAccount")){
					//������˻�
					String infoStr = temp.split("\\|\\|")[1];
					System.out.println(infoStr);
					String[] infos = infoStr.split(",");
					long id = Long.parseLong(infos[0].split(":")[1]);
					String name = infos[1].split(":")[1];
					String password = infos[2].split(":")[1];
					String personId = infos[3].split(":")[1];
					String email = infos[4].split(":")[1];
					double balance = Double.parseDouble(infos[5].split(":")[1]);
					double ceiling = Double.parseDouble(infos[6].split(":")[1]);
					double loan = Double.parseDouble(infos[7].split(":")[1]);
					account = new LoanCreditAccount(id,password,name,personId,email,balance,ceiling,loan);
				}
				if(temp.startsWith("LoanSavingAccount")){
					//���������˻�
					String infoStr = temp.split("\\|\\|")[1];
					System.out.println(infoStr);
					String[] infos = infoStr.split(",");
					long id = Long.parseLong(infos[0].split(":")[1]);
					String name = infos[1].split(":")[1];
					String password = infos[2].split(":")[1];
					String personId = infos[3].split(":")[1];
					String email = infos[4].split(":")[1];
					double balance = Double.parseDouble(infos[5].split(":")[1]);
					double loan = Double.parseDouble(infos[6].split(":")[1]);
					account = new LoanSavingAccount(id,password,name,personId,email,balance,loan);
				}
				if(temp.startsWith("CreditAccount")){
					//�����˻�
					String infoStr = temp.split("\\|\\|")[1];
					System.out.println(infoStr);
					String[] infos = infoStr.split(",");
					long id = Long.parseLong(infos[0].split(":")[1]);
					String name = infos[1].split(":")[1];
					String password = infos[2].split(":")[1];
					String personId = infos[3].split(":")[1];
					String email = infos[4].split(":")[1];
					double balance = Double.parseDouble(infos[5].split(":")[1]);
					double ceiling = Double.parseDouble(infos[6].split(":")[1]);
					account = new CreditAccount(id,password,name,personId,email,balance,ceiling);
				}
				if(temp.startsWith("SavingAccount")){
					//�����˻�
					String infoStr = temp.split("\\|\\|")[1];
					System.out.println(infoStr);
					String[] infos = infoStr.split(",");
					long id = Long.parseLong(infos[0].split(":")[1]);
					String name = infos[1].split(":")[1];
					String password = infos[2].split(":")[1];
					String personId = infos[3].split(":")[1];
					String email = infos[4].split(":")[1];
					double balance = Double.parseDouble(infos[5].split(":")[1]);
					account = new SavingAccount(id,password,name,personId,email,balance);
				}
				//��ӵ�bank���б����
				Constant.ACCOUNTLIST.add(account);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����¼д���ļ�
	 * @param account
	 */
	public static void writeAccountToFile(Account account , boolean isAppend){
		String temp = "";
		File file = new File("src/com/accounts.txt");
		FileWriter fw = null;
        BufferedWriter bw = null;
        try {
			fw = new FileWriter(file,isAppend);
			bw = new BufferedWriter(fw);
			
			if(LoanCreditAccount.class.isInstance(account)){
				temp = "LoanCreditAccount||"+
			"id:"+account.getId()+
			",name:"+account.getName()+
			",password:"+account.getPassword()+
			",personid:"+account.getPersonId()+
			",email:"+account.getEmail()+
			",balance:"+account.getBalance()+
			",ceiling:"+((LoanCreditAccount)account).getCeiling()+
			",loan:"+((LoanCreditAccount)account).getLoan();
				//д���ļ�
				bw.write(temp+"\n");
				
			}
			if(LoanSavingAccount.class.isInstance(account)){
				temp = "LoanSavingAccount||"+
						"id:"+account.getId()+
						",name:"+account.getName()+
						",password:"+account.getPassword()+
						",personid:"+account.getPersonId()+
						",email:"+account.getEmail()+
						",balance:"+account.getBalance()+
						",loan:"+((LoanSavingAccount)account).getLoan();
				//д���ļ�
				bw.write(temp+"\n");
			}
			if((!LoanCreditAccount.class.isInstance(account)) && CreditAccount.class.isInstance(account)){
				temp = "CreditAccount||"+
						"id:"+account.getId()+
						",name:"+account.getName()+
						",password:"+account.getPassword()+
						",personid:"+account.getPersonId()+
						",email:"+account.getEmail()+
						",balance:"+account.getBalance()+
						",ceiling:"+((CreditAccount)account).getCeiling();
				//д���ļ�
				bw.write(temp+"\n");
			}
			if((!LoanSavingAccount.class.isInstance(account)) && SavingAccount.class.isInstance(account)){
				temp = "SavingAccount||"+
						"id:"+account.getId()+
						",name:"+account.getName()+
						",password:"+account.getPassword()+
						",personid:"+account.getPersonId()+
						",email:"+account.getEmail()+
						",balance:"+account.getBalance();
				//д���ļ�
				bw.write(temp+"\n");
			}
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	/**
	 * �޸ļ�¼������ļ�
	 */
	public static void updateAccount(){
		File file = new File("src/com/accounts.txt");
		try {
			FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Account account : Constant.ACCOUNTLIST){
			writeAccountToFile(account,true);
		}
	}
}
