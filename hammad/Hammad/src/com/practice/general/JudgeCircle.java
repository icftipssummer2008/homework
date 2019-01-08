package com.practice.general;

public class JudgeCircle {
	public static void main(String[] args) {
		String moves = "LURDL";
		
		System.out.println(judgeCircle(moves));
		
	}

	private static boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		// x,y = 0,0
		char[] movesArray = moves.toCharArray();
		for (char c : movesArray) {
			if(c == 'L') {
				x -= 1;
			}
			else if(c == 'R') {
				x += 1;
			}
			else if(c == 'U') {
				y -= 1;
			}
			else if(c == 'D') {
				y += 1;
			}
		}
		if(x == 0 && y == 0) {
			return true;
		}
		return false;

	}
}
