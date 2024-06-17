
package com.proit.pe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
     public static final String DB_NAME = "personal_expenditure_manager";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return getConnection(DB_NAME, USER_NAME, PASSWORD);
    }

    public static Connection getConnection(String DBName, String userName, String password) throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/" + DBName;
        return DriverManager.getConnection(URL, userName, password);
    } 
}