package week1;

import java.util.Scanner;

public class BuyukKucukSenaryo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz? : ");
        // n kadar sayı
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Pozitif Bir Sayı Giriniz!!!");
            return;
        }
        System.out.print("1. Sayıyı Giriniz : ");
        int ilknumara = input.nextInt();
        int max = ilknumara;
        int min = ilknumara;

        for (int i = 2; i <= n; i++) {
            System.out.print(i + ". sayıyı giriniz : ");
            int numara = input.nextInt();

            if (numara > max) {
                max = numara;
            }
            if (numara < min) {
                min = numara;
            }
        }
        System.out.println("En büyük sayı: " + max);
        System.out.println("En küçük sayı: " + min);
    }
}