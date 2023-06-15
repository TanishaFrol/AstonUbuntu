package app.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionToDB {

    private static String url;
    private static String name;
    private static String password;

    static {
        FileInputStream fis;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
            url = properties.getProperty("db.host");
            name = properties.getProperty("db.login");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResultSet connect(String statementStr) {
        Connection connection = null;
        ResultSet result = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            result = statement.executeQuery(statementStr);

        } catch (Exception ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }
}
