package week2;

import java.util.Scanner;

public class AsalSayiBulma2 {

// Min Değer 2 alınır
    static boolean asal(int sayi) {
        if (sayi < 2)
            return false;
        return asalKopya(sayi, 2);
//Doğruysa asalKopya ya Döner
    }
    static boolean asalKopya(int sayi, int bolen) {
//Karesinden Büyük Olanlara Bakılır
        if (bolen * bolen > sayi)
            return true;
//Çift Sayılar Elenir
        if (sayi % bolen == 0)
            return false;
        return asalKopya(sayi, bolen + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz : ");
        int sayi = scanner.nextInt();

        if (asal(sayi))
            System.out.println(sayi + " sayısı asaldır.");
        else
            System.out.println(sayi + " sayısı asal değildir.");
    }
}