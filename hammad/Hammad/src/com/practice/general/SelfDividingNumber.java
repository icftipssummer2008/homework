package com.practice.general;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
	public static void main(String[] args) {
		List<Integer> list = getNum(1, 22);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	//1 <= left <= right <= 10000
	public static List<Integer> getNum(int left, int right) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			String strI = String.valueOf(i);
			char[] charArray = strI.toCharArray();
			boolean isSelfDividing = true;
			for (char c : charArray) {
				int cValue = Character.getNumericValue(c);
				if(cValue == 0 || i%cValue != 0) {
					isSelfDividing = false;
					break;
				}
			}
			if (isSelfDividing) {
				list.add(i);
			}
		}
		
		return list;
	}
}
