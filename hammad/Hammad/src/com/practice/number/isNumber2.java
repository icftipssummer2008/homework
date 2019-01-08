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
public class isNumber2 {
	
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
		
		assertTrue(ensureNumber("0"));
		assertTrue(ensureNumber(" 0.1 "));
		assertFalse(ensureNumber("abc"));
		assertFalse(ensureNumber("1 a"));
		assertTrue(ensureNumber("2e10"));
		assertTrue(ensureNumber(" 0. "));
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
		assertFalse(ensureNumber("e9"));
		assertTrue(ensureNumber("3."));
		assertFalse(ensureNumber(".e1"));
		
		assertTrue(ensureNumber("-1."));
		assertFalse(ensureNumber("1-2"));
		assertTrue(ensureNumber("+1."));
		assertTrue(ensureNumber("+.1"));
		assertFalse(ensureNumber("+."));
		assertTrue(ensureNumber("46.e3"));
		assertFalse(ensureNumber("1e."));
		assertFalse(ensureNumber("6e6.5"));
		assertFalse(ensureNumber("-e58"));
		assertTrue(ensureNumber(" 005047e+6"));
		assertFalse(ensureNumber("4e+"));
		assertTrue(ensureNumber(".703e+4144"));
		assertTrue(ensureNumber("+42e+76125"));


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
        int actualLength = charArray.length;


        int start = 0;
        int end = length - 1;
        
        boolean foundFirstNonSpace = false;
        boolean foundLastNonSpace = false;
        for (int i = 0; i < actualLength; i++) {
        	char c = charArray[i];
        	if(c != ' ') {
        		foundFirstNonSpace = true;
        	}
        	if(c == ' ' && !foundFirstNonSpace) {
        		start++;
        		length--;
        	}
        	int lastIndex = actualLength - 1 - i;
        	if(lastIndex > 0) {
            	char lc = charArray[lastIndex];
            	
            	if(lc != ' ') {
            		foundLastNonSpace = true;
            	}

        		if(lc == ' ' && !foundLastNonSpace) {
        			end--;
            		length--;
            	}
        	}
        	
        	if(foundFirstNonSpace && foundLastNonSpace) {
        		break;
        	}
        	
        }
        
        if(length == 0) {
        	return false;
        }
        
        char firstChar = charArray[start];
        char lastChar = charArray[end]; 
        
        if(lastChar == 'e' || lastChar == '-' || lastChar == '+') {
        	return false;
        }

        if(firstChar == 'e') {
        	return false;
        }
        if(length == 1 && firstChar == '.') {
        	return false;
        }
        
        // First and last character can be a dot (.)
        // e can't be the last number. we can't have 2 e's
        // space can only be first and last character
        int countE = 0;
        int countDot = 0;
        int countMinus = 0;
        int countPlus = 0;
        int countDigit = 0;
        char previousChar = '~';
        boolean previousCharNotDigit = false;
        boolean plusWithE = false;
        boolean minusWithE = false;
        
        for (int i = start; i <= end; i++) {
        	char c = charArray[i];
        	//System.out.println(c);
        	
        	if (i != start && previousChar != 'e' && (c == '-' || c == '+')) {
        		return false;
        	}
        	
        	int currentCharDiff = '9' - c;
 
        	boolean isThisNotNumber = currentCharDiff < 0 ||  currentCharDiff > diff;
        	
        	if(isThisNotNumber) {
        		if( (firstChar != '+' && firstChar != '-' && firstChar == '.') && (previousChar != 'e' && (c !='+' || c != '-' )) && previousCharNotDigit) {
        			return false; 
        		}
        		if(previousChar != 'e' && c !='+') {
        			plusWithE = true;
        		}
        		if(previousChar != 'e' && c !='-') {
        			minusWithE = true;
        		}
        			
        		if(previousCharNotDigit && i == end && c =='.') {
        			return false;
        		}
        		
        		previousCharNotDigit = true;
        	}
        	else {
        		previousCharNotDigit = false;
        	}
        	
			if( isThisNotNumber && c != 'e' &&  c != '.' &&  c != '-' &&  c != '+' ) {
        		return false;
        	}
        	
        	// if only one char then it shouldn't be 
        	if(length == 1)  {
        		if(c == 'e' || c == '.' || c == '-') {
        			return false;
        		}
        	}
        	
        	if (countE > 0 && c == '.') {
        		return false;
        	}
        	
        	if ( (previousChar == '-' )  && c == 'e' ) {
        		return false;
        	}

        	if ( c == 'e' ) {
        		countE++;
        	}
        	if ( c == '.' ) {
        		countDot++;
        	}
        	if ( c == '-' ) {
        		countMinus++;
        	}
        	if ( c == '+' ) {
        		countPlus++;
        	}
        	if(!isThisNotNumber) {
        		countDigit ++;
        	}
        	
        	if(countE > 1 || countDot > 1) {
        		return false;
        	}
        	
        	if(countMinus >1 || countPlus >1) {
        		if(countMinus == 2 && !minusWithE) {
        			return false;
        		}
        		if(countPlus == 2 && !plusWithE) {
        			return false;
        		}
        	}
        	
        	previousChar = c;
        	
        }
        
        if( countDigit == 0 ) {
        	return false;
        }
        
     
    	return true;
    }
	
}
