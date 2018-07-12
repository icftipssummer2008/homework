package com.sohel.recursion;

public class GroupSum {

	public static boolean groupSum(int start, int[] nums, int target) {
	    if(start >= nums.length)
	        return target == 0;
	          
	    if(groupSum(start+1, nums, target - nums[start]))
	        return true;
	                    
	    if(groupSum(start+1, nums, target))
	        return true;
	                              
	    return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,4,8};
		System.out.println(groupSum(0,nums, 10));
		System.out.println(groupSum(0,nums, 14));
		System.out.println(groupSum(0,nums, 9));


	}
}
