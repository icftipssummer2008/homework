package com.sohel.recursion;

public class PowerBase {
	
	public static void main(String[] args) {
		int result = ipow(3,5);
		System.out.print(result);
		
	}
	
	public static int ipow(int base, int exp)
	{
	    if(exp == 0) return 1;
	    else 
	    {
	        if ((exp & 1) == 1)
	           return base*ipow(base, exp-1);
	        return ipow(base *= base, exp >>= 1);
	    }
	}

}
