package week1;

import java.util.Scanner;

public class KullaniciGirisi {
    public static void main(String[] args) {

        String Username, Password, Cevap;

        Scanner profil = new Scanner(System.in);
        System.out.print("Kullanıcı Adınız : ");
        Username = profil.nextLine();
        System.out.print("Şifreniz : ");
        Password = profil.nextLine();


        /* Sizin Yerinize Belirlemiş olduğum Doğru Kullanıcı Adınız : Patika+
                                                   Şifreniz : Java101 */


        if (Username.equals("Patika+") && Password.equals("Java101")) {
            System.out.println("Giriş Başarılı");

        } else {
            System.out.println("Hatalı Şifre!!! Şifrenizi Unuttuysanız Sıfırlamak İstermisiniz? ");
            System.out.println("Evet\nHayır");
            Cevap = profil.nextLine(); //Verilecek olan yanıtı (Evet Ve Hayır) seçebilmemiz için bu satırı buraya ekledim.
            if (Cevap.equals("Evet")) {
                System.out.print("Yeni Şifrenizi Giriniz : ");
                String NewPassword = profil.nextLine();
                if (NewPassword.equals(Password)) {
                    System.out.println("Lütfen Eskisinden Farklı Bir Şifre Giriniz : ");
                } else {
                    System.out.println("Yeni Şifreniz Oluşturuldu.");
                }
            } else if (Cevap.equals("Hayır")) {
                System.out.println("Tekrar Bekleriz.");

            } else {
                System.out.println("Hatalı Giriş Yaptınız!!!");

            }
        }
    }
}