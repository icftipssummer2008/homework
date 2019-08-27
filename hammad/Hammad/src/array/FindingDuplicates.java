package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author hmuha03
 * 
 * 
 	Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

	Find all the elements that appear twice in this array.
	
	Could you do it without extra space and in O(n) runtime?
	
	Example:
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[2,3]
 *
 */
public class FindingDuplicates {
	public static void main(String[] args) {
		int[] test = {4,3,2,7,8,2,3,1};
		List<Integer> duplicates = findDuplicates(test);
		
		for (Integer integer : duplicates) {
			System.out.println(integer);
		}
		
	}
	
	public static List<Integer> getDuplicates(int[] arr) {
		
		List<Integer> dupes = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			int value = arr[i];
			if(value < 0) {
				dupes.add(value);
			}
			else {
				arr[i] = -value;
			}
		}
		
		return dupes;
		
	}
	
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            
            nums[index] = -nums[index];
        }
        return res;
    }
}
