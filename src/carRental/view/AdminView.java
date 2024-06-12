package carRental.view;

import carRental.business.BrandManager;
import carRental.business.CarManager;
import carRental.business.ModelManager;
import carRental.core.ComboItem;
import carRental.core.Helper;
import carRental.entity.Brand;
import carRental.entity.Car;
import carRental.entity.Model;
import carRental.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

//ADMIN ICIN LAYOUT DAN EXTEND EDİLDİ
public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scl_brand;
    private JTable tbl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private JComboBox cmb_s_model_brand;
    private JComboBox cmb_s_model_type;
    private JComboBox cmb_s_model_fuel;
    private JComboBox cmb_s_model_gear;
    private JButton btn_search_model;
    private JButton btn_cancel_model;
    private JPanel pnl_car;
    private JScrollPane scrl_car;
    private User user;//LOGIN OLMUŞ BIRISI BURADA İŞLEM YAPACAĞI ICIN USERA IHTIYACIMIZ VAR
    private DefaultTableModel tmdl_brand = new DefaultTableModel();//TABLOLAR UZERINDE BIR ISLEM YAPABILMEK ICIN
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private DefaultTableModel tmdl_car = new DefaultTableModel();
    private CarManager carManager;
    private JPopupMenu car_Menu;
    private JTable tbl_car;
    private BrandManager brandManager;
    private ModelManager modelManager;
    private JPopupMenu brand_Menu;
    private JPopupMenu model_Menu;
    private Object[] col_model;
    private Object[] col_car;

    private JPanel pnl_booking;
    private JTable tbl_booking;
    private JScrollPane scrl_booking;
    private JComboBox cmb_booking_gear;
    private JComboBox cmb_booking_fuel;
    private JComboBox cmb_booking_type;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JButton btn_booking_search;
    private JButton btn_cncl_booking;
    private JPopupMenu booking_menu;
    private DefaultTableModel tmdl_booking = new DefaultTableModel();
    ;

    //TABLO İŞLEMLERİ İÇİN OLUŞTURULAN BOŞ CONSTRUCTER VE HERZAMAN USER ALACAK
    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();
        //OLUŞTURULAN ANA JPANELI SISTEME EKLEME
        this.add(container);
        //LAYOUTDAN ELDE EDİLEN METOD
        this.guiInitilaze(1000, 500);
        //PARAMETREDEN GELEN USERA EŞİTLEMEK
        this.user = user;
        //NULL İSE BU PENCEREYİ KAPATMAYA ZORLAMAK
        if (this.user == null) {
            dispose();
        }
        //TABLODA OLUŞTURDUĞUMUZ JLABEL DE GİRİŞ YAPAN KİŞİNİN İSMİNİ GÖRMEK İSTEDİĞİMİZ İÇİN
        this.lbl_welcome.setText("Hoşgeldiniz " + this.user.getUsername());
        //BRAND TAB MENU
        loadBrandTable();
        loadBrandComponent();
        //MODEL TAB MENU
        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();
        //CAR TAB MENU
        loadCarTable();
        loadCarComponents();
        //BOOKING TAB MENU
        loadBookingTable(null);
        loadBookingComponent();
        loadBookingFilter();
    }

    private void loadBookingComponent() {
        tableRowSelect(this.tbl_booking);
        this.booking_menu = new JPopupMenu();
        this.booking_menu.add("Rezervasyon Yap").addActionListener(e -> {
            int selectCarID = this.getTableSelectedRow(this.tbl_booking, 0);
            BookingView bookingView = new BookingView(this.carManager.getById(selectCarID), this.fld_strt_date.getText(), this.fld_fnsh_date.getText());
            bookingView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBookingTable(null);
                    loadBookingFilter();
                }
            });
        });
        this.tbl_booking.setComponentPopupMenu(booking_menu);
        this.tbl_booking.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            private void showPopup(MouseEvent e) {
                booking_menu.show(e.getComponent(), e.getX(), e.getY());
            }
        });


        this.tbl_booking.setComponentPopupMenu(booking_menu);
        btn_booking_search.addActionListener(e -> {
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    fld_strt_date.getText(),
                    fld_fnsh_date.getText(),
                    (Model.Type) cmb_booking_type.getSelectedItem(),
                    (Model.Gear) cmb_booking_gear.getSelectedItem(),
                    (Model.Fuel) cmb_booking_fuel.getSelectedItem()
            );

            ArrayList<Object[]> carBookingRow = this.carManager.getForTable(this.col_car.length, carList);
            loadBookingTable(carBookingRow);
        });

        btn_cncl_booking.addActionListener(e -> {
            loadBookingFilter();

        });
    }

    private void loadBookingTable(ArrayList<Object[]> carList) {
        Object[] col_booking_list = {"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yıl", "Tip", "Yakıt Türü", "Vites"};
        createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, carList);
    }

    public void loadBookingFilter() {
        this.cmb_booking_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_booking_type.setSelectedItem(null);
        this.cmb_booking_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_booking_gear.setSelectedItem(null);
        this.cmb_booking_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_booking_fuel.setSelectedItem(null);
    }


    public void loadCarTable() {
        col_car = new Object[]{"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yıl", "Tip", "Yakıt Türü", "Vites"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length, this.carManager.findAll());
        createTable(this.tmdl_car, this.tbl_car, col_car, carList);
    }

    private void loadCarComponents() {
        tableRowSelect(this.tbl_car);
        this.car_Menu = new JPopupMenu();
        this.car_Menu.add("Yeni").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_Menu.add("Güncelle").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_car, 0);
            CarView carView = new CarView(this.carManager.getById(selectModelId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_Menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectCarId = this.getTableSelectedRow(tbl_car, 0);
                if (this.carManager.delete(selectCarId)) {
                    Helper.showMessage("done");
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_car.setComponentPopupMenu(car_Menu);
        this.tbl_car.addMouseListener(new MouseAdapter() {

            //MOUSE CLICK KOMUTLARINI ACAR
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            //FARENIN KONUM KORDINATLARINDAKI NOKTA ILE İLETISIM KURMAMIZI SAGLAR
            private void showPopup(MouseEvent e) {
                car_Menu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }


    public void loadModelFilter() {
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        loadModelFilterBrand();
    }

    public void loadModelFilterBrand() {
        this.cmb_s_model_brand.removeAllItems();
        for (Brand obj : brandManager.findAll()) {
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);
    }


    private void loadModelTable(ArrayList<Object[]> modelList) {
        this.col_model = new Object[]{"Model ID", "Marka", "Model Adı", "Tip", "Yıl", "Yakıt Türü", "Vites"};
        if (modelList == null) {
            modelList = this.modelManager.getForTable(this.col_model.length, this.modelManager.findAll());
        }
        createTable(this.tmdl_model, this.tbl_model, col_model, modelList);
    }

    //BRAND MANAGERDAN ALDIGIMIZ METOD
    public void loadBrandTable() {
        //TABLONUN SÜTUNLARINI OLUŞTURMAK
        Object[] col_brand = {"Marka ID", "Marka Adı"};
        //BRANDMANAGER DAN VERILERIMIZI CEKIYORUZ
        ArrayList<Object[]> brandArrayList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandArrayList);
    }

    public void loadBrandComponent() {
        //MOUSE ILE BIRYERI SECEBILMEMIZI SAGLAR
        tableRowSelect(this.tbl_brand);
        //TABLOLARDA İŞLEM YAPABILMEK ICIN(EKLEME-CIKARMA-DUZENLEME) POPUPMENU LERE IHTIYAC DUYULUR
        this.brand_Menu = new JPopupMenu();
        this.brand_Menu.add("Yeni").addActionListener(e -> {
            //KAYIT ISLEMI YAPMAMIZ ICIN
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);//BRAND DE YAPILAN DEGİŞİKLİKLER MODEL DE DE YAPILSIN SISTEM KAPATILMADAN
                    loadModelFilterBrand();
                }
            });
        });
        this.brand_Menu.add("Güncelle").addActionListener(e -> {
            //GUNCELLEME YAPABILMEMIZ ICIN
            int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
            //SECILEN IDYE GORE VERI TABANINDAKI BRANDI CEKMEMIZ LAZIM
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);//BRAND DE YAPILAN DEGİŞİKLİKLER MODEL DE DE YAPILSIN SISTEM KAPATILMADAN
                    loadModelFilterBrand();
                    loadCarTable();
                }
            });
        });
        this.brand_Menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
                if (this.brandManager.delete(selectBrandId)) {
                    Helper.showMessage("done");
                    loadBrandTable();
                    loadModelTable(null);//BRAND DE YAPILAN DEGİŞİKLİKLER MODEL DE DE YAPILSIN SISTEM KAPATILMADAN
                    loadModelFilterBrand();
                    loadCarTable();
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_brand.setComponentPopupMenu(brand_Menu);
        //MOUSE KULLANIMINI EKLER
        this.tbl_brand.addMouseListener(new MouseAdapter() {

            //MOUSE CLICK KOMUTLARINI ACAR
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            //FARENIN KONUM KORDINATLARINDAKI NOKTA ILE İLETISIM KURMAMIZI SAGLAR
            private void showPopup(MouseEvent e) {
                brand_Menu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    private void loadModelComponent() {
        tableRowSelect(this.tbl_model);
        this.model_Menu = new JPopupMenu();
        this.model_Menu.add("Yeni").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.model_Menu.add("Güncelle").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_model, 0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.model_Menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectModelId = this.getTableSelectedRow(tbl_model, 0);
                if (this.modelManager.delete(selectModelId)) {
                    Helper.showMessage("done");
                    loadModelTable(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_model.setComponentPopupMenu(model_Menu);
        //ARAMA BUTONUNU AKTIF ETMEK
        this.btn_search_model.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
            int brandId = 0;
            if (selectedBrand != null) {
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem()
            );
            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });

        this.tbl_model.addMouseListener(new MouseAdapter() {

            //MOUSE CLICK KOMUTLARINI ACAR
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            //FARENIN KONUM KORDINATLARINDAKI NOKTA ILE İLETISIM KURMAMIZI SAGLAR
            private void showPopup(MouseEvent e) {
                model_Menu.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        this.btn_cancel_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            loadModelTable(null);
        });

    }

    //TARIH BILGILERINI ISTEDIĞIMIZ SEKILDE KULLANICIYA YAZDIRMAK
    private void createUIComponents() throws ParseException {
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_strt_date.setText("05/06/2024");
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_fnsh_date.setText("08/06/2024");
    }
}
