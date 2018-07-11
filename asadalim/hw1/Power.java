/**
 * Created by asad.alim on 7/4/18.
 */

/*
-ve power is allowed

 */
public class Power {
    public static double power(double base, int power) {
        if (power == 0) return 1;
        if (power == 1) return base;
        else {
            if (power <1)
                return 1 / (base) * power(base,power+1);
            else
                return base * power(base,power-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Power of 4^4 = " + Power.power(4,4));
        System.out.println("Power of 4^(-2) = " + Power.power(4,-2));
        System.out.println("Power of 4^(-2) = " + Power.power(4,0));

    }
}

