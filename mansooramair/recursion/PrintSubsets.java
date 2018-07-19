/*Print out all the subsets of a set*/

package com.amair.recursion;

public class PrintSubsets {
	 void printAllSubset(char[] set) {
		boolean b[] = new boolean[set.length];
		helpPrintSet(set,b,0,set.length);
	}
	
	 void helpPrintSet(char[] set,boolean[] b,int low, int high) {
		if(low>=high) {
			printSet(set,b);
			return;
		}
			b[low]=true;
			helpPrintSet(set,b,low+1,high);
			b[low]=false;
			helpPrintSet(set,b,low+1,high);
			return;
	}
	
	 void printSet(char[] set , boolean[] b) {
		System.out.print("{");
		for(int i=0 ; i<b.length;i++) {
			if(b[i]) {
				System.out.print(set[i]);
			}
		}
		System.out.print("}");
		System.out.println();
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintSubsets p = new PrintSubsets();
		char[] ch1 = {};
		char[] ch2 = {'a'};
		char[] ch3 = {'x','y','z'};
		System.out.println("First Test Case: ");
		p.printAllSubset(ch1);
		
		System.out.println("Second Test Case: ");
		p.printAllSubset(ch2);
		System.out.println("Third Test Case: ");
		p.printAllSubset(ch3);
	}

}
