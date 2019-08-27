package string;

public class StringCompression {
	public static void main(String[] args) {
		String str = "aaaabbbccccd";
		System.out.println(compress(str));
		
		char[] charArray = str.toCharArray();
		int indx = compresss(charArray);
		for(int i = 0 ; i < indx; i++) {
			System.out.print(charArray[i]);
		}
		System.out.println();
		myPrintRLE(str);
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
	
    public static void printRLE(String str) 
    { 
        int n = str.length(); 
        for (int i = 0; i < n; i++) { 
  
            // Count occurrences of current character 
            int count = 1; 
            while (i < n - 1 &&  
                   str.charAt(i) == str.charAt(i + 1)) { 
                count++; 
                i++; 
            } 
  
            // Print character and its count 
            System.out.print(str.charAt(i)); 
            System.out.print(count); 
        } 
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
	
    public static int compresss(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
    

    public static void myPrintRLE(String str) { 
    	int length = str.length();
    	for(int i = 0; i < length; i++) {
    		int count = 1;
    		while(i < length - 1 && str.charAt(i) == str.charAt(i + 1)) {
    			i++;
    			count++;
    		}
    		System.out.print(str.charAt(i));
    		if(count > 1) {
    			System.out.print(count);
    		}
    	}
    }

    public static void myPrintRLE(char[] str) { 
    	int length = str.length;
    	//int pointer = 0;
    	for(int i = 0; i < length; i++) {
    		int count = 1;
    		while(i < length - 1 && str[i] == str[i + 1]) {
    			i++;
    			count++;
    		}
    		System.out.print(str[i]);
    		if(count > 1) {
    			System.out.print(count);
    		}
    	}
    }
}
