package com.sohel.recursion;

public class WildCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "1?0?";
		wildCard(s);
		
	}

	private static void wildCard(String s) {
		// TODO Auto-generated method stub
		int found = s.indexOf('?');
		if(found == -1) {
		 System.out.println(s); 
		}
		if(found != -1) {
			wildCard(s.substring(0,found)+'0'+ s.substring(found+1));
			wildCard(s.substring(0,found)+'1'+ s.substring(found+1));
		} 
	}

	
}
