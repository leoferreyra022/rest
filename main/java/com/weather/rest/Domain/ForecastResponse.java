package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Leo on 21/10/2016.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse
{
    private Query query;

    public ForecastResponse(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "ForecastResponse{" +
                "query=" + query +
                '}';
    }
}
