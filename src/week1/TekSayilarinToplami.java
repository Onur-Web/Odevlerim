package week1;

import java.util.Scanner;

public class TekSayilarinToplami {
    public static void main(String[] args) {
        Scanner sawMe = new Scanner(System.in);

        int sayi, total = 0;

        do {
            System.out.print("Sayı Giriniz(Çıkmak için Tek Sayı Yazın) : ");
            sayi = sawMe.nextInt();
            if (sayi % 4 == 0 ) {
                total += sayi;
            }
        } while (sayi % 2 == 0);
        System.out.println("Toplam : " + total);

    }
}
