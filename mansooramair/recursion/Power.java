/*Implement a power function to raise a double to an int power, including negative powers.*/

/* Time Complexity is O(n) and Space Complexity O(1) */
package com.amair.recursion;

public class Power {
	 double getPow(double d, int p){
		if(p==0) {
			return 1;
		}
		if(p<0) return 1/d*getPow(d,p+1);
		return d*getPow(d,p-1);
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Power p = new Power();
	double res1 = p.getPow(3.0, 2);
	double res2 = p.getPow(3.0, -2);
	double res3 = p.getPow(3.0, 0);
	double res4 = p.getPow(3.0, 1);
	System.out.println("The value of 3 raised to power 2 : " +res1);
	System.out.println("The value of 3 raised to power -2 : " +res2);
	System.out.println("The value of 3 raised to power 0 : " +res3);
	System.out.println("The value of 3 raised to power 1 : " +res4);
	}

}
