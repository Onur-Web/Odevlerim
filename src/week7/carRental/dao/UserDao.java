package week7.carRental.dao;

import week7.carRental.core.Db;
import week7.carRental.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    private final Connection con;

    //DB CLASSINDA OLUŞTURMUŞ OLDUĞUMUZ CONNECTION METODUNA EŞİTLENDİ
    public UserDao() {
        this.con = Db.getInstance();
    }

    //BÜTÜN USERLARI LİSTELİDİĞİMİZ(ÇEKTİĞİMİZ) VE MATCH METODUNUN KULLANIMI
    public ArrayList<User> findAll() {
        ArrayList<User> userArrayList = new ArrayList<>();
        String sql = "SELECT * FROM public.user";
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                userArrayList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }

    //VERİ TABANINA KULLANICI ADI VE ŞİFRE YOLLAYIP ÖYLE BİR KULLANICI OLUP OLMADIĞINI SORGULAMAMIZ LAZIM VE MATCH METODUNUN KULLANIMI
    public User findByLogin(String username, String password) {
        User obj = null;
        String quarry = "SELECT * FROM public.user WHERE user_name = ? AND user_pass = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(quarry);
            pr.setString(1, username);
            pr.setString(2, password);
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
    public User match(ResultSet rs) throws SQLException {
        User obj = new User();
        obj.setId(rs.getInt("user_id"));
        obj.setUsername(rs.getString("user_name"));
        obj.setPassword(rs.getString("user_pass"));
        obj.setRole(rs.getString("user_role"));
        return obj;
    }
}
