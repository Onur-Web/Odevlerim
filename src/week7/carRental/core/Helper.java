package week7.carRental.core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    //EKRANI ORTALAMA FORMUL METHODU
    public static int getLocationPoint(String type, Dimension size) {
        switch (type) {
            case "x":
                return (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y":
                return (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default:
                return 0;
        }
    }

    //UYGULAMANIN TEMASINI İSTEĞİMİZ DOĞRULTUSUNDA DEĞİŞTİRMEK
    public static void setTheme() {
        String theme = "Nimbus";
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (theme.equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    //UYGULAMADAKI USERNAME ve PASSWORDU GETİR BOŞLUK VARSA SİL BUNA RAĞMEN BOŞ İSE FIELDLERININ DOLU OLUP OLMADIĞINI KONTROL ETME METHODU
    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    //DURUMA GÖRE KULLANICIYA MESAJ GONDERMEK
    public static void showMessage(String str) {
        optionPaneTR();
        String message;
        String title;
        switch (str) {
            case "fill":
                message = "Lütfen Tüm Alanları Doldurunuz";
                title = "Hata";
                break;
            case "done":
                message = "İşlem Başarılı";
                title = "Başarılı";
                break;
            case "notFound":
                message = "Kayıt Bulunamadı";
                title = "Hata";
                break;
            case "error":
                message = "Hatalı İşlem Yaptınız";
                title = "Hata";
            default:
                message = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    //SİLME İŞLEMİNDE EMİNMİSİN DİYE SORMAK
    public static boolean confirm(String str) {
        optionPaneTR();
        String msg;
        if (str.equals("sure")) {
            msg = "Bu İşlemi Yapmak İstediğine Emin misin ?";
        } else {
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg, "Emin misin ? ", JOptionPane.YES_NO_OPTION) == 0;
    }

    //ARAYÜZDE ÇOK FAZLA GİRİŞ OLDUĞUNDA KULLILACAK METHOD
    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    //SİLMEK İSTEDİĞİNE EMİNMİSİN YES - NO YU TURKCEYE CEVİRMEK
    public static void optionPaneTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }
}
