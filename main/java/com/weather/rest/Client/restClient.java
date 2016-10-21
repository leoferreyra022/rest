package com.weather.rest.Client;

import com.weather.rest.Domain.ForecastResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by Leo on 15/10/2016.
 */
@Component
public interface restClient {

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    ForecastResponse getForecast(@QueryParam(value = "q") String q);

}
