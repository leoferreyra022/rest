package com.weather.rest.DAO;

import com.weather.rest.Config.singletonConnection;
import com.weather.rest.Domain.ExtendedForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Leo on 04/10/2016.
 */
@Repository
public class ExtendedForecastDAO implements DAI<ExtendedForecast> {

    @Autowired
    singletonConnection conn;
    private Connection connection = conn.getConnection();

    public ExtendedForecastDAO() throws SQLException {
    }

    @Override
    public ExtendedForecast getById(int id) {
        return null;
    }

    @Override
    public List<ExtendedForecast> getList() {
        return null;
    }

    @Override
    public String insert(ExtendedForecast entity) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }
}
