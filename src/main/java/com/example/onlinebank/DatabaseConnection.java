package com.example.onlinebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/online_bank_db";

    private static final String USER = "postgres";
    private static final String PASSWORD = "ТВОЙ_ПАРОЛЬ_ОТ_POSTGRES";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
