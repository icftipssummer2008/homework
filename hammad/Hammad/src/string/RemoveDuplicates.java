package string;

import java.util.Arrays;
import java.util.TreeSet;

public class RemoveDuplicates {
	public static void main(String[] args) {
		System.out.println(getStringBruteForce("abbbcda"));
		System.out.println(getStringTreeSet("abbbcda"));
		System.out.println(getStringSorted("abbbcda"));
	}
	
	public static String getStringBruteForce(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}
		
		StringBuilder sb = new StringBuilder(str.length());
		
		for(int i = 0; i < str.length() ; i++) {
			int j;
			
			for(j = 0; j < i; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					break;
				}
			}
			
			if(j == i) {
				sb.append(str.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	public static String getStringTreeSet(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}
		
		TreeSet<Character> treeSet = new TreeSet<>();
		
		for (int i = 0; i < str.length(); i++) {
			treeSet.add(str.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Character c :treeSet) {
			sb.append(c);
		}
		
		return sb.toString();
		
	}
	
	public static String getStringSorted(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}
		
		char[] charArray = str.toCharArray();
		
		Arrays.sort(charArray);
		
		int loopIndx = 1, strIndx = 1;
		
		int length = charArray.length;
		while(loopIndx < length) {
			System.out.format("\n loopIndx: %d, strIndx: %d, str: %s", loopIndx, strIndx, new String(charArray));
			if(charArray[loopIndx] != charArray[loopIndx - 1]) {
				charArray[strIndx] = charArray[loopIndx];
				strIndx++;
			}
			loopIndx++;
		}
		
		String result = new String(charArray, 0, strIndx);
		
		System.out.println();
		return result;
		
	}
	
	
	
}
