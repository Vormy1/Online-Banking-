package com.example.onlinebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для подключения к PostgreSQL
 */
public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/online_bank_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234"; // ← ТВОЙ ПАРОЛЬ

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("DB connection failed", e);
        }
    }
}
