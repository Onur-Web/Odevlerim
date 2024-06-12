
//SINIFLARIMIZIN TANIMLARI
//Entity --> veri tabanından çektiğimiz verilerin aktarımını sağlayacağız
//core --> proje ile ilgili yapı taşlarının bulunduğu yer
//DAO (Data Access Object) --> Businessın veri tabanı işlemlerini yaptığı yer
//Business --> Viewların iletişim kurdukları yer
//View --> Arayüz Yönetimini Yöneteceğiz

package week7.carRental;

import week7.carRental.business.UserManager;
import week7.carRental.core.Helper;
import week7.carRental.view.AdminView;

public class App {
    public static void main(String[] args) {
        //PROGRAM BAŞLADIĞINDA TEMAYI GETİRMEK
        Helper.setTheme();

        //ILK TABLOYA(LOGIN VIEW) HERSEFERİNDE GİRİŞ YAPMAMAK İÇİN SADECE ADMIN VIEW BAŞLATMA KOMUTU
        UserManager userManager = new UserManager();
        AdminView login = new AdminView(userManager.findByLogin("Mustafa","1234"));
    }
}
