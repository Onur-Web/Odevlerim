package week1;

import java.util.Scanner;

public class Faktoriyel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Formül C(n,r) = n! / (r! * (n-r)!)");
        System.out.print("n Sayısını Giriniz : ");
        int n = input.nextInt();
        System.out.print("r Sayısını Giriniz : ");
        int r = input.nextInt();

        int kombinasyon ;
        int toplam = 1;
        int aratoplam = 1;

        for (int i = 1; i <= n; i++) {
            aratoplam *= i;
        }
        int ntoplam = 1;
        for (int i = 1; i <= n; i++) {
            toplam *= i;
        }
        if (n < r) {
            System.out.println("(r)-(n) den Büyük Olamaz!!!");
        } else {
            int rtoplam = 1;
            for (int i = 1; i <= r; i++) {
                toplam *= i;
            }
            kombinasyon = ntoplam / (rtoplam * aratoplam);
            System.out.print(kombinasyon);
            System.out.println(n + ". Faktöriyel : " + toplam);
        }
    }
}

//C(n,r) = n! / (r! * (n-r)!) 2 tane girdi n ve r diye 3 fansiyon çağrılıyor