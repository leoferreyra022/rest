package com.weather.rest.DAO;

import com.weather.rest.Domain.Forecast;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Leo on 04/10/2016.
 */
@Component
public class ForecastDAO implements DAI<Forecast> {

    private Connection connection = singletonConnection.getInstance().getConnection();

    public ForecastDAO() throws SQLException {
    }

    @Override
    public Forecast getById(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM employee where id_forecast=" + id;
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Forecast.ForecastBuilder fb = new Forecast.ForecastBuilder();
                Forecast forecast = fb.createDefaultForecast();
                //f.get(rs.getInt("Employee_Id"));
                //f.setName(rs.getString("Name"));
                //f.setAge(rs.getInt("age"));
                return forecast;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception exe) {
                exe.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Forecast> getList() {
        return null;
    }

    @Override
    public String insert(Forecast entity) {
        String msg = "Forecaste insertion succesfull";
        Statement stmnt = null;
        String query = "insert into forecast values(1,1,1,1,1)";
        try {
            stmnt = connection.prepareStatement(query);
            stmnt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        } finally {
            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return msg;
        }
    }

    @Override
    public String delete(int id) {
        Statement statement = null;
        String query = "delete from forecast where id_forecast =" + id;
        try {
            statement = connection.prepareStatement(query);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
