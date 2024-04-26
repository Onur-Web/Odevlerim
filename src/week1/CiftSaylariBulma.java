package week1;

import java.util.Scanner;

public class CiftSaylariBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen Bir Sayı Giriniz : ");
        int girilendeger = input.nextInt();
        int i = 1;
        int toplam = 0, adet = 0;

        while (i <= girilendeger) {
            if (i % 12 == 0) {
                toplam += i;   //tam bölünen sayıyı toplama +
                adet++;        //tam bölünen sayı adedini +
            }
            i++;
        }
        if (adet > 0) {
            double ortalama = (double) toplam / adet;
            System.out.println("Girilen Sayının 12'ye Tam Bölünenlerin Ortalaması : " + ortalama);
        }else {
            System.out.println("Değer Bulunamadı!!!");
        }
    }
}