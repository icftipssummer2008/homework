package src;

/**
 * Created by shairyarshafqat on 7/6/18.
 */
public class powerFunctionToRaiseDouble {

    static double pow (double base, int exp) {
        if (exp == 0)
            return 1;

        else if (exp > 0 && exp % 2==0)
            return pow(base * base, exp/2);

        else if (exp > 0 && exp % 2!= 0)
            return base * pow(base, exp-1);

     return pow(base, exp);
    }


    public static void main(String[] args) {
        System.out.println(pow(2, 2));
    }
}
