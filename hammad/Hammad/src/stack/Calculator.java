package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
	public static void main(String[] args) {
		String str = "1+4+6*5";
		
		System.out.format("Sum is %d", evalute(str));
		
		print(str);

	}
	
	public static void print(String str) {
		Deque<String> stack = new ArrayDeque<String>();

		int num = 0; String operator = "";
		int strLength = str.length();
		for (int index = 0; index < strLength; index++) {
			char c = str.charAt(index);
			
			if(Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			}
			
			if(!Character.isDigit(c)  || index == str.length() - 1) {
				stack.push(String.valueOf(num));
				num = 0;
				if(!operator.isEmpty()) {
					stack.push(operator);
					operator = "";
				}
				else {
					operator = String.valueOf(c);
				}
			}
		}
		
		System.out.println(stack);
	}
	
	public static int evalute(String str) {
		Deque<Integer> stack = new ArrayDeque<Integer>();

		int num = 0; char operator = '+';
		int strLength = str.length();
		for (int index = 0; index < strLength; index++) {
			char c = str.charAt(index);
			
			if(Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			}
			
			if(!Character.isDigit(c) || index == str.length() - 1) {
				if(operator == '+') {
					stack.push(num);
				}
				else if(operator == '-') {
					stack.push(-num);
				}
				else if(operator == '*') {
					stack.push(stack.pop() * num);
				}
				if(operator == '/') {
					stack.push(stack.pop() / num);
				}
				
				operator = c;
				num = 0;
			}
	
			

		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		
		return sum;
	}
	
	
	public static int calculate(String s) {
	    int len;
	    if(s==null || (len = s.length())==0) return 0;
	    Deque<Integer> stack = new ArrayDeque<Integer>();
	    int num = 0;
	    char sign = '+';
	    for(int i=0;i<len;i++){
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int re = 0;
	    for(int i:stack){
	        re += i;
	    }
	    return re;
	}
}
