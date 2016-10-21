package com.weather.rest.DAO;

import com.weather.rest.Domain.Location;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Leo on 20/10/2016.
 */
public class LocationDAO implements DAI<Location>{
    @Override
    public Location getById(int id) {
        return null;
    }

    @Override
    public List<Location> getList() {
        return null;
    }

    @Override
    public String insert(Location entity) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    public static Location getLocation(ResultSet resultSet) throws SQLException
    {
        Location.LocationBuilder locationBuilder = Location.LocationBuilder.aLocation()
                .withCity(resultSet.getString("city"))
                .withRegion(resultSet.getString("region"))
                .withCountry(resultSet.getString("country"));
        return locationBuilder.createLocation();
    }
}
