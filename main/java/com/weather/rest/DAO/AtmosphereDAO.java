package com.weather.rest.DAO;

import com.weather.rest.Domain.Atmosphere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Leo on 18/10/2016.
 */
@Component
public class AtmosphereDAO implements DAI<Atmosphere>
{
    @Override
    public Atmosphere getById(int id) {
        return null;
    }

    @Override
    public List<Atmosphere> getList() {
        return null;
    }

    @Override
    public String insert(Atmosphere entity) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    public static Atmosphere getAtmosphere(ResultSet resultSet) throws SQLException {
        Atmosphere.AtmosphereBuilder atmosphereBuilder = Atmosphere.AtmosphereBuilder.anAtmosphere()
                .withHumidity(resultSet.getInt("humidity"))
                .withPressure(resultSet.getDouble("pressure"))
                .withVisibility(resultSet.getDouble("visibility"))
                .withRising(resultSet.getDouble("rising"));
        return atmosphereBuilder.createAtmosphere();
    }
}
