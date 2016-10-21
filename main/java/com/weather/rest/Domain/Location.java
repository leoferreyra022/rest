package com.weather.rest.Domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Leo on 03/10/2016.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location
{
    private int idLocation;
    private String city;
    private String country;
    private String region;

    private Location(String city, String country, String region)
    {
        this.city = city;
        this.country = country;
        this.region = region;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
    @Component
    public static class LocationBuilder
    {
        private String city;
        private String country;
        private String region;

        public LocationBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public LocationBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public LocationBuilder withRegion(String region) {
            this.region = region;
            return this;
        }

        public static LocationBuilder aLocation()
        {return new LocationBuilder();}

        public Location createLocation() {
            return new Location(city, country, region);
        }

        public Location createDefaultLocation() {
            return new Location("Cordoba", "Argentina", "Centro");
        }
    }
}
