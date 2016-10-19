package com.weather.rest.Resources;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by Leo on 18/10/2016.
 */
@Resource
@Path("/resources")
public class AppResources {

    @GET
    @Path("/{id_forecast}")
    @Produces("text/plain")
    public String getForecast(@PathParam("id_forecast") String input) {
        return input;
    }
}
