package com.practice.bitwise;

public class HammingDistance {

	public static void main(String[] args) {
		int a = 0b0011010;
		int b = 0b1001110;
		
		int c = a ^ b;
		
		int distance  = 0;
		for(int i = 0; i < 32; i++) {
			
			if ( (c&1) == 1) {
				distance++;
			}
			c = c >>> 1;
		}
		
		System.out.println("Hamming Distance: " + distance);
	}
	
}
