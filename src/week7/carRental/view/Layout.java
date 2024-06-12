package week7.carRental.view;

import week7.carRental.core.Helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

//JFRAME DEN EXTEND EDİLDİ
public class Layout extends JFrame {

    public void guiInitilaze(int width, int height) {
        //UYGULAMA KAPATILDIĞINDA UYGULAMA KAPANIR AMA JAVA ÇALIŞMAYA DEVAM EDER
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //UYGULAMA ADI
        this.setTitle("Rent a Car");
        //EKRAN BOYUTU
        this.setSize(width, height);
        //EKRANI ORTALAMA FORMULU ISLEDIGIMIZ HELPERDAN METODU ALMA VE EKRANI ORTALAMA
        this.setLocation(Helper.getLocationPoint("x", this.getSize()), Helper.getLocationPoint("y", this.getSize()));
        //EKRANI GORUNUR HALE GETİRMEK
        this.setVisible(true);
    }

    //BU TABLONUN KOLONLARINI BELİRLEME - OLUŞTURULAN SÜTUNLARI BRAND TABLOSUNUN ICINE ATMAK - TABLO YERLERININ MANUEL DEĞİŞİMİNİ ENGELLEMEK
    // - TABLONUN MANUEL DÜZENLENEBILMESINI ENGELLEMEK - TABLO KENDINI TEKRAR ETMEDEN SADECE GUNCEL OLAN VERIYI VERSIN - OLUSTURULAN ARRAY ICINI DOLASMAK
    public void createTable(DefaultTableModel model, JTable table, Object[] columns, ArrayList<Object[]> rows) {
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        table.setEnabled(false);

        DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
        clearModel.setRowCount(0);

        if (rows == null) {
            rows = new ArrayList<>();
        }
        for (Object[] row : rows) {
            model.addRow(row);
        }
    }

    public int getTableSelectedRow(JTable table, int index) {
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(), index).toString());
    }

    public void tableRowSelect (JTable table){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(selected_row,selected_row);
            }
        });



    }
}
