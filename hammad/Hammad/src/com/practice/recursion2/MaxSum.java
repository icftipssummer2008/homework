package com.practice.recursion2;

public class MaxSum {
	
	
	public static void main(String[] args) {
		
		//     1   2   3   3
		//	   5   3   1   2	
		//	   2   1   3   9	
		//	   4   3   6   1	
		//
		
		int[][] input = {
							{1,2,3,4},
							{4,5,6,9},
							{1,2,1,4},
							{4,5,10,7}
						}; 
		
		System.out.println("=====================");
		System.out.println(maxSum(input));

	}
	
	public static int maxSum(int[][] input) {
		int helper = helper(0, 0, input);
		return helper;
	}
	
	public static int helper(int left, int down, int[][] input) {
		System.out.println(left + " " + down);
		int maxLeft = input[0].length;
		int maxDown = input.length;
		
		if(left == maxLeft -1 && down == maxDown -1) {
			return input[down][left];
		}
		
		if(left == maxLeft -1 ) {
			return helper(left , down + 1, input) + input[down][left];
		}

		 if(down == maxDown -1) {
			 return helper(left + 1, down, input) + input[down][left];
		}
		
		 int i = helper(left, down + 1, input) + input[down][left];
		 int j = helper(left + 1, down, input) + input[down][left];

		return Math.max(i,j) ;
		
	}
}
