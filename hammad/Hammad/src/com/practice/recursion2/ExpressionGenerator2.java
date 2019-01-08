package com.practice.recursion2;

import java.util.HashSet;

public class ExpressionGenerator2 {
	
	static String[] operators = {"", "+", "*"};
	
	public static void main(String[] args) {
		generateExpression("222");
	}
	
	public static void generateExpression(String str) {
		HashSet<String> hashset = new HashSet<>();
		generateExpressionHelper(str, 0, "",  hashset);
		printSet(hashset);
	}
	
	public static void printSet(HashSet<String> hashset) {
		for (String str : hashset) {
			System.out.println(str);
		}
		
	}
	
	public static void generateExpressionHelper(String input, int i, String output, HashSet<String> hashset) {
		int inputLength = input.length();
		if(i==inputLength) {
			hashset.add(output);
			return;
		}
		
		for (String operator : operators) {
			String temp = output + input.charAt(i);
			if( i < inputLength -1) {
				temp = temp + operator;
			}
			generateExpressionHelper(input, i+1, temp, hashset);

		}		
	}
}
