package week7.carRental.dao;

import week7.carRental.core.Db;
import week7.carRental.entity.Brand;

import java.sql.*;
import java.util.ArrayList;

public class BrandDao {
    private final Connection con;

    //DB CLASSINDA OLUŞTURMUŞ OLDUĞUMUZ CONNECTION METODUNA EŞİTLENDİ
    public BrandDao() {
        this.con = Db.getInstance();
    }

    //BÜTÜN BRANDLERİ LİSTELİDİĞİMİZ(ÇEKTİĞİMİZ) VE MATCH METODUNUN KULLANIMI
    public ArrayList<Brand> findAll() {
        ArrayList<Brand> brandArrayList = new ArrayList<>();
        String sql = "SELECT * FROM public.brand ORDER BY brand_id ASC";
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                brandArrayList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandArrayList;
    }

    //EKLEME (KAYDETME) ISLEVİNİ GERCEKLESTIRMEK ICIN OLUSTURULAN METOD
    public boolean save(Brand brand) {
        String query = "INSERT INTO public.brand (brand_name) VALUES (?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, brand.getName());
            return pr.executeUpdate() != -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    //GUNCELLEME ISLEVİNİ GERCEKLESTIRMEK ICIN OLUSTURULAN METOD
    public boolean update(Brand brand) {
        String query = "UPDATE public.brand SET brand_name = ? WHERE brand_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, brand.getName());
            pr.setInt(2, brand.getId());
            return pr.executeUpdate() != -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    //SILME ISLEVİNİ GERCEKLESTIRMEK ICIN OLUSTURULAN METOD
    public boolean delete(int id) {
        String quarry = "DELETE FROM public.brand WHERE brand_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(quarry);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //DEGISTIRILEN BRANDI DATABASEDEN ALIP BIR BRANDA AKTARIP BUNU BRANDVIEWIN ICERISINE ATMAK
    public Brand getById(int id) {
        Brand obj = null;
        String query = "SELECT * FROM public.brand WHERE brand_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //YUKARIDA KULLANILAN METHODLARIN(2) MAPLEME İŞLEMİNİ GEWRÇEKLEŞTİREN METOD (KOD TEKRARINI ENGELLEMEK İÇİN) VE İLERİDE YENİ BİR SÜTUN EKLENECEK OLURSA SADECE BURAYA EKLEMEMİZ YETERLİ
    public Brand match(ResultSet rs) throws SQLException {
        Brand obj = new Brand();
        obj.setId(rs.getInt("brand_id"));
        obj.setName(rs.getString("brand_name"));

        return obj;
    }

}
