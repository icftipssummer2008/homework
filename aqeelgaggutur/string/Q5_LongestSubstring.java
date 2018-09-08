class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2) return s.length();
        int maxLength = 0;
        int chars = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int read = 0;
        int write = 0;
        int currentLength = 0;
        while(read < s.length()){
            char currChar = s.charAt(read);
            if(chars == 0 || chars == 1){
                if(map.containsKey(currChar)){
                    map.put(currChar, map.get(currChar) + 1);
                } else {
                    map.put(currChar, 1);
                    chars++;
                }
                currentLength++;
                read++;
            } else {
                if(map.containsKey(currChar)) {
                    map.put(currChar, map.get(currChar) + 1);
                    currentLength++;
                    read++;
                } else {
                    if(currentLength > maxLength) maxLength = currentLength;
                    boolean breakit = false;
                    while(!breakit && write < s.length()) {
                        char writeChar = s.charAt(write);
                        if(map.get(writeChar) == 1) {
                            map.remove(writeChar);
                            chars--;
                            currentLength--;
                            breakit = true;
                        } else {
                            map.put(writeChar, map.get(writeChar)- 1);
                            currentLength--;
                        }
                        write++;
                    }
                }
            }
        }
        return currentLength > maxLength ? currentLength : maxLength;
    }
}