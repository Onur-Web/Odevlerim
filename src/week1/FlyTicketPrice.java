package week1;

import java.util.Scanner;

public class FlyTicketPrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Mesafeyi 'km' Türünden Giriniz : ");
        int mesafe = input.nextInt();
        System.out.print("Yaşınızı Giriniz : ");
        int yas = input.nextInt();
        System.out.print("Yolculuk Tipini Giriniz (1: Tek Yön, 2: Gidiş-Dönüş) : ");
        int tip = input.nextInt();

        double perKM = 0.10;
        double toplam = mesafe * perKM;

        if (mesafe <= 0 || yas <= 0 || (tip != 1 && tip != 2)) {
            System.out.println("Hatalı Giriş Yaptınız!!!");
            return;
        }

        if (yas < 12) {
            toplam *= 0.5; // %50
        } else if (yas >= 12 && yas <= 24) {
            toplam *= 0.9; // %10
        } else if (yas >= 65) {
            toplam *= 0.7; // %30
        }

        if (tip == 2) {
            toplam *= 0.8;
        }

        System.out.println("Bilet Fiyatı : " + toplam + " TL");
    }
}