package week1;

import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int dogumyili, sonuc;
        String burcunuz = "";

        System.out.print("Doğum Yılınızı Giriniz : ");
        dogumyili = input.nextInt();

        sonuc = dogumyili % 12;

        switch (sonuc) {
            case 0:
                burcunuz = "Maymun";
                break;
            case 1:
                burcunuz = "Horoz";
                break;
            case 2:
                burcunuz = "Köpek";
                break;
            case 3:
                burcunuz = "Domuz";
                break;
            case 4:
                burcunuz = "Fare";
                break;
            case 5:
                burcunuz = "Öküz";
                break;
            case 6:
                burcunuz = "Kaplan";
                break;
            case 7:
                burcunuz = "Tavşan";
                break;
            case 8:
                burcunuz = "Ejderha";
                break;
            case 9:
                burcunuz = "Yılan";
                break;
            case 10:
                burcunuz = "At";
                break;
            case 11:
                burcunuz = "Koyun";
                break;
            default:
                System.out.println("Hatalı Giriş Yaptınız!!!");
        }
        System.out.println("Çin Zodyağı Burcunuz : " + burcunuz);
    }
}