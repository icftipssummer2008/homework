import java.util.Scanner;

public class Power{
  public static void main(String[] args){
    System.out.println( Math.pow(6,-2)+" "+ power(6,-2));
  }

  public static double power(double number,long power){
    if(power == 0){
      return 1;
    }

    if(power<0){
      number = 1/number;
      power = power * -1;
    }

    return ((power % 2 == 0)?1:number) * power(number,power/2) * power(number,power/2);
  }
}
