package week1;

import java.util.Scanner;

//Bir sayının kendisi hariç
// pozitif tam sayı çarpanları(kalansız bölen sayıların)
// toplamı kendisine eşit olan
// sayıya mükemmel sayı denir.


public class MukemmelSayiBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir Sayı Giriniz : ");
        int girilensayi = input.nextInt();

        // bir sayının kendisi hariç pozitif tam sayı çarpanlarının toplamı
        int a = 0;
        for (int i = 1; i < girilensayi; i++) {
            if (girilensayi % i == 0) {
                a += i;
            }
        }
if (a == girilensayi){
    System.out.println(girilensayi + " Mükemmel Sayıdır");
}else {
    System.out.println(girilensayi + " Mükemmel Sayı Değildir");
}

    }
}
