package com.practice.recursion2;

public class ExpressionGenerator {
	
	static String[] operators = {"", "+", "*"};
	
	public static void main(String[] args) {
		generateExpression("22");
	}
	
	public static void generateExpression(String str) {
		generateExpressionHelper(str, 0, new StringBuilder());
	}
	
	public static void generateExpressionHelper(String input, int i, StringBuilder output) {
		System.out.format("input=%s, i=%d, output=%s\n", input, i, output);
		int inputLength = input.length();
		if(i==inputLength) {
			System.out.println(output);
			//output.setLength(0);
			return;
		}
		
		for (String operator : operators) {
			output.append(input.charAt(i));
			if(i < input.length() -1) {
				output.append(operator);
			}
			generateExpressionHelper(input, i+1, output);
			output.deleteCharAt(output.length() - 1);
			if(!operator.isEmpty() && i < inputLength -1) {
				output.deleteCharAt(output.length() - 1);
			}
		}
		
	}
}
