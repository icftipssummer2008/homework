package com.sohel.recursion;

import java.util.*;

public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vector<Integer> V = new Vector<>();
		int dice = 6;
		diceRolls(dice);
	}

	public static void diceRolls(int dice) {
		
		Vector<Integer> chosen = new Vector<>();
		diceHelper(dice,chosen);
	}
	
	public static void diceHelper(int dice, Vector<Integer> chosen) {
		
		if(dice == 0) {
			System.out.println(chosen);//base case nothing to choose
			return;
		}
		else {
			for(int i=0; i<=6; i++) {
			//Choose
			chosen.add(i);
			diceHelper(dice-1, chosen); //Explore
			
			chosen.remove(chosen.size()-1); //un-choose

		}
		
	
		}
	}
}
