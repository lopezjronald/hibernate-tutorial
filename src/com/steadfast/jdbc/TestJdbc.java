package com.steadfast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/hbstudent2";
            String username = "postgres";
            String password = "password";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Opened database successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
