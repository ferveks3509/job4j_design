package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream("./src/main/resources/app.properties")) {
            properties.load(in);
        }
        String url = properties.getProperty("url");
        String login = properties.getProperty("username");
        String password = properties.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
