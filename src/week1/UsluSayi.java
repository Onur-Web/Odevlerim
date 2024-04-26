package week1;

import java.util.Scanner;

public class UsluSayi {
    public static void main(String[] args) {

        int taban , ustu ;

        Scanner input = new Scanner(System.in);
        System.out.print("Taban Sayısını Giriniz : ");
        taban = input.nextInt();

        System.out.print("Üst Sayısını Giriniz : ");
        ustu = input.nextInt();

        int total = 1 ;

        for (int i = 1; i<= ustu ; i++ ){
            total *= taban;
        }
        System.out.println("Cevap : " + total);
    }
}
