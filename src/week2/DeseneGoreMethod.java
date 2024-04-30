package week2;

import java.util.Scanner;

public class DeseneGoreMethod {

    public static void method(int n) {
// Eğer değer <= 0 ise
        if (n <= 0) {
// Çıktıya 0'ı Dahil Etmek
            System.out.print(n + " ");
            return;
        }
//Eğer Sayı > 0  ise
        System.out.print(n + " ");
        method(n - 5);
//Girilen Değere Geri Dönme
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı Giriniz : ");
        int n = input.nextInt();

        method(n);
    }
}