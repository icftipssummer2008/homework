package array;

/**
 * 
 * @author hmuha03
 * 
Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:

I/P : 3 3 4 2 4 4 2 4 4
O/P : 4 

I/P : 3 3 4 2 4 4 2 4
O/P : NONE

https://www.geeksforgeeks.org/majority-element/

 */
public class MajorityElement {
	public static void main(String[] args) {
		int arr[] = {1, 1, 2, 1, 3, 5, 1}; 
		
		System.out.println(getMajorityElement(arr));
		
		
		int majority = getMooresMajority(arr);
		
		boolean isMajority = verifyMajority(majority, arr);
		
		if(isMajority) {
			System.out.println(majority);
		}
	}
	
	private static int getMajorityElement(int arr[]) {
		int n = arr.length;
		
		int index = -1;
		int maxCount = 0;
		
		for(int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			
			if(count > maxCount) {
				maxCount = count;
				index = i;
			}
		}
		
		if(maxCount > n/2) {
			return arr[index];
		}
		
		return -1;
	}
	
	private static int getMooresMajority(int arr[]) {
		int majorityIndex = 0;
		int count = 1;
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			if(arr[majorityIndex] == arr[i]) {
				count ++;
			}
			else {
				count --;
			}
			if(count == 0) {
				majorityIndex = i;
			}
		}
		
		return arr[majorityIndex];
	}
	
	private static boolean verifyMajority(int majorityElement, int arr[]) {
		int count = 0;
		int n = arr.length;
		for (int i = 0 ; i < n; i++) {
			if(arr[i] == majorityElement) {
				count++;
			}
		}
		
		if(count > n/2) {
			return true;
		}
		return false;
	}
}