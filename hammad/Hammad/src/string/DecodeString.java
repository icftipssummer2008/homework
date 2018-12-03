package string;

import java.util.Stack;

public class DecodeString {

	
	/*
	 * 
	 * 		s = "3[a]2[bc]", return "aaabcbc".
	 *		s = "3[a2[c]]", return "accaccacc".
	 *		s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	 * 
	 * 
	 */
	public static void main(String[] args) {
		String[] strArray = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef"};
		for (String str : strArray) {
			System.out.format("%s = %s\n", str, decodeString(str));
		}
          
	}
	
	public static String decodeString(String str) {
		if (str == null || str.trim().isEmpty()) {
			return str;
		}
		
		Stack<Integer> integerStack = new Stack<>();
		Stack<Character> charStack = new Stack<>();
		
		String temp = "";
		String result = "";
		
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			if (Character.isDigit(str.charAt(i))) {
				while (Character.isDigit(str.charAt(i))) {
					count = count * 10 + str.charAt(i) - '0';
					i++;
				}
				integerStack.push(count);
				i--;
			}
			else if(str.charAt(i) == '[') {
				
				charStack.push(str.charAt(i));

				if(!Character.isDigit(str.charAt(i - 1)) ) {
					integerStack.push(1);
				}
			}
			else if(str.charAt(i) == ']') {
				count = 0;
				temp = "";
				
				if(!integerStack.isEmpty()) {
					count = integerStack.pop();
				}
				
				while (!charStack.isEmpty() && charStack.peek() != '[') {
					temp = charStack.pop() + temp;
				}
				
				if (!charStack.isEmpty() && charStack.peek() == '[') {
					charStack.pop();
				}
				
				for (int j = 0; j < count; j++) {
					result = result + temp;
				}
				
				for(int j = 0; j < result.length(); j++) {
					charStack.push(result.charAt(j));
				}
				
				result = "";
			}
			else {
				charStack.push(str.charAt(i));
			}
		}
		
		while(!charStack.isEmpty()) {
			result = charStack.pop() + result;
		}
		
		return result;
		
	}
}
