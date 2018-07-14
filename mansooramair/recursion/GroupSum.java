
/*Given an array of int, is it possible to choose a group of some of the ints, such that the group sums to the given target*/
package com.amair.recursion;

public class GroupSum {
	 boolean groupSum(int[] array,int target) {
		return helperSum(array,target,0);
	}
	
	 boolean helperSum(int[] array , int target , int index) {
		if(index>=array.length) {
			if(target==0) return true;
			else return false;
		}
		return helperSum(array , target-array[index],index+1) || helperSum(array,target,index+1);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupSum p = new GroupSum();
		int[] array1 = {1,2,3,4};
		int[] array2 = {};
		int[] array3 = {1,2,3,4};
		
		boolean res1 = p.groupSum(array1 , 5);
		boolean res2 = p.groupSum(array2 , 9);
		boolean res3 = p.groupSum(array3 , 7);
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
	

}
