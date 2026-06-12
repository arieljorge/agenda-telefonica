package com.github.arieljorge.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        final String url, username, password;

        url = ApplicationProperties.get("db.url");
        username = ApplicationProperties.get("db.username");
        password = ApplicationProperties.get("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}
