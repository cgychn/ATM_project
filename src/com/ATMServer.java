package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import util.Util;

import com.ATMServerThread;
public class ATMServer {
	public static void main(String[] args) {
		ServerSocket ss = null ;
		Socket socket = null ;
		Util.ReadFileAccount();
		try {
			ss = new ServerSocket(9001) ;
			System.out.println("����������");
			while(true){
				socket = ss.accept() ;
				System.out.println(socket.getInetAddress()+" �ѽ����������");
				new ATMServerThread(socket).start() ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
				try {
					if(socket != null){
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
