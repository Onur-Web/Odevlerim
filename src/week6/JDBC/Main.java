package week6.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/university";
        String username = "postgres";
        String password = "onur123";

        Connection cName = null;
        Statement sName = null;
        ResultSet rsname = null;
        System.out.println("-------------------------------");
        try {
            cName = DriverManager.getConnection(url, username, password);
            sName = cName.createStatement();

            String sqlSelect = "SELECT * FROM employees";
            rsname = sName.executeQuery(sqlSelect);

            while (rsname.next()) {
                int id = rsname.getInt("id");
                String name = rsname.getString("name");
                String position = rsname.getString("position");
                double salary = rsname.getDouble("salary");

                System.out.println("ID: " + id + "\nName: " + name + "\nPosition: " + position + "\nSalary: " + salary);
                System.out.println("-------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rsname != null) rsname.close();
                if (sName != null) sName.close();
                if (cName != null) cName.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}