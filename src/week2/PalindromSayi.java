package week2;

import java.util.Scanner;

public class PalindromSayi {

    static boolean isPaindrom(int girilenSayi) {
        int girilenSayiEsDegeri = girilenSayi, girilenSayiSonBasamak = 0, girilenSayininKalani;
        while (girilenSayiEsDegeri != 0) {
            girilenSayininKalani = girilenSayiEsDegeri % 10;
            girilenSayiSonBasamak = (girilenSayiSonBasamak * 10) + girilenSayininKalani;
            girilenSayiEsDegeri /= 10;
        }
        return girilenSayi == girilenSayiSonBasamak;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı girin : ");
        int girilenSayi = input.nextInt();

        boolean isPalindrome = isPaindrom(girilenSayi);
        if (isPalindrome) {
            System.out.println(girilenSayi + " Bir Palindrom Sayıdır");
        } else {
            System.out.println(girilenSayi + " Bir Palindrom Değildir");
        }
    }
}