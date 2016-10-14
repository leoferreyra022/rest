package com.weather.rest.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Leo on 03/10/2016.
 */
public class singletonConnection
{
        private Connection connection;
        private static singletonConnection instance;
        private static String url;
        private static String username;
        private static String password;

    private singletonConnection(String url, String username, String password) throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            if (this.connection!=null)System.out.println("Conectado a la base de datos");
        } catch (SQLException ex) {
            System.out.println("Conexion fallida  : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static singletonConnection getInstance() throws SQLException {

        if (instance == null) {
            try {
                ResourceBundle rb = ResourceBundle.getBundle("DBconnection");
                url = rb.getString("url");
                username = rb.getString("username");
                password = rb.getString("password");
                instance = new singletonConnection(url, username, password);
            }
            catch(Exception e){System.out.println("Error: "+e.getMessage());}
        }
        else if (instance.getConnection().isClosed()) {
            instance = new singletonConnection(url,username,password);
        }
        return instance;
    }
}
