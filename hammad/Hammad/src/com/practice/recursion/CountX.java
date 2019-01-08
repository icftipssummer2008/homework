package com.practice.recursion;

public class CountX {
	public int countX(String str, char c) {
	  
		if(str.length() == 1) {
			if(str.charAt(0) == c) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (str.length() > 1) {
			if(str.charAt(0) == c) {
				return 1 + countX(str.substring(1), c);
			}
			else {
				return countX(str.substring(1), c);
			}
		}
		else {
			return 0;
		}
		
	}
	public static void main(String[] args) {
		
		
	}
}

