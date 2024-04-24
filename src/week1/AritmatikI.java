package week1;

import java.util.Scanner;

public class AritmatikI {
    public static void main(String[] args) {

        double a , b , c ;

        Scanner A1 = new Scanner(System.in);
        System.out.print("Birinci Değeri Giriniz : ");
        a = A1.nextDouble();

        System.out.print("İkinci Değeri Giriniz : ");
        b = A1.nextDouble();

        System.out.print("Üçüncü Değeri Giriniz : ");
        c = A1.nextDouble();

        double sonuc = (a+b)*(c-b);
        System.out.println("İşleminin Sonucu : " + sonuc);

    }
}
