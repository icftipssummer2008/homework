/**
 * Created by asad.alim on 7/8/18.
 */
/*
Q6: Expression Generator
Given a string of integers as input, put between each pair of digits, one of {“”, “*”, “+”} to generate all possible expressions as Strings. Putting an empty string ("") between two numbers means, that the numbers are joined to form a new number
(e.g. 1 "" 2 = 12)

 */
public class ExpressionGenerator {
    public void generateExpression(String input ) {
        generateExpressionHelper(input,new String[]{"","*","+"},"");
    }

    public void generateExpressionHelper(String input,String[] operator,String output){
        if (input.length() < 1) {
            System.out.println(output);
            return;
        }
        for (int i=0;i<operator.length;i++) {
            String str=operator[i];
            generateExpressionHelper(input.substring(1),operator,input.charAt(0)+str+output);
        }
    }

    public static void main(String[] args) {
        ExpressionGenerator app = new ExpressionGenerator();
        app.generateExpression("222");
    }
}

