package week2;

import java.util.Scanner;

public class RecursiveFibonacci {

    //f(n) = f(n-1) + f(n-2)
    static int fibonacci(int n) {       // n = Girilen Sayı
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir Sayı Giriniz : ");
        int n = input.nextInt();

        System.out.println("Sonuç : " + fibonacci(n));
    }
}