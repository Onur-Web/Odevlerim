package week1;

import java.util.Scanner;

public class YildizUcgen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Orta Nokta Basamak Değerini Giriniz : ");
        int n = input.nextInt();

        // boslukSayisi = n - i;
        // yildizSayisi = (2 * i) - 1;

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Boşluk sayısı: i
        // Yıldız sayısı: 2 * (n - i) - 1

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (n - i) - 1; k++) {
                System.out.print("*");

            }
            System.out.println();
        }
    }
}