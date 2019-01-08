package com.practice.recursion2;

public class PrintSubsets {
	
	public static void printSubsets(char[] array) {
		char[] writeArray = new char[array.length];
		printSubsets(0, array, 0, writeArray);
	}

	public static void printSubsets(int read, char[] readArray, int write, char[] writeArray) {
		//System.out.format(" printSubsets(%d, %s, %d, %s)\n" , read, Arrays.toString(readArray), write, Arrays.toString(writeArray));
		if(read == readArray.length) {
			printArray(writeArray, write);
			return;
		}
		printSubsets(read + 1, readArray, write, writeArray);
		writeArray[write] = readArray[read];
		printSubsets(read + 1, readArray, write +1, writeArray);
		
	}
	
	public static void printArray(char[] writeArray, int write) {
	
		System.out.print("{");
		
		for(int i = 0 ; i < write ; i ++) {
			System.out.print(writeArray[i]);			
			
		}
		
		System.out.print("}");

		System.out.println();
	}
	
	public static void main(String[] args) {
		char[] readArray = {'a','b', 'c'};
		printSubsets(readArray);
	}
}
