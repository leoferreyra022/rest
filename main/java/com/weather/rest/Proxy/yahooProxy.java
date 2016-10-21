package com.weather.rest.Proxy;

/**
 * Created by Leo on 18/10/2016.
 */
public class yahooProxy
{
    private String queryYahoo="https://query.yahooapis.com/v1/public/yql?" +
            "q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20" +
            "where%20text%3D%22Cordoba%2C%20ar%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

}
