package week1;

import java.util.Scanner;

public class HarmonikSayilar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("N Sayısını Giriniz : ");
        int n = input.nextInt();
        double sonuc = 0.0;

        for (double i = 1; i <= n; i++) {
            sonuc += (1.0 / i);
        }
        System.out.println("İşlem Sonucu : " + sonuc);
    }
}
