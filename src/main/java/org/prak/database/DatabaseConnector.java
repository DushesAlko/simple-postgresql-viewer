package org.prak.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

    public static Connection getConnection() throws SQLException {
        try (InputStream input = DatabaseConnector.class.getResourceAsStream("/application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");
            return DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException("Failed to load database properties", e);
        }
    }
}
