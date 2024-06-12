package week7.carRental.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static Db instance = null;
    private Connection connection = null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/rentacar";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "onur123";
    //SQL İLE BAĞLANTI KURMAK
    private Db() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //PRIVATE TANIMLADIĞIMIZ DEĞERLERİN DEĞİŞTİRELEMEMESİ İÇİN SADECE GET METODU OLUŞTURULDU
    public Connection getConnection() {
        return connection;
    }
    //Singleton Design Pattern --> Sadece hafızada oluşturulmuşu vermek için yazılan metod
    public static Connection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Db();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance.getConnection();
    }
}
