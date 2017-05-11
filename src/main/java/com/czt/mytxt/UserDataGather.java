package com.czt.mytxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class UserDataGather {
	public static void main(String args[]){
		
		String b=null;		
		BufferedReader br =null;
		
		try {
			File file=new File("D://duqu//chu.txt");
			InputStreamReader in;
			try {
				in = new InputStreamReader(new FileInputStream(file), "gb2312");
				br=new BufferedReader(in);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("not found the file!!!");
			System.exit(-1);
			e.printStackTrace();
		}
		
		try {
			while((b=br.readLine())!=null){
				String[] a=b.split("\n");
				System.out.print(a[1]);
			}
		} catch (IOException e) {                 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
