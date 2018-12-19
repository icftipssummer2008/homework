package string;

public class MinWindowSubString {
	public static void main(String[] args) {
		/*
		 * Input: S = "ADOBECODEBANC", T = "ABC"
			Output: "BANC"
		 */
		
		System.out.println(getMinWindow("ADOBECODEBANC", "ABC"));
		System.out.println(getMinWindow("ABAACBAB", "ABC"));
	}
	
	public static String getMinWindow(String str, String subStr) {
		int start = 0;
		int subStrLen = subStr.length();
		int end = subStrLen;
		String output = null;
		
		for (start = 0; start < str.length() - subStrLen; start++) {
			while(end <= str.length()) {
				String choice = str.substring(start, end);
				int matchCount = 0;
				for(int i = 0; i < subStr.length(); i++) {
					if(choice.indexOf(subStr.charAt(i)) == -1) {
						break;
					}
					else {
						matchCount ++;
					}
					if(subStr.length() == matchCount && (output == null || choice.length() < output.length())) {
						output = choice;
					}
				}
				
				end++;
			}
			end = start + subStrLen;
		}
		
		return output;
	}
	
}
