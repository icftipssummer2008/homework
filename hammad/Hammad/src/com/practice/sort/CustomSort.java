package com.practice.sort;

public class CustomSort {
	
	public static void main(String[] args) {
		System.out.println(customSortStringUnoptimized("cba","kabbcd"));
	}

    public static String customSortStringUnoptimized(String s, String t) {
    		
    		char[] sArray = s.toCharArray();
    		char[] tArray = t.toCharArray();
    		StringBuilder sb = new StringBuilder();
    		
    		for (int i = 0; i < sArray.length; i++) {
			for (int j = 0; j < tArray.length; j++) {
				if(sArray[i] == tArray[j]) {
					sb.append(sArray[i]);
				}
			}
		}
    		
    		for (int i = 0; i < tArray.length; i++) {
        		boolean isMatched = false;

			for (int j = 0; j < sArray.length; j++) {
				if(tArray[i] == sArray[j]) {
					isMatched = true;
					break;
				}
			}
			
			if (!isMatched) {
				sb.append(tArray[i]);
			}
		}
    		
    		return sb.toString();
    	
    }
    

}
