package com;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String args[]){
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("aaa", 101010.1);
		map.put("aaa", map.get("aaa")+1010222.2);
		System.out.println(map.size()+","+map.get("aaa"));
		File file = new File("src/com/accountid.txt");
		System.out.println(file.exists());
	}
}
