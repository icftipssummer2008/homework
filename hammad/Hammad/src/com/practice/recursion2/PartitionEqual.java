package com.practice.recursion2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PartitionEqual {
	/*
	 * 
	Partition Equal Subset Sum

	Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

	Example 1: Input: [1, 5, 11, 5]

	Output: true

	Explanation: The array can be partitioned as [1, 5, 5] and [11].

	 

	Example 2:

	Input: [1, 2, 3, 5]

	Output: false

	Explanation: The array cannot be partitioned into equal sum subsets.
	 * 
	*/
	
	public static void main(String[] args) {
		
		int[] array1 = {1, 5, 11, 5};
		//System.out.println(printPartitions(array1));
		
		
		int[] array2 = {1, 2, 3, 5};
		System.out.println(printPartitions(array2));
		
	}
	
	private static boolean  printPartitions(int[] set) {
		Queue<Integer> q1 = new LinkedList<>();
		for (int integer : set) {
			q1.offer(integer);
		}
		Queue<Integer> q2 = new LinkedList<>();
		
		return printPartitions(q1, q2);

	}
	
	private static boolean printPartitions(Queue<Integer> q1,  Queue<Integer> q2) {
		System.out.format(q1.toString() + "\n" +  q2.toString() + "\n\n");
		if(sumEqual(q1, q2)) {
			return true;
		}
		if(q1.isEmpty()) {
			return false;
		}
		
		Integer integer = q1.poll();
		q2.offer(integer);
		if(printPartitions(q1, q2)) {
			return true;
		}
		
		integer = q2.poll();
		q1.offer(integer);
		if(printPartitions(q1, q2)) {
			return true;
		}
		return false;
		
	}
	
	private static boolean sumEqual(Queue<Integer> q1,  Queue<Integer> q2) {
		int sum1 = 0, sum2 = 0;
		
		for (Integer integer : q1) {
			sum1 += integer;
		}

		for (Integer integer : q2) {
			sum2 += integer;
		}
		
		if(sum1 == sum2) {
			return true;
		}
		
		return false;
		
	}

}
