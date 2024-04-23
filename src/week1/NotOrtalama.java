package week1;

import java.util.Scanner;

public class NotOrtalama {
    public static void main(String[] args) {

        int Matamatik,Fizik,Kimya,Biyoloji,Turkce,Tarih,Muzik ;

        Scanner NotOrtalamasi = new Scanner(System.in);

        System.out.print("Matamatik Notunuz : ") ;
        Matamatik = NotOrtalamasi.nextInt() ;

        System.out.print("Fizik Notunuz : ") ;
        Fizik =  NotOrtalamasi.nextInt() ;

        System.out.print("Kimya Notunuz : ") ;
        Kimya =  NotOrtalamasi.nextInt() ;

        System.out.print("Biyoloji Notunuz : ") ;
        Biyoloji = NotOrtalamasi.nextInt() ;

        System.out.print("Türkçe Notunuz : ") ;
        Turkce =  NotOrtalamasi.nextInt() ;

        System.out.print("Tarih Notunuz : ") ;
        Tarih =  NotOrtalamasi.nextInt() ;

        System.out.print("Muzik Notunuz : ") ;
        Muzik = NotOrtalamasi.nextInt() ;

        double ortalama =  (Matamatik+Fizik+Kimya+Biyoloji+Turkce+Tarih+Muzik) / 7.0 ;
        String sonuc = (ortalama >= 60) ? "Geçtiniz" : "Kaldınız" ;
        System.out.println("7 Dersin Ortalama Puanı : " + ortalama);
        System.out.println("Sonuç : " + sonuc);

    }
}