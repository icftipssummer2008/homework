package com.practice.recursion2;

public class GroupSum {
	public static boolean groupSum(int start, int[] nums, int target) {

		if(start >= nums.length) {
			return target == 0;
		}
		
		if(groupSum(start + 1, nums, target - nums[start])) {
			return true;
		}

		if(groupSum(start + 1, nums, target)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] abc = {1,2,3,4};
		System.out.println(groupSum(0, abc, 6)); 
	}
}

