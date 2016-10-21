package com.weather.rest.Resources;

import com.weather.rest.DAO.*;
import com.weather.rest.Domain.Atmosphere;
import com.weather.rest.Domain.Forecast;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Leo on 18/10/2016.
 */
@Resource
@Path("/resources")
public class AppResources
{
    @Autowired
    private AtmosphereDAO atmosphereDAO;
    @Autowired
    private CurrentDayDAO currentDayDAO;
    @Autowired
    private ExtendedForecastDAO extendedForecastDAO;
    @Autowired
    private ForecastDAO forecastDAO;
    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private WindDAO windDAO;

    @GET
    @Path("/Forecast/{id_forecast}")
    @Produces("application/json")
    public Forecast getForecast(@PathParam("id_forecast") int input) {
        return forecastDAO.getById(input);
    }

    @GET
    @Path("/AllForecast/")
    @Produces("application/json")
    public List<Forecast> getAllForecast() {
        return forecastDAO.getList();
    }
}
