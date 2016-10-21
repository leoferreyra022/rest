package com.weather.rest.Proxy;

import com.weather.rest.Client.restClient;
import com.weather.rest.Domain.ForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Leo on 18/10/2016.
 */
@Component
public class yahooProxy
{
    @Autowired
    private restClient client;

    private String queryYahoo1 = "https://query.yahooapis.com/v1/public/yql?" +
            "q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20" +
            "where%20text%3D%22";
    private String queryYahoo2="%2C%20";
    private String queryYahoo3="%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    public ForecastResponse getForecast(String city, String country)
    {
        ForecastResponse response = client.getForecast(queryYahoo1+city+queryYahoo2+country+queryYahoo3);
        return response;
    }

    /*public void Mapping()
    {

    }*/

}
