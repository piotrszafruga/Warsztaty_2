package com.company.models;

import java.net.URL;
import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {
    private static final String url = "jdbc:mysql://localhost:3306/warsztaty_2?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "coderslab";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
