package com.sohel.recursion;

import java.util.*;

public class PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Character> array = new Vector<>();
		array.add('x');
		array.add('y');
		powerSetfunc(array);
	}

	public static void powerSetfunc(Vector<Character> array) {
		
		Vector<Character> chosen = new Vector<>();
		powerSetHelper(array,chosen);
	}
	
	public static void powerSetHelper(Vector<Character> array, Vector<Character> chosen) {
		
		if(array.isEmpty()) {
			System.out.println(chosen); //base case nothing to choose
		}
		else {
			char first = array.get(0); 
			array.remove(0);			
			//Choose
			chosen.add(first);
			powerSetHelper(array, chosen); //Explore
			
			chosen.remove(chosen.size()-1); //Unchoose
			powerSetHelper(array, chosen);	// Explore		

			array.add(0, first);			
		}
		
	}	
	
	
}


