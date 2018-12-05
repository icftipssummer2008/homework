package string;

public class StringCompression {
	public static void main(String[] args) {
		System.out.println(compress("aaaabbbccccc"));
		
		char[] charArray = "aaaabbbccccc".toCharArray();
		int indx = compress(charArray);
		for(int i = 0 ; i < indx; i++) {
			System.out.print(charArray[i]);
		}
	}
	
	public static String compress(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			int count = 1;
			char c = str.charAt(i);
			while(i < str.length() && str.charAt(i) == c) {
				count++;
				i++;
			}
			sb.append(c);
			if(count > 1) {
				sb.append(count);
			}
		}
		
		return sb.toString();
	}

	public static int compress(char[] str) {
		int ansIndx = 0;
		for(int i = 0; i < str.length; i++) {
			int count = 1;
			char c = str[i];
			while(i < str.length && str[i] == c) {
				count++;
				i++;
			}
			str[ansIndx++] = c;
			
			if(count > 1) {
				String countStr = String.valueOf(count);
				for(int cIndx = 0; cIndx < countStr.length(); cIndx++) {
					str[ansIndx++] = countStr.charAt(cIndx);
				}
				
			}
		}
		
		return ansIndx;
	}
}
