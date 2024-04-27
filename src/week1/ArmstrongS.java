package week1;

import java.util.Scanner;

public class ArmstrongS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        int toplam = 0;

        while (sayi != 0) {
            int basamak = sayi % 10;
            toplam += basamak;
            sayi /= 10;
        }

        System.out.println("Basamakların toplamı: " + toplam);
    }
}