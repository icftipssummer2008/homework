package array;

/**
 * 
 * @author hmuha03
 *
 *
 *	Find Minimum in Rotated Sorted Array
	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.
 */
public class RotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = {4, 5, 6, 7, 0, 1, 2};

		System.out.println(getMin(arr));
		
		int arr1[] = {0, 1, 2, 4, 5, 6, 7};

		System.out.println(getMin(arr1));

	}
	
	private static int getMin(int[] arr) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
				
		int start = arr[0];
		int end = arr.length - 1;
		
		if(arr[start] < arr[end]) {
			return arr[start];
		}
		
		while (end >= start) {
			int mid = start + (end - start) / 2;
			
			if(arr[mid] > arr[mid + 1]) {
				return arr[mid + 1];
			}
			
			if(arr[mid - 1] > arr[mid]) {
				return arr[mid];
			}
		
			if(arr[mid] > arr[0]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
			
		}
		
		return -1;
		
	}
}

