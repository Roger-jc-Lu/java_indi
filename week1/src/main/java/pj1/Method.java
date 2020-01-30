package pj1;

import java.util.Scanner;

public class Method{
    
    public int factorial(final int integer) {
        int result = 1;
        for (int i = 1; i <= integer; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(final String[] args) {
        final Method fac = new Method();
        final Scanner sc = new Scanner(System.in);
        final int integer = sc.nextInt();
        sc.close();
        System.out.println(fac.factorial(integer));
    }
}