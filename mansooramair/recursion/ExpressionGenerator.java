package com.amair.recursion;

public class ExpressionGenerator {
	 void genExp(String str, String[] ch) {
		helpGenExp(str, ch,0);
	}
	
	 void helpGenExp(String str, String[] ch , int index) {
		if(index>=str.length()-1) {
			System.out.println(str);
			return;
		}
		for(String i : ch) {
			helpGenExp(str.substring(0, index+1)+i+str.substring(index+1),ch,index+2);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionGenerator p = new ExpressionGenerator();
		String[] str1 = {"*","+",""};
		String[] str2 = {};
		p.genExp("222" , str1);
		p.genExp("" , str1);
		p.genExp("123",str2);
	}

}
