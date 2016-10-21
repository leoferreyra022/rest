package com.weather.rest.DAO;

import com.weather.rest.Domain.Wind;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Leo on 18/10/2016.
 */
public class WindDAO implements DAI<Wind> {

    @Override
    public Wind getById(int id) {
        return null;
    }

    @Override
    public List<Wind> getList() {
        return null;
    }

    @Override
    public String insert(Wind entity) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    public static Wind getWind(ResultSet resultSet) throws SQLException
    {
        Wind.WindBuilder windBuilder = Wind.WindBuilder.aWind()
                .withDirection(resultSet.getString("direction"))
                .withVelocity(resultSet.getInt("velocity"));
        return windBuilder.createWind();
    }
}
