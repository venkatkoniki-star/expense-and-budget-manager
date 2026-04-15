package main;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "vksaaho123";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


