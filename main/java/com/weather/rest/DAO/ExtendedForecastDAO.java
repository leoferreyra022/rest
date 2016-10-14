package com.weather.rest.DAO;

import com.weather.rest.Domain.ExtendedForecast;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Leo on 04/10/2016.
 */
public class ExtendedForecastDAO implements DAI<ExtendedForecast>
{
    //private Connection connection = singletonConnection.getConnection();

    public ExtendedForecastDAO() throws SQLException {
    }

    @Override
    public ExtendedForecast getById(int id){return null;}

    @Override
    public List<ExtendedForecast> getList(){return null;}

    @Override
    public String insert(ExtendedForecast entity) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }
}
