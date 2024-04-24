package week1;

import java.util.Scanner;

public class HesapM {
    public static void main(String[] args) {

        int number1, number2, choose;

        Scanner input = new Scanner(System.in);
        System.out.print("İlk Sayıyı Giriniz : ");
        number1 = input.nextInt();

        System.out.print("İkinci Sayıyı Giriniz : ");
        number2 = input.nextInt();

        System.out.println("1-Toplam\n2-Çıkarma\n3-Çarpma\n4-Bölme");
        System.out.print("Seçiminiz : ");
        choose = input.nextInt();

        switch (choose) {
            case 1:
                System.out.println("Toplam : " + (number1 + number2));
                break;
            case 2:
                System.out.println("Çıkarma : " + (number1 - number2));
                break;
            case 3:
                System.out.println("Çarpma : " + (number1 * number2));
                break;
            case 4:
                if (number2 != 0) {
                    System.out.println("Bölme : " + (number1 / number2));
                } else {
                    System.out.println("Bir Sayı Sıfıra Bölünemez!");
                }
                break;
            default:
                System.out.println("Geçersiz İşlem Yaptınız");

        }

        System.out.println("İşleminiz Tamamlanmıştır.");

    }
}