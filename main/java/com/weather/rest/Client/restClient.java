package com.weather.rest.Client;

import org.springframework.stereotype.Service;

import javax.ws.rs.*;
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
