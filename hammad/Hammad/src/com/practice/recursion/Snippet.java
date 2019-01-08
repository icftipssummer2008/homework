package com.practice.recursion;

public class Snippet {
	public static String changePi(String str) {
		if (str.length() >= 2) {
			if(str.charAt(0) == 'p' && str.charAt(1) == 'i') {
				return "3.14" + changePi(str.substring(2));
			}
			return Character.toString(str.charAt(0))   + changePi(str.substring(1));
		}
		
		return str;
	}
	
	public static String noX(String str) {
		  if(str.length() >= 1) {
			 if( str.charAt(0) == 'x') {
				 return noX(str.substring(1));
			 }
			 else {
				 return Character.toString(str.charAt(0))   + noX(str.substring(1));
			 }
		  }
		  return "";
	}

	public boolean array6(int[] nums, int index) {
		if (nums.length >= 1 &&  nums.length > index) {
			if(nums[index] == 6) {
				return true;
			}
			return array6(nums, index + 1);
		}
		else {
			return false;
		}
	}
	
	public int array11(int[] nums, int index) {
		if (nums.length >= 1 &&  nums.length > index) {
			if(nums[index] == 11) {
				return 1 + array11(nums, index + 1);
			}
			return array11(nums, index + 1);
		}
		else {
			return 0;
		}
	}
	
	public boolean array220(int[] nums, int index) {
		if (nums.length >= 1 &&  nums.length > index + 1) {
			if(nums[index+1] == 10 * nums[index]) {
				return true;
			}
			return array220(nums, index + 1);
		}
		else {
			return false;
		}
	}

	public String allStar(String str) {
		if (str.length() >= 2  ) {
			return Character.toString(str.charAt(0)) + "*" + allStar(str.substring(1));
		}
		else {
			return str;
		}
	}

	public String pairStar(String str) {
		if (str.length() >= 2  ) {
			if(str.charAt(0) == str.charAt(1)) {
				return Character.toString(str.charAt(0)) + "*" + pairStar(str.substring(1));				
			}
			return Character.toString(str.charAt(0)) + pairStar(str.substring(1));
		}
		else {
			return str;
		}
	}

	public String endX(String str) {
		if (str.length() >= 2) {
			if(str.charAt(0) == 'x') {
				return endX(str.substring(1)) + 'x';
			}
			else {
				return Character.toString(str.charAt(0)) +  endX(str.substring(1));				
			}
		}
		else {
			return str;			
		}
	}

	public int countPairs(String str) {
		if (str.length() >= 3) {
			if (str.charAt(0) == str.charAt(2)) {
				return 1 + countPairs(str.substring(1));
			}
			return countPairs(str.substring(1));

		}
		return 0;
	}
	
	// count abc and aba
	public int countAbc(String str) {
		if (str.length() >= 3) {
			if(str.charAt(0) == 'a' && str.charAt(1) == 'b' && (str.charAt(2) == 'c' || str.charAt(2) == 'a')) {
				return 1 + countAbc(str.substring(1));
			}
			return countAbc(str.substring(1));
		}
		return 0;
	}

	public int count11(String str) {
		if (str.length() >= 2) {
			if(str.charAt(0) == '1' && str.charAt(1) == '1') {
				return 1 + count11(str.substring(2));
			}
			return count11(str.substring(1));
		}
		return 0;
	}

	public static String stringClean(String str) {
		if(str.length() > 1) {
			if(str.charAt(0) == str.charAt(1)) {
				return stringClean(str.substring(1));
			}
			return str.charAt(0) + stringClean(str.substring(1));
		}
		return str;
	}

	public static int countHi2(String str) {
		int length = str.length();
		if (str == null || length < 2 ) {
			return 0;
		}
		
		if (length >= 2) {
			
			if (str.charAt(length-2) == 'h' && str.charAt(length-1) == 'i') {
				if( (length > 2 &&  str.charAt(length-3) != 'x') || length == 2) {
					return 1 + countHi2(str.substring(0, length - 2));					
				}
			}
		}



		return countHi2(str.substring(0, length - 1));
	}
	
	public static String parenBit(String str) {
		int length = str.length();
		if (str == null || length < 2 ) {
			return "";
		}
		if(str.charAt(0) == '(' && str.charAt(length - 1) == ')') {
			return str;
		}
		
		int lastIndex = length;
		int firstIndex = 0;
		if(length >= 2) {
			if(str.charAt(length - 1) != ')') {
				lastIndex = length - 1;
			}
			if(str.charAt(0) != '(') {
				firstIndex++;
			}
			
			if( lastIndex <= length  && firstIndex < length) {
				return parenBit(str.substring(firstIndex, lastIndex));							
			}
		}
		
		return str;

	}

	// Given a string, return true if it is a nesting of zero or more pairs of parenthesis, 
	// like "(())" or "((()))". 
	// Suggestion: check the first and last chars, and then recur on what's inside them.
	public boolean nestParen(String str) {
		int length = str.length();
		if(str == null || length == 0) {
			 return true;
		}
		
		if(length >= 2 && str.charAt(0) == '(' && str.charAt(length - 1) == ')') {
			return nestParen(str.substring(1, length - 1));
		}
		return false;
	}
	
	/**
		Given a string and a non-empty substring sub, compute recursively the number of times 
		that sub appears in the string, without the sub strings overlapping.

		strCount("catcowcat", "cat") → 2
		strCount("catcowcat", "cow") → 1
		strCount("catcowcat", "dog") → 0
	*
	*/
	public int strCount(String str, String sub) {
		int strLen = str.length();
		int subLen = sub.length();
		if(strLen < subLen) {
			return 0;
		}
		String portionOfString = str.substring(0, subLen);
		if(portionOfString.equals(sub)) {
			if(subLen <  strLen) {
				return 1 + strCount(str.substring(subLen - 1), sub);				
			}
		}
		return strCount(str.substring(1), sub);

	}

	/**
	 * 

		Given a string and a non-empty substring sub, 
		compute recursively if at least n copies of sub 
		appear in the string somewhere, possibly with overlapping. N will be non-negative.
		
		
		strCopies("catcowcat", "cat", 2) → true
		strCopies("catcowcat", "cow", 2) → false
		strCopies("catcowcat", "cow", 1) → true
	 */
	public boolean strCopies(String str, String sub, int n) {
		  if (n == 0) {
			  return true;
		  }
		  if(str.length() < sub.length()) {
			  return false;
		  }
		  if(str.substring(0, sub.length()).equals(sub)) {
			  return strCopies(str.substring(1), sub, n - 1);
		  }
		  return strCopies(str.substring(1), sub, n);
		  
	}
	
	/**
	 * 

			Given a string and a non-empty substring sub, 
			compute recursively the largest substring which 
			starts and ends with sub and return its length.
			
			
			strDist("catcowcat", "cat") → 9
			strDist("catcowcat", "cow") → 3
			strDist("cccatcowcatxx", "cat") → 9
	 */
	public int strDist(String str, String sub) {
		int subLen = sub.length();
		int strlen = str.length();
		if(strlen <= subLen * 2) {
			return 0;
		}
		if(!str.substring(0, subLen).equals(sub) ) {
			return strDist(str.substring(1), sub);
		}
		if(!str.substring(strlen - subLen - 1, strlen + 1).equals(sub)) {
			return strDist(str.substring(0,strlen -1), sub);
		}
				
		return strlen;

	}
	
	/**
		Given an array of ints, is it possible to choose a group of some of the ints, 
		such that the group sums to the given target? This is a classic backtracking 
		recursion problem. Once you understand the recursive backtracking strategy in 
		this problem, you can use the same pattern for many problems to search a space 
		of choices. Rather than looking at the whole array, our convention is to consider 
		the part of the array starting at index start and continuing to the end of the array. 
		The caller can specify the whole array simply by passing start as 0. No loops are needed -- 
		the recursive calls progress down the array.
		
		
		groupSum(0, [2, 4, 8], 10) → true
		groupSum(0, [2, 4, 8], 14) → true
		groupSum(0, [2, 4, 8], 9) → false
	 */
	public boolean groupSum(int start, int[] nums, int target) {
		  return true;
	}
	
	public static void main(String[] args) {
		String str = parenBit("x(hello)");
		System.out.println(str);
	}
	
}
