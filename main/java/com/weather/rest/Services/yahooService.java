package com.weather.rest.Services;

import com.weather.rest.DAO.WindDAO;
import com.weather.rest.Domain.Forecast;
import com.weather.rest.Domain.ForecastResponse;
import com.weather.rest.Domain.Wind;
import com.weather.rest.Proxy.yahooProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Leo on 21/10/2016.
 */
@Component
public class yahooService
{
    @Autowired
    private yahooProxy proxy;

    public ForecastResponse saveForecast(String city, String country)
    {
        ForecastResponse response = proxy.getForecast(city,country);

        return response;
    }

}
