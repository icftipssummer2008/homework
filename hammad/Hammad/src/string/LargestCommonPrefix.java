package string;

/** 
 * 		https://leetcode.com/problems/longest-common-prefix/description/
 */

public class LargestCommonPrefix {
	public static void main(String[] args) {
		String[] strs =  {"flower","flow","flight"};
		
		System.out.println(getLargestCommonPrefix(strs));
		System.out.println(getLargestCommonPrefix2(strs));
	}
	
	public static String getLargestCommonPrefix(String[] strs) {
		StringBuilder output = new StringBuilder();
		boolean cond = true;
		int index = 0;
		int matchCount = 0;
		
		while(cond) {
			Character c = null;
			matchCount = 0;
			for (String s : strs) {
				if(c == null && index < s.length()) {
					c = s.charAt(index);
				}
				
				if(c != null && index < s.length()) {
					if(!c.equals(s.charAt(index))) {
						break;
					}
					else {
						matchCount ++;
					}
				}
				
				if(index >= s.length()) {
					cond = false;
				}
			}
			
			if(strs.length == matchCount) {
				output.append(c);
			}
			else {
				if(index == 0) {
					break;
				}
			}
			
			index++;
		}
		
		return output.toString();
		
	}
	
	public static String getLargestCommonPrefix2(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		
		String prefix = strs[0];
		
		for (int i = 1; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) {
					return "";
				}

			}
		}
			
		return prefix;
	}
		
		
}
