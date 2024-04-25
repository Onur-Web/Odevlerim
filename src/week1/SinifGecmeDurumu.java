package week1;

import java.util.Scanner;

public class SinifGecmeDurumu {
    public static void main(String[] args) {

        double matamatik, fizik, kimya, turkce, muzik;
        double toplamNot = 0;
        int dersSayisi = 0;
        double ortalama;

        Scanner sinif = new Scanner(System.in);

        System.out.print("Matamatik Notunuz : ");
        matamatik = sinif.nextDouble();
        if (matamatik >= 0 && matamatik <= 100) {
            toplamNot += matamatik;
            dersSayisi++;
        }

        System.out.print("Fizik Notunuz : ");
        fizik = sinif.nextDouble();
        if (fizik >= 0 && fizik <= 100) {
            toplamNot += fizik;
            dersSayisi++;
        }

        System.out.print("Kimya Notunuz : ");
        kimya = sinif.nextDouble();
        if (kimya >= 0 && kimya <= 100) {
            toplamNot += kimya;
            dersSayisi++;
        }

        System.out.print("Türkçe Notunuz : ");
        turkce = sinif.nextDouble();
        if (turkce >= 0 && turkce <= 100) {
            toplamNot += turkce;
            dersSayisi++;
        }

        System.out.print("Müzik Notunuz : ");
        muzik = sinif.nextDouble();
        if (muzik >= 0 && muzik <= 100) {
            toplamNot += muzik;
            dersSayisi++;
        }

        if (toplamNot > 0) {
            ortalama = toplamNot / dersSayisi;
            System.out.println("Ortalamanız : " + ortalama);
            if (ortalama < 55) {
                System.out.println("Sınıfta Kaldınız.");
            } else {
                System.out.println("Sınıfı Geçtiniz.");
            }

        }

    }
}
