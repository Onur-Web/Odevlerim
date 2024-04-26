package week1;

import java.util.Scanner;

public class SayidanKucuk2Kuvvetleri {
    public static void main(String[] args) {
        Scanner o_o = new Scanner(System.in);

        long sayi;

        System.out.print("Bir Sayı Giriniz : ");
        sayi = o_o.nextLong();

        System.out.println("4'ün Kuvvetleri: ");
        for (long i = 1; i <= sayi; i *= 4) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        System.out.println("5'in Kuvvetleri: ");
        for (long i = 1; i <= sayi; i *= 5) {
            System.out.println(i);
        }

    }
}
