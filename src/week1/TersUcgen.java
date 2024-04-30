package week1;

import java.util.Scanner;

public class TersUcgen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Basamak Sayısını Giriniz : ");
        int n = scanner.nextInt();
        // Girilen Değer "n"

        // Yıldız Sayısı = Girilen Değer
        // Satır Sayısı = Girilen Değer
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}