package carRental.view;

import carRental.business.UserManager;
import carRental.core.Helper;
import carRental.entity.User;

import javax.swing.*;
//LOGIN ICIN JFRAME DEN EXTEND EDİLDİ
public class LoginView extends JFrame {
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JPanel w_bottom;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private final UserManager userManager;

    //TABLO İŞLEMLERİ İÇİN OLUŞTURULAN BOŞ CONSTRUCTER
    public LoginView() {
        this.userManager = new UserManager();
        //OLUŞTURULAN ANA JPANELI SISTEME EKLEME
        this.add(container);
        //UYGULAMA KAPATILDIĞINDA UYGULAMA KAPANIR AMA JAVA ÇALIŞMAYA DEVAM EDER
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //UYGULAMA ADI
        this.setTitle("Rent a Car");
        //EKRAN BOYUTU
        this.setSize(600, 600);
        //EKRANI ORTALAMA FORMULU ISLEDIGIMIZ HELPERDAN METODU ALMA VE EKRANI ORTALAMA
        this.setLocation(Helper.getLocationPoint("x", this.getSize()), Helper.getLocationPoint("y",this.getSize()));
        //EKRANI GORUNUR HALE GETİRMEK
        this.setVisible(true);
        //TABLODA BUTONU KULLANDIĞIMIZDA NE OLACAĞINI BELİRLEDİĞİMİZ YAPI VE HELPERDAKİ METODLARI(2) CAGIR
        btn_login.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_username, this.fld_password};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMessage("fill");
            }else {
                //USERDAO YA USER MANEGER İLE ULAŞTIĞIMIZ METODU BURADA ÇAĞIRMAK
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(),this.fld_password.getText());
                if (loginUser == null){
                    //EĞER KULLANICI BULUNAMAZ İSE HELPER SINIFINDAKI UYGUN OLAN MESAJI ÇAĞIR
                    Helper.showMessage("notFound");
                }else {
                    //EĞER KULLANICI BULUNUR İSE GIRIŞ IZNI VERMEK
                    AdminView adminView = new AdminView(loginUser);
                    //YENİ TABLO AÇILINCA GİRİŞ UYGULAMASINI KAPATMAK
                    dispose();
                }
            }
        });
    }
}
