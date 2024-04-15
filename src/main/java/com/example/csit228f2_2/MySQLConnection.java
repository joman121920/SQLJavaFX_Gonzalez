package com.example.csit228f2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/sqljavafx";
    public static final String USERNAME = "hello";
    public static final String PASSWORD = "banana";
    public static Connection getConnection(){
        Connection c = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("EYYYYYYYY OKAY KAAYU, 5.0 na");
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
