package com.weather.rest.DAO;

import com.weather.rest.Config.singletonConnection;
import com.weather.rest.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Leo on 04/10/2016.
 */

@Repository
public class ForecastDAO implements DAI<Forecast> {

    @Autowired
    singletonConnection conn;
    @Autowired
    Forecast forecast;
    private Connection connection = conn.getInstance().getConnection();

    private final String INSERT = "INSERT * INTO forecast (id_wind,id_atmosphere,id_day,id_location) values(?,?,?,?) ";
    private final String DELETE = "DELETE FROM forecast WHERE id_forecast = ";
    private final String FIND_BY_ID = "SELECT * FROM forecast wind w, location l, atmosphere a, day d, forecast f "+
            "WHERE f.id_wind = w.idwind "+
            "and f.id_location = l.idlocation "+
            "and f.id_atmosphere = a.idatmosphere "+
            "and f.id_day = d.idday "+
            "and f.id_forecast =";
    private final String FIND_ALL = "SELECT * FROM forecast wind w, location l, atmosphere a, day d, forecast f"+
            "WHERE f.id_wind = w.idwind "+
            "and f.id_location = l.idlocation "+
            "and f.id_atmosphere = a.idatmosphere "+
            "and f.id_day = d.idday";

    public ForecastDAO() throws SQLException {
    }

    @Override
    public Forecast getById(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(FIND_BY_ID + id);
            while(rs.next())
            {
                Atmosphere atmosphere = AtmosphereDAO.getAtmosphere(rs);
                Wind wind = WindDAO.getWind(rs);
                Location location = LocationDAO.getLocation(rs);
                CurrentDay currentDay = CurrentDayDAO.getCurrentDay(rs);

                return new Forecast.ForecastBuilder().withAtmosphere(atmosphere).withCurrentDay(currentDay)
                        .withLocation(location).withWind(wind).createForecast();
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
        List<Forecast> forecastList = new LinkedList<>();
        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Atmosphere atmos = AtmosphereDAO.getAtmosphere(rs);
                Wind wind = WindDAO.getWind(rs);
                Location loc = LocationDAO.getLocation(rs);
                CurrentDay day = CurrentDayDAO.getCurrentDay(rs);
                /* -------- mock items -------
                Atmosphere atmos = Atmosphere.AtmosphereBuilder.anAtmosphere().createDefaultAtmosphere();
                Wind wind = Wind.WindBuilder.aWind().createDefaultWind();
                Location loc = Location.LocationBuilder.aLocation().createDefaultLocation();
                CurrentDay day = CurrentDay.CurrentDayBuilder.aCurrentDay().createDefaultCurrentDay();
                */
                forecast.setCurrentDay(day);
                forecast.setAtmosphere(atmos);
                forecast.setWind(wind);
                forecast.setLocation(loc);
                forecastList.add(forecast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forecastList;
    }

    @Override
    public String insert(Forecast entity) {
        String msg = "Forecaste insertion succesfull";
        PreparedStatement stmnt = null;
        int result = 0;
        try {
            stmnt = connection.prepareStatement(INSERT);
            stmnt.setInt(1,entity.getId_forecast());
            stmnt.setInt(2,entity.getWind().getIdWind());
            stmnt.setInt(3,entity.getAtmosphere().getIdAtmosphere());
            stmnt.setInt(4,entity.getLocation().getIdLocation());
            result = stmnt.executeUpdate();
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
            if(result==0)return "Fallo al insertar Forecast";
            else return msg;
        }
    }

    @Override
    public String delete(int id)
    {
        String msg = "Delete succesfull";
        PreparedStatement statement = null;
        int result=0;

        try {
            statement = connection.prepareStatement(DELETE + id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
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
            if(result==0)return "Fallo al borrar Forecast";
            else return msg;
        }
    }
}
