package week1;

import java.util.Scanner;

public class UcgenAlani {
    public static void main(String[] args) {

        int a , b, c ;
        double u , x ;

        Scanner v1 = new Scanner(System.in) ;
        System.out.print("1. Kenarı Giriniz : ") ;
        a = v1.nextInt() ;
        System.out.print("2. Kenarı Giriniz : ") ;
        b = v1.nextInt() ;
        System.out.print("3. Kenarı Giriniz : ") ;
        c = v1.nextInt() ;

        u = (a + b + c) / 2.0;
        x = Math.sqrt(u * (u - a) * (u - b) * (u - c)) ;

        System.out.println("Üçgen'in Çevresi : " + (a+b+c) ) ;
        System.out.println("Üçgen'in Alanı : " + x ) ;

    }
}