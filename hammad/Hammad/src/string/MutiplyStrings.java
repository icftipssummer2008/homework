package string;

public class MutiplyStrings {
	public static void main(String[] args) {
		System.out.println(multiply("-12343243242342434435435435435345345", "-122343242342343243242342343242423423423"));
	}
	
	public static String multiply(String str1, String str2) {
		
		if(str1 == null || str2 == null) {
			return null;
		}
		
		if(str1.length() ==  0 || str1.length() == 0) {
			return "";
		}
		
		String uStr1 = str1;
		String uStr2 = str2;
		
		String sign = "";
		if(str1.charAt(0) != '-' && str2.charAt(0) == '-') {
			sign = "-";
			uStr2 = str2.substring(1);
		}
		else if(str1.charAt(0) == '-' && str2.charAt(0) != '-') {
			sign = "-";
			uStr1 = str1.substring(1);
		}
		else if(str1.charAt(0) == '-' && str2.charAt(0) == '-') {
			uStr1 = str1.substring(1);
			uStr2 = str2.substring(1);
		}
		
		int m = uStr1.length();
		int n = uStr2.length();
		int[] ans = new int[m+n];
		
		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				int mult = (uStr1.charAt(i) - '0') * (uStr2.charAt(j) - '0');
				int p = i+j; int q = i+j+1;
				int sum = ans[q] + mult;
				
				ans[p] += sum/10;
				ans[q] = sum%10;
				
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sign);
		for (int i : ans) {
			sb.append(i);
		}
		
		return sb.toString();
	}
}
