package week1;

import java.util.Scanner;

public class TaksiMetre {
    public static void main(String[] args) {

        int km ;
        double pKm = 2.20 , total , openprice = 10;

        Scanner A1 = new Scanner(System.in) ;
        System.out.print("Mesafeyi KM cinsinden giriniz : ") ;
        km = A1.nextInt() ;

        total = (km * pKm) ;
        total += openprice ;

        total = (total < 20) ? 20 : total ;

        System.out.println("Toplam Tutar : " + total);

    }
}
