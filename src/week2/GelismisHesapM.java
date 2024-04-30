package week2;

import java.util.Scanner;

public class GelismisHesapM {

    static void toplama(int a, int b) {
        int result = a + b;
        System.out.println("=========================");
        System.out.println("Toplam : " + result);
        System.out.println("=========================");
    }

    static void cikarma(int a, int b) {
        int result = a - b;
        System.out.println("=========================");
        System.out.println("Çıkarma : " + result);
        System.out.println("=========================");
    }

    static int carpma(int a, int b) {
        int result = a * b;
        System.out.println("=========================");
        System.out.println("Çarpma : " + result);
        System.out.println("=========================");
        return result;
    }

    static void bolme(double a, double b) {
        if (b != 0) {
            double result = a / b;
            System.out.println("=========================");
            System.out.println("Bölme : " + result);
            System.out.println("=========================");
        } else {
            System.out.println("Bir Sayı Sıfıra Bölünemez!");
        }
    }

    static void uslu(int a, int b) {
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        System.out.println("=========================");
        System.out.println("Üssü : " + result);
        System.out.println("=========================");
    }

    static void mod(int a, int b) {
        int result = a % b;
        System.out.println("=========================");
        System.out.println("Mod : " + result);
        System.out.println("=========================");
    }

    static void calc(int a, int b) {
        System.out.println("=========================");
        System.out.println("Çevresi : " + (2 * (a + b)));
        System.out.println("Alanı : " + (a * b));
        System.out.println("=========================");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int select;

        String menu = ("1- Toplama İşlemin\n" +
                "2- Çıkarma İşlemin\n" +
                "3- Çarpma İşlemin\n" +
                "4- Bölme İşlemi\n" +
                "5- Üslü Sayı Hesaplaman\n" +
                "6- Mod Alman\n" +
                "7- Dikdörgen Alan ve Çevre Hesabı İşlemin\n" +
                "0- Çıkış Yap");

        while (true) {
            System.out.println(menu);
            System.out.print("Yapmak İstediğiniz Seçimi Seçiniz : ");
            select = scan.nextInt();
            if (select == 0) {
                break;
            }
            if (select < 1 || select > 7) {
                System.out.println("Geçersiz Bir İşlem!!!");
                continue;
            }
            System.out.print("İlk Sayıyı Giriniz : ");
            int a = scan.nextInt();    //Alınan 1.Değer
            System.out.print("İkinci Sayıyı Giriniz : ");
            int b = scan.nextInt();    //Alınan 2.Değer

            switch (select) {
                case 1:
                    toplama(a, b);
                    break;
                case 2:
                    cikarma(a, b);
                    break;
                case 3:
                    carpma(a, b);
                    System.out.println(carpma(a,b));
                    break;
                case 4:
                    bolme(a, b);
                    break;
                case 5:
                    uslu(a, b);
                    break;
                case 6:
                    mod(a, b);
                    break;
                case 7:
                    calc(a, b);
            }
        }
    }
}
