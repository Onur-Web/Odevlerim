package week1;

import java.util.Scanner;

public class TersUcgen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Basamak Sayısını Giriniz : ");
        int n = scanner.nextInt();
        // Girilen Değer "n"


        //Yıldız Sayısı 2 * n - 1
        //Satır Sayısı = Girilen Değer
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}