package com.weather.rest.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Leo on 03/10/2016.
 */
@Component
public class singletonConnection {
    @Autowired
    private static singletonConnection instance;
    private static String url;
    private static String username;
    private static String password;
    private Connection connection;

    private singletonConnection(String url, String username, String password) throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            if (this.connection != null) System.out.println("Conectado a la base de datos");
        } catch (SQLException ex) {
            System.out.println("Conexion fallida  : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static singletonConnection getInstance() throws SQLException {

        if (instance == null) {
            try {
                ResourceBundle rb = ResourceBundle.getBundle("DBconnection");
                url = rb.getString("url");
                username = rb.getString("username");
                password = rb.getString("password");
                instance = new singletonConnection(url, username, password);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (instance.getConnection().isClosed()) {
            instance = new singletonConnection(url, username, password);
        }
        return instance;
    }

    @Bean
    public Connection getConnection() {
        return connection;
    }
}
