package carRental.view;

import carRental.business.BrandManager;
import carRental.core.Helper;
import carRental.entity.Brand;

import javax.swing.*;

//BRAND ICIN LAYOUT DAN EXTEND EDİLDİ
public class BrandView extends Layout {
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private Brand brand;
    private BrandManager brandManager;

    //ICI DOLU BIR BRAND YOLLARSAK GUNCELLEME ISLEMI YAPACAGIMIZI - ICI BOS BIR BRAND YOLLARSAK EKLEME ISLEMI YAPACAGIMIZI ANLATACAGIZ
    public BrandView(Brand brand) {
        this.brandManager = new BrandManager();
        this.brand = brand;
        //OLUŞTURULAN ANA JPANELI SISTEME EKLEME
        this.add(container);
        //LAYOUTDAN ELDE EDİLEN METOD
        this.guiInitilaze(300, 200);
        //BIRDEN FAZLA SAVE VE GUNCELLEME ISLEMINI AYNI ISLEM ICERISINDE GERCEKLESTIRMEK
        if (brand != null){
            this.fld_brand_name.setText(brand.getName());
        }
        //BUTONA TIKLANILDIGINDA BOS ISE FILL - DOLU ISE KAYDETME (DONE) ISLEMLERINI GERCEKLESTIRELIM
        btn_brand_save.addActionListener(e -> {
            //FILL
            if (Helper.isFieldEmpty(this.fld_brand_name)) {
                Helper.showMessage("fill");
            } else {
                //GUNCELLEME
                boolean result ;
                if (this.brand == null){
                    Brand obj = new Brand(fld_brand_name.getText());
                    result = this.brandManager.save(obj);
                }else {
                    this.brand.setName(fld_brand_name.getText());
                    result = this.brandManager.update(this.brand);
                }
                //KAYDETME
                if (result){
                    Helper.showMessage("done");
                    dispose();
                }else {
                    Helper.showMessage("error");
                }
            }
        });
    }

}
