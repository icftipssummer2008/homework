package com.amair.recursion;

import java.util.ArrayList;

public class palindromicDecomp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindromicDecomp p = new palindromicDecomp();
		
		
		ArrayList<ArrayList<String>> result = p.allPalin("abracadabra");
		for(ArrayList<String> res : result) {
			System.out.println(res);
		}
		//p.allPalin("palindrome");
		//p.allPalin("");
	}
	
	 ArrayList<ArrayList<String>> allPalin(String str) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> partitions = new ArrayList<String>();
		
		addPalindrome(str,0,partitions,result);
		return result;
	}
	
	 void addPalindrome(String s, int start, ArrayList<String> partitions , ArrayList<ArrayList<String>> result) {
		if(start>=s.length()) {
			ArrayList<String> temp = new ArrayList<String> (partitions);
			result.add(temp);
			return;
		}
		for(int i=start+1;i<=s.length();i++) {
			String str = s.substring(start,i);
			if(checkPalin(str)) {
				partitions.add(str);
				addPalindrome(s,i,partitions,result);
				partitions.remove(partitions.size()-1);
			}
		}
	}
		
	 boolean checkPalin(String str) {
		if(str.length()==1)  return true;//System.out.println(str);
		else {
			int start =0;
			int end = str.length()-1;
			while(start<=end) {
				if(str.charAt(start)== str.charAt(end)) {
					start++;
					end--;
				}
				else return false;
			}
			return true;
		}
	}

}
