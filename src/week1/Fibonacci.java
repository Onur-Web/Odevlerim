package week1;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir Sayı Giriniz : ");
        int girilensayi = input.nextInt();

        int a = 0, b = 1;

        for (int i = 0; i < girilensayi; i++) {
            System.out.println(b + " ");
            int saklanacakDeger = a;
            a = b;
            b = saklanacakDeger + b;
        }
    }
}