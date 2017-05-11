package com.czt.mytxt;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个固定值和个数，所有个数的平均值等于这个固定值
 * @author Administrator
 *
 */
public class Average {
	public static void main(String args[]){
		int num=9;
		int an=3;
//		System.out.println((float)num/2+"===="+(int)num/2);
//		if((float)num/2==(int)num/2){
//			System.out.println("nice");
//		}
		average(num,an);
	}

	private static List<Integer> average(int num, int an) {
		// TODO Auto-generated method stub
		int sum=num*an;
		List<Integer> list=new ArrayList<Integer>();
		if((float)num/2==(int)num/2){
		for(int i=0;i<num/2;i++){
			int a=(int)(Math.random()*5)+1;
			int b=an*2-a;
			list.add(a);
			list.add(b);
		}
		}else if((float)num/2!=(int)num/2){
			list.add(3);
			for(int i=0;i<num/2;i++){
				int a=(int)(Math.random()*5)+1;
				int b=an*2-a;
				list.add(a);
				list.add(b);
			}
		}
		for(int j=0;j<list.size();j++){
			System.out.println(list.get(j));
		}
		List<Integer> list1=new ArrayList<Integer>();
		for(int z=1;z<=5;z++){
			int c=0;
			for(int j=0;j<list.size();j++){
				
				if(list.get(j)==z){
					c++; 
				}
			}
			list1.add(c);
		}
		for(int j=0;j<list1.size();j++){
			System.out.println("count:"+list1.get(j));
		}
		return list1;
	}

}
