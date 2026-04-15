package util;

import java.sql.Connection;
import java.sql.DriverManager;

    public class DBConnection {

        // Database URL (DB name = expense_manager)
        private static final String URL = "jdbc:mysql://localhost:3306/expense_manager";

        private static final String USER = "root";

        private static final String PASSWORD = "vksaaho123";

        // Method to get connection
        public static Connection getConnection() {
            try {
                // Create connection using DriverManager
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

                return conn;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

