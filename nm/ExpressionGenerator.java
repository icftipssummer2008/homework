import java.util.Scanner;

public class ExpressionGenerator{
  public static void main(String[] args){
    expressionGenerator("123");

    /* // OUTPUT

    123
12*3
12+3
1*23
1*2*3
1*2+3
1+23
1+2*3
1+2+3

*/
  }

  public static void expressionGenerator(String string){
    String str=string.substring(1,string.length());
    String exp = String.valueOf(string.charAt(0));
    expressionGenerator(str,exp,0);
  }

  public static void expressionGenerator(String string,String exp,int index){

    if(index >= string.length()){
      System.out.println(exp);
    }else{
      expressionGenerator(string,exp+string.charAt(index),index+1);
      expressionGenerator(string,exp+"*"+string.charAt(index),index+1);
      expressionGenerator(string,exp+"+"+string.charAt(index),index+1);
    }
  }
}
