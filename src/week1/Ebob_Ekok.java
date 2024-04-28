package week1;

import java.util.Scanner;

public class Ebob_Ekok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("(n1) Sayısını Giriniz : ");
        int n1 = input.nextInt();
        System.out.print("(n2) Sayısını Giriniz : ");
        int n2 = input.nextInt();

        int minimum;
        if (n1 < n2) {
            minimum = n1;
        } else {
            minimum = n2;
        }

        int ebob = 1;
        int i = 1;
        while (i <= minimum) {
            if ((n1 % i == 0 && n2 % i == 0)) {
                ebob = i;
            }
            i++;

        }
        System.out.println("Sayıların EBOB'u : " + ebob);

        int ekok = n1 * n2 / ebob;
        System.out.println("Sayıların EKOK'u : " + ekok);
    }
}