package week1;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String userName, password;

        int kalanHak = 3;
        int bakiye = 1000;
        int secim , price;

        while (kalanHak > 0) {
            System.out.print("Kullanıcı Adınız : ");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();
            if (userName.equals("patika") && (password.equals("java101"))) {
                System.out.println("Merhabalar");
                do {
                    System.out.println("1:Para Yatıma\n2:Para Çekme\n3:Bakiye Sorgula\n4:Çıkış Yap");
                    System.out.print("Lütfen Yapmak İstediğiniz Seçeneği Seçin : ");
                    secim = input.nextInt();
                    switch (secim) {
                        case 1:
                            System.out.print("Para Miktarı : ");
                            price = input.nextInt();
                            bakiye += price;
                            break;
                        case 2:
                            System.out.print("Para Miktarı : ");
                            price = input.nextInt();
                            if (price > bakiye) {
                                System.out.println("Bakiye Yetersiz!!!");
                            } else {
                                bakiye -= price;
                            }
                        case 3:
                            System.out.println("Bakiyeniz : " + bakiye);
                            break;
                        case 4:
                            System.out.println("Tekrar Bekleriz.");
                            break;
                        default:
                            System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    }
                } while (secim != 4);
                System.out.println("Tekrar Bekleriz");
                break;
            } else {
                kalanHak--;
                System.out.println("Hatalı Giriş Yaptınız!!! Tekrar Deneyiniz.");
                if (kalanHak == 0) {
                    System.out.println("Hesabınız GG");
                }
                System.out.println("Kalan Hakkınız : " + kalanHak);
            }
        }
    }
}