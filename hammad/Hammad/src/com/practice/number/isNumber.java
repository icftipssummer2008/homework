package com.practice.number;



/**
 * 
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 */
public class isNumber {
	
	public static void assertEqual(boolean v1, boolean v2) {
		if(v1 != v2) {
			throw new RuntimeException("Test failed. Expected value was: " + v2);
		}
	}
	public static void assertTrue(boolean v1) {
		assertEqual(v1, true);

	}
	public static void assertFalse(boolean v1) {
		assertEqual(v1, false);
		
	}

	
	public static void main(String[] args) {
		
		assertTrue(ensureNumber("e5"));
		assertTrue(ensureNumber("0"));
		assertTrue(ensureNumber(" 0.1 "));
		assertFalse(ensureNumber("abc"));
		assertFalse(ensureNumber("1 a"));
		assertTrue(ensureNumber("2e10"));
		assertFalse(ensureNumber(" 0. "));
		assertTrue(ensureNumber("1e10"));
		assertTrue(ensureNumber("2e1"));
		assertFalse(ensureNumber(" "));
		assertFalse(ensureNumber("."));		
		assertTrue(ensureNumber("2e0"));
		assertFalse(ensureNumber(".."));
		assertFalse(ensureNumber(".e"));
		assertTrue(ensureNumber(".1"));
		assertTrue(ensureNumber("   22   "));
		assertFalse(ensureNumber("2 2"));
		assertFalse(ensureNumber("2e"));
		assertTrue(ensureNumber("3."));

	}
	
	public static boolean ensureNumber(String s) {
		boolean output = isNumberr(s);
		System.out.println(s + ": " + output);
		return output;
	}
	
    public static boolean isNumberr(String s) {
        char[] charArray = s.toCharArray();
        
        int diff = '9' - '0';
        
        int length = charArray.length;
        char firstChar = charArray[0];
        char lastChar = charArray[length-1];
        
        int start = firstChar == ' ' ? 1: 0;
        int end = lastChar == ' ' ? length -1: length;
        
        if(end == 0) {
        		return false;
        }
        
        int eCount = 0;
        int dotCount = 0;

        for(int k = start ; k < end ; k++) {
        		char c = charArray[k];
        		int i = '9' - c;
        		boolean isInt = i > diff ||  i < 0;
			
        		if( c != 'e' && c != '.' && c != ' ' && isInt) {
        			return false;
        		}
        		
        		if(c == 'e' || c == '.' || c == ' ') {
        			
        			if(start == end -1) {
        				return false;
        			}
        			
        			if(c == 'e' && (k == start || k == end -1)) {
        				return false;
        			}

        			if(c == '.' && (k == end -1)) {
        				return false;
        			}

        			if(c == '.' ) {
        				dotCount++;
        			}
        			else if(c == 'e' ) {
        				eCount++;
        			}
        			
        			if((dotCount > 1 || eCount > 1) || (dotCount >= 1 && eCount >= 1)) {
        				return false;
        			}
        			
/*        			if((k > start && k < end -1) && charArray[k -1]  != ' ' && charArray[k +1 ]  != ' ') {
        				return false;
        				
        			}*/


        		}

        }
        
    		return true;
    }
	
}
