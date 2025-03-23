package com.connectorfactory.emp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection buildConnection() {
        String url = "jdbc:mysql://localhost:3306/emp_db";
        String userName = "root";
        String password = "root123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            return con;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
