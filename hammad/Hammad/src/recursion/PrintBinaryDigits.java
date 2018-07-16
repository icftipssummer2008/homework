package recursion;

public class PrintBinaryDigits {

	public static void printDigitBinary(int digits, String prefix) {
		if(digits == 0) {
			System.out.println(prefix);
		}
		else {
			printDigitBinary(digits - 1, prefix + "0");
			printDigitBinary(digits - 1, prefix + "1");
		}
	}
	
	
	
	/**
	 * 	Q3: Input: 10?
			Output: 101, 100
			i.e. ? behaves like a wild-card. There are two possibilities for 10?, when that ? is replaced with
			either 0 or 1.
			Input: 1?0?
			Output: 1000, 1001, 1100, 1101
			Please write a program that takes given strings as input and produces the suggested output.
			Suggested time: 20 minutes.

	 */
	public static void printWildBinaryHelper(String str, int i) {
		if(i == str.length()) {
			System.out.println(str);
			return;
		}
		
		char c = str.charAt(i);
		if(c == '?') {
			String strWithZero = str.substring(0, i) + '0'  + str.substring(i + 1);
			String strWithOne = str.substring(0, i) + '1'  + str.substring(i + 1);
			printWildBinaryHelper(strWithZero, i + 1);
			printWildBinaryHelper(strWithOne, i + 1);
		}
		else {
			printWildBinaryHelper(str, i + 1);
		}
		
		
	}
	public static void printWildBinary(String str) {
		printWildBinaryHelper(str, 0);
	}
	
	public static void printDigitBinary(int digits) {
		printDigitBinary(digits, "");
	}
	
	public static void printDigitDecimal(int digits, String prefix) {
		if(digits == 0) {
			System.out.println(prefix);
		}
		else {
			for(int i = 0; i <= 15; i++)
				printDigitDecimal(digits - 1, prefix + Integer.toHexString(i));


		}
	}
	public static void printDigitDecimal(int digits) {
		printDigitDecimal(digits, "");
	}
	
	public static void main(String[] args) {
		//printDigitDecimal(2);
		printWildBinary("11????11");
	}
}
