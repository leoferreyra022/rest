package com.weather.rest.DAO;

import com.weather.rest.Domain.CurrentDay;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Leo on 20/10/2016.
 */
@Component
public class CurrentDayDAO implements DAI<CurrentDay> {
    @Override
    public CurrentDay getById(int id) {
        return null;
    }

    @Override
    public List<CurrentDay> getList() {
        return null;
    }

    @Override
    public String insert(CurrentDay entity) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    public static CurrentDay getCurrentDay(ResultSet resultSet) throws SQLException
    {
        CurrentDay.CurrentDayBuilder currentDayBuilder = CurrentDay.CurrentDayBuilder.aCurrentDay()
                .withDate(resultSet.getString("date"))
                .withDescription(resultSet.getString("pressure"))
                .withMaxtemp(resultSet.getInt("maxTemp"))
                .withMintemp(resultSet.getInt("mintemp"))
                .withDayofWeek(resultSet.getInt("day"));
        return currentDayBuilder.createCurrentDay();
    }
}
