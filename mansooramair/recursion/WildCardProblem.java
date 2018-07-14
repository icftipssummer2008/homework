/* Input: 10?
Output: 101, 100
i.e. ? behaves like a wild-card. There are two possibilities for 10?, when that ? is replaced with
either 0 or 1.
Input: 1?0?
Output: 1000, 1001, 1100, 1101 */

package com.amair.recursion;

public class WildCardProblem {
	
	 void getPossibleSets(String str) {
		char ch[] = str.toCharArray();
		helperSet(ch,0);
	}
	
	 void helperSet(char[] str, int index) {
		if(index >= str.length) {
			for(int i=0; i<str.length;i++) {
				System.out.print(str[i]);
			}
			System.out.println();
			return;
		}
		else {
			if(str[index] == '?') {
			for(char ch ='0';ch<='1';ch++) {
				str[index] = ch;
				helperSet(str,index+1);
				str[index]='?';
			}
		}
			else {
				helperSet(str,index+1);
			}
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildCardProblem p = new WildCardProblem();
		p.getPossibleSets("1?1?");
		p.getPossibleSets("");
		p.getPossibleSets("10");
	}

}
