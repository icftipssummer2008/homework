class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int num1len = num1.length();
        int num2len = num2.length();
        int[] res = new int[num1len + num2len];

        for(int i = num1len - 1; i >=0; i--){
            for(int j = num2len - 1; j >=0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos = i + j + 1;
                int carryOver = i + j;

                int sum = mul + res[pos];

                res[pos] = sum % 10;
                res[carryOver] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : res){
            if(!(sb.length() == 0 && i == 0)){
                sb.append(i);
            } 
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}