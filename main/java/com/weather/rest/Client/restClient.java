package com.weather.rest.Client;

import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by Leo on 15/10/2016.
 */
@Service
public class restClient {

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response someMethod(@QueryParam(value = "someQueryParamHere") String query)
            throws IllegalAccessException, InstantiationException {

        return Response.class.newInstance();
    }
}
