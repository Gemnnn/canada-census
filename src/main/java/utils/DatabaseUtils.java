package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/canadacensusdb?useSSL=false";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, username, password);
    }
}
