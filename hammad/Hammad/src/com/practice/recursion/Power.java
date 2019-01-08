package com.practice.recursion;

public class Power {
	
	public static int pow(int base, int power) {
		if(power == 1) {
			return base;
		}
		else if(power == 0) {
			return 1;
		}
		return base * pow(base, power - 1);
	}
	
	public static void main(String[] args) {
		int pow = pow(2, 0);
		System.out.println(pow);
	}
}
