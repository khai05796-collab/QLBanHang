package com.mycompany.do_an;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QL_banhang_DoUong;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "QL_banhang_DoUong";
    private static final String PASS = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
