package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost/aplikasipln";
    private static final String DB_USERNAME = "root";
    private static final String FB_PASSWORD = "";



    public static Connection getConnection(){
        try {
            java.sql.Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,FB_PASSWORD);
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
